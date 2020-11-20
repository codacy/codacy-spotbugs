# Codacy SpotBugs

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/00b47dd51b964655a0329723156a3eb3)](https://www.codacy.com/gh/codacy/codacy-spotbugs?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=codacy/codacy-spotbugs&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/codacy/codacy-spotbugs.svg?style=svg)](https://circleci.com/gh/codacy/codacy-spotbugs)

This is the docker engine we use at Codacy to have [SpotBugs](https://spotbugs.github.io/) support, including the
plugins [FBContrib](https://github.com/mebigfatguy/fb-contrib) and [Find Security Bugs](https://find-sec-bugs.github.io/).

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
