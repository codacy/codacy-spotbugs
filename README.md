# Codacy SpotBugs

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/00b47dd51b964655a0329723156a3eb3)](https://www.codacy.com/gh/codacy/codacy-spotbugs?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=codacy/codacy-spotbugs&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/codacy/codacy-spotbugs.svg?style=svg)](https://circleci.com/gh/codacy/codacy-spotbugs)

This is the docker engine we use at Codacy to have [SpotBugs](https://spotbugs.github.io/) support, including the
plugins [fb-contrib](https://github.com/mebigfatguy/fb-contrib) and [Find Security Bugs](https://find-sec-bugs.github.io/).

You can also create a docker to integrate the tool and language of your choice!
Check the **Docs** section for more information.

## Requirements

- Java 1.8
- SBT
- Docker

## Usage

To change the versions of the tools you should change the versions in `build.sbt`

### Build docker

```sh
sbt "set version := \"latest\"; docker:publishLocal"
```

### Run tool

```sh
docker run -it -v $PWD:/src codacy-spotbugs:latest
```

### Run tests

We use the [codacy-plugins-test](https://github.com/codacy/codacy-plugins-test) to test our external tools integration.
You can follow the instructions there to make sure your tool is working as expected.

#### Validate documentation

```sh
sbt "run json codacy-spotbugs:latest"
```

#### Run integration tests

```sh
sbt "run pattern codacy-spotbugs:latest"
sbt "run multiple codacy-spotbugs:latest"
```

### Generate documentation

**NOTE:** To generate documentation you need to have this projects dependencies under your home. (e.g.: `~/.ivy2`)

```sh
sbt "runMain com.codacy.tools.spotbugs.DocumentationGenerator"
```

## Agent Playbook: Updating This Repository End-to-End

This section is written for an AI coding agent (or a human) tasked with updating this repo — most commonly bumping the wrapped SpotBugs version (or its bundled plugins, fb-contrib and Find Security Bugs), but also base image / orb / dependency bumps. Follow it top to bottom; it tells you what to change, how to regenerate derived files, how to test locally, and how to interpret CI so you can iterate on failures without guessing.

### 1. What this repository is

This is a **Codacy engine**: a thin Scala wrapper (`src/main/scala/com/codacy/tools/spotbugs/Engine.scala`, built on `codacy-engine-scala-seed`) that packages [SpotBugs](https://spotbugs.github.io/) — plus the [fb-contrib](https://github.com/mebigfatguy/fb-contrib) and [Find Security Bugs](https://find-sec-bugs.github.io/) SpotBugs plugins — as a Docker image Codacy's platform can run against a customer's Java/Scala source code. The `src/main/resources/docs/` directory is not just documentation — it is **machine-consumed configuration**:

- `docs/patterns.json` — the full list of SpotBugs (+ fb-contrib + Find Security Bugs) rules ("patterns") Codacy knows about, their category/level, and which are enabled by default. Generated file, do not hand-edit.
- `docs/description/description.json` + `docs/description/*.md` — human-readable titles/descriptions per pattern (converted from each bug pattern's HTML detail text), used in the Codacy UI. Generated file, do not hand-edit.
- `docs/directory-tests/*` and `docs/multiple-tests/*` — fixtures used by `codacy-plugins-test` to validate the engine actually produces the results it claims to for real Java/Scala code samples.
- `docs/tool-description.md` — short blurb about the tool, hand-maintained.

All generated artifacts above come from **`DocumentationGenerator`** (`src/main/scala/com/codacy/tools/spotbugs/DocumentationGenerator.scala`). Unlike some other Codacy engines, this generator does **not** clone an upstream repo over the network — it loads the SpotBugs core plugin plus the fb-contrib and Find Security Bugs jars from the local sbt/Coursier dependency cache (`~/.ivy2` / `~/.cache/coursier`, resolved via `SpotBugsHelper.loadPlugins`/`PluginDefinition`, see `src/main/scala/com/codacy/tools/spotbugs/helper/SpotBugsHelper.scala`) and introspects each `BugPattern`'s metadata (category, abbreviation, HTML detail text) via the SpotBugs Java API (`edu.umd.cs.findbugs.*`). It categorizes/level-maps patterns with hardcoded `getCategory`/`getLevel` logic and infers security subcategories from a hardcoded abbreviation/keyword table (`matchingPatterns`), and marks patterns "enabled" if their id is in the hardcoded `defaultPatterns` list — all in `DocumentationGenerator.scala`. This means the generator needs its dependencies already downloaded locally (run `sbt compile` or `sbt test` first so the jars land in the cache) but does **not** need internet access at generation time itself, nor any external tool like pandoc (HTML→Markdown conversion is done in-process via the `html-to-markdown`/`Html2Markdown` library dependency).

### 2. Files that encode versions — check all of these on every update

| File | What it controls | What to check |
|---|---|---|
| `build.sbt` → `spotBugsVersion` | Which SpotBugs release is bundled | Bump to the target version, confirm the artifact exists on Maven Central (`com.github.spotbugs:spotbugs`). |
| `build.sbt` → `findsecbugsVersion` | Which Find Security Bugs plugin release is bundled | Bump only when that task specifically targets Find Security Bugs. |
| `build.sbt` → `sbContribVersion` | Which fb-contrib (`sb-contrib`) plugin release is bundled | Bump only when that task specifically targets fb-contrib. |
| `project/build.properties` → `sbt.version` | The sbt build tool version | History shows sbt version bumps (e.g. 1.6.1 → 1.7.x/1.8.x/1.9.x) have repeatedly had to be reverted after breaking CI — treat as high-risk, don't bump opportunistically alongside a tool version bump. |
| `build.sbt` → other `libraryDependencies` (`scala-xml`, `scala-java8-compat`, `html-to-markdown`, `scalatest`, `codacy-engine-scala-seed`) | Supporting Scala libraries | History shows bumping these incidentally (not as part of the requested task) has previously broken the build and had to be reverted (`d5c0f8c`, `47decb3`, `4b98a6e`). Only touch these if the task explicitly asks for it. |
| `build.sbt` → `dockerBaseImage` | Runtime the packaged app runs on | Only bump if the new tool version raises its minimum Java runtime requirement (current base is `amazoncorretto:8-alpine3.18-jre`, i.e. Java 8). |
| `.circleci/config.yml` → `codacy/base` orb | Shared CircleCI steps (checkout, sbt build, docker publish, version tagging) | Check the latest published version, but note this orb has also been reverted after breaking CI (`792a4c9`) — verify it actually works before assuming a bump is safe. |
| `.circleci/config.yml` → `codacy/plugins-test` orb | Runs `codacy-plugins-test` in CI | Check the latest published version. |

### 3. Step-by-step update procedure

1. **Bump the version(s)** in `build.sbt` as scoped by the task (typically just `spotBugsVersion`; only touch `findsecbugsVersion`/`sbContribVersion`/other dependencies/`sbt.version` if the task explicitly asks for it — see the risk notes in section 2).
2. **Resolve dependencies** so the new jar lands in the local cache: `sbt compile` (or `sbt test`).
3. **Regenerate the docs**: `sbt "runMain com.codacy.tools.spotbugs.DocumentationGenerator"` (requires step 2 to have completed so the plugin jars are present locally). Review the diff to `docs/patterns.json`, `docs/description/description.json`, and the per-pattern `docs/description/*.md` files for new/removed/renamed patterns.
4. **Format and test**: `sbt scalafmtCheckAll scalafmtSbtCheck test` (this mirrors the `check_format_and_test` CircleCI job).
5. **Build the Docker image locally**: `sbt "set version := \"latest\"; docker:publishLocal"`.
6. **Run `codacy-plugins-test` locally** before pushing — clone https://github.com/codacy/codacy-plugins-test and, per its README, validate the docs and run the pattern/multiple integration tests against your local image, mirroring what the repo's own README documents:
   ```sh
   sbt "run json codacy-spotbugs:latest"
   sbt "run pattern codacy-spotbugs:latest"
   sbt "run multiple codacy-spotbugs:latest"
   ```
7. **Iterate on failures**, re-running only the relevant command after each fix.
8. **Commit** the version bump(s) together with the regenerated `docs/patterns.json` and `docs/description/*` files in one change.
9. **Push and open a PR.**
10. **Poll the PR's real CI checks until they all pass — local validation is NOT the finish line.** After every push, run `gh pr checks <pr-url>` and keep re-polling (short sleep while any check is `pending`) until all checks finish. If a check fails, fetch its actual log (don't guess), find the true root cause, fix it, push again (never `--no-verify`, never force-push), and re-poll. Repeat until every check is green. **The CI environment's toolchain can differ from your local one**, so a clean local run does not guarantee CI passes. Only stop iterating when every check passes, or you hit a genuine product/infra decision that needs a human.

### 4. Common failure modes and fixes

| Symptom | Likely cause | Fix |
|---|---|---|
| Build breaks or tests fail after bumping an "incidental" dependency (`scala-xml`, `scala-java8-compat`, `html-to-markdown`, `sbt.version`, `codacy/base` orb) alongside the requested SpotBugs bump | These have repeatedly needed to be reverted in this repo's history (see commits `d5c0f8c`, `47decb3`, `4b98a6e`, `cf49b13`, `792a4c9`) | Revert the incidental bump and keep only the change actually requested by the task. |
| `DocumentationGenerator` throws `Could not find <plugin> jar!` | The findsecbugs/sb-contrib jar isn't in the local sbt/Coursier cache yet | Run `sbt compile` (or `sbt test`) first so dependencies resolve, then re-run the generator. |

### 5. Definition of done

- Version bump(s) reflected in `build.sbt` (and nowhere else needs to be touched for a pure SpotBugs/plugin version bump — there is no separate `Dockerfile` or hardcoded version string elsewhere).
- `docs/patterns.json` and `docs/description/*` regenerated via `DocumentationGenerator` and committed, with the diff reviewed for new/removed/renamed patterns.
- `sbt scalafmtCheckAll scalafmtSbtCheck test` passes locally.
- Docker image builds successfully via `sbt "set version := \"latest\"; docker:publishLocal"`.
- `codacy-plugins-test` doc-validation and pattern/multiple integration tests pass locally against the freshly built image.
- **After pushing and opening/updating the PR, every CI check on it is green.** Poll `gh pr checks <pr-url>` and iterate on any failure until all pass.

## Specification

To read more on how to build a wrapper for a tool like this one check the specification in the
[Tool Developer Guide](https://github.com/codacy/codacy-engine-scala-seed/blob/master/README.md#how-to-integrate-an-external-analysis-tool-on-codacy)

## Limitations

This tool requires the usage of [codacy-analysis-cli](https://github.com/codacy/codacy-analysis-cli) to push the results.

## What is Codacy

[Codacy](https://www.codacy.com/) is an Automated Code Review Tool that monitors your technical debt,
helps you improve your code quality, teaches best practices to your developers, and helps you save time in Code Reviews.

### Among Codacy’s features

- Identify new Static Analysis issues
- Commit and Pull Request Analysis with GitHub, Bitbucket and GitLab
- Auto-comments on Commits and Pull Requests
- Integrations with Slack, Jira, YouTrack
- Track issues in Code Style, Security, Error Proneness, Performance, Unused Code and other categories

Codacy also helps keep track of Code Coverage, Code Duplication, and Code Complexity.

Codacy supports PHP, Python, Ruby, Java, JavaScript, and Scala, among others.

### Free for Open Source

Codacy is free for Open Source projects.
