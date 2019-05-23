# Codacy SpotBugs

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/00b47dd51b964655a0329723156a3eb3)](https://www.codacy.com/app/Codacy/codacy-spotbugs?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=codacy/codacy-spotbugs&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/codacy/codacy-spotbugs.svg?style=svg)](https://circleci.com/gh/codacy/codacy-spotbugs)

This is the docker engine we use at Codacy to have [SpotBugs](https://spotbugs.github.io/) support.

You can also create a docker to integrate the tool and language of your choice!
Check the **Docs** section for more information.

## Usage

You can create the docker by doing:

```sh
docker build --no-cache -t codacy/codacy-spotbugs:latest .
```

The docker is ran with the following command:

```sh
docker run -it -v $PWD:/src codacy/codacy-spotbugs:latest
```

## Docs

[Tool Developer Guide](https://github.com/codacy/codacy-engine-scala-seed/blob/master/README.md#how-to-integrate-an-external-analysis-tool-on-codacy)

## Test

We use the [codacy-plugins-test](https://github.com/codacy/codacy-plugins-test) to test our external tools integration.
You can follow the instructions there to make sure your tool is working as expected.

## What is Codacy

[Codacy](https://www.codacy.com/) is an Automated Code Review Tool that monitors your technical debt,
helps you improve your code quality, teaches best practices to your developers, and helps you save time in Code Reviews.

### Among Codacy’s features

-  Identify new Static Analysis issues
-  Commit and Pull Request Analysis with GitHub, BitBucket/Stash, GitLab (and also direct git repositories)
-  Auto-comments on Commits and Pull Requests
-  Integrations with Slack, HipChat, Jira, YouTrack
-  Track issues in Code Style, Security, Error Proneness, Performance, Unused Code and other categories

Codacy also helps keep track of Code Coverage, Code Duplication, and Code Complexity.

Codacy supports PHP, Python, Ruby, Java, JavaScript, and Scala, among others.

### Free for Open Source

Codacy is free for Open Source projects.
