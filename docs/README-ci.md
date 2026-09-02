# CI Documentation

<!-- TOC -->
- [CI Documentation](#ci-documentation)
	- [Workflow file](#workflow-file)
	- [Pipeline stages](#pipeline-stages)
<!-- /TOC -->

This directory contains documentation for the Java End-to-End CI pipeline.

| File                                                           | Description                                                                               |
| -------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| [java-e2e-ci-pipeline-guide.md](java-e2e-ci-pipeline-guide.md) | Full pipeline design, job details, secrets reference, Docker tagging, and **troubleshooting with diagrams** |
| [java-e2e-ci-quick-runbook.md](java-e2e-ci-quick-runbook.md)   | Day-to-day runbook: triggering runs, pulling images, configuring secrets, quick troubleshooting               |

## Workflow file

`.github/workflows/java-end-to-end_ci.yml`

## Pipeline stages

```
build-test  →  docker  →  notify
```

- **build-test**: Maven build and unit tests; uploads Surefire XML reports as a GitHub Actions artifact.
- **docker**: Builds with `docker/build-push-action@v6` (`provenance: false`); pushes to GHCR on `push` events only.
- **notify**: Sends an SMTP email summary with job results, program counts, and the HTML execution report attached.

## Known failure resolutions

| Error | Doc section |
| ----- | ----------- |
| `535 BadCredentials` (Gmail SMTP) | [Pipeline guide — Gmail SMTP troubleshooting](java-e2e-ci-pipeline-guide.md#gmail-smtp-535-badcredentials) |
| `unknown blob` (GHCR push) | [Pipeline guide — GHCR troubleshooting](java-e2e-ci-pipeline-guide.md#ghcr-docker-push-unknown-blob) |
| Quick fix checklists | [Quick runbook — Failure resolution guide](java-e2e-ci-quick-runbook.md#failure-resolution-guide) |
