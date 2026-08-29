# Java End-to-End CI Pipeline Guide

This document describes the design and behaviour of the
`.github/workflows/java-end-to-end_ci.yml` workflow.

## Pipeline Overview

```
push / pull_request
        │
        ▼
┌──────────────┐
│ build-test   │  Maven build + unit tests (demo/)
│              │  Upload Surefire XML artifact
└──────┬───────┘
       │ needs: build-test
       ▼
┌──────────────┐
│    docker    │  Build Docker image
│              │  Tags: <sha>  +  latest
│              │  Push to GHCR only on push events
└──────┬───────┘
       │ needs: [build-test, docker]  if: always()
       ▼
┌──────────────┐
│    notify    │  Send SMTP email summary
│              │  Includes Docker image details & push status
└──────────────┘
```

## Job Details

### `build-test`

| Step | Description |
|------|-------------|
| Checkout | `actions/checkout@v4` |
| Set up JDK 21 | Temurin distribution with Maven cache |
| Build | `mvn -B clean package` in `demo/` |
| Test | `mvn -B test` in `demo/` |
| Upload artifact | Surefire XML reports → artifact `surefire-reports` |

### `docker`

| Step | Description |
|------|-------------|
| Set push flag | Output `pushed=true` only on `push` events |
| GHCR login | `docker/login-action@v3` using `GITHUB_TOKEN` (push only) |
| Build image | Tags `ghcr.io/<owner>/java-project:<sha>` and `:latest` |
| Push images | Executed only when `github.event_name == 'push'` |

### `notify`

Runs after both previous jobs regardless of their outcome (`if: always()`).

The email includes:
- Repo, branch, commit SHA, trigger event
- Result of each upstream job
- Full Docker image name and both tags
- Whether images were pushed

## Required Secrets

| Secret | Purpose |
|--------|---------|
| `SMTP_SERVER` | SMTP host (e.g. `smtp.gmail.com`) |
| `SMTP_PORT` | SMTP port (e.g. `587`) |
| `SMTP_USERNAME` | SMTP login username |
| `SMTP_PASSWORD` | SMTP login password / app password |
| `SMTP_FROM` | Sender email address |
| `SMTP_TO` | Recipient email address |

If any secret is missing the email step is skipped gracefully.

## Docker Image Registry

Images are stored in the GitHub Container Registry (GHCR):

```
ghcr.io/<owner>/java-project:<git-sha>
ghcr.io/<owner>/java-project:latest
```

`<owner>` is resolved automatically from `github.repository_owner`.

Images are pushed **only** on `push` to `main`.  
Pull-request runs build the image locally for validation but do **not** push.
