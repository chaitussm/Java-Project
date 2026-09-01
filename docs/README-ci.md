# CI Documentation

<!-- TOC -->
- [CI Documentation](#ci-documentation)
	- [Workflow file](#workflow-file)
	- [Pipeline stages](#pipeline-stages)
<!-- /TOC -->

This directory contains documentation for the Java End-to-End CI pipeline.

| File                                                           | Description                                                                               |
| -------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| [java-e2e-ci-pipeline-guide.md](java-e2e-ci-pipeline-guide.md) | Full pipeline design, job details, secrets reference, and Docker tagging strategy         |
| [java-e2e-ci-quick-runbook.md](java-e2e-ci-quick-runbook.md)   | Day-to-day runbook: triggering runs, pulling images, configuring secrets, troubleshooting |

## Workflow file

`.github/workflows/java-end-to-end_ci.yml`

## Pipeline stages

```
build-test  →  docker  →  notify
```

- **build-test**: Maven build and unit tests; uploads Surefire XML reports as a GitHub Actions artifact.
- **docker**: Builds a Docker image tagged with the commit SHA and `latest`; pushes to GHCR on `push` events only.
- **notify**: Sends an SMTP email summary that includes job results and Docker image details.
