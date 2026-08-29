# Java E2E CI — Quick Runbook

## Trigger the pipeline manually

The workflow runs automatically on:
- `push` to `main`
- `pull_request` targeting `main`

To re-run a failed workflow via GitHub UI:  
**Actions → select run → Re-run all jobs**

## Check build results

```bash
# List recent workflow runs (requires gh CLI)
gh run list --workflow java-end-to-end_ci.yml
```

## Download Surefire test reports

```bash
gh run download <run-id> --name surefire-reports --dir /tmp/surefire-reports
```

## Pull the Docker image

```bash
# Latest
docker pull ghcr.io/<owner>/java-project:latest

# Specific commit
docker pull ghcr.io/<owner>/java-project:<git-sha>
```

## Secrets setup

Navigate to **Settings → Secrets and variables → Actions** and add:

| Secret | Example value |
|--------|---------------|
| `SMTP_SERVER` | `smtp.gmail.com` |
| `SMTP_PORT` | `587` |
| `SMTP_USERNAME` | `you@example.com` |
| `SMTP_PASSWORD` | `app-password` |
| `SMTP_FROM` | `ci-bot@example.com` |
| `SMTP_TO` | `team@example.com` |

## Common issues

| Symptom | Fix |
|---------|-----|
| Email step skipped | One or more SMTP secrets are missing — add them all |
| Docker push `unauthorized` | Ensure the repo package visibility allows write via `GITHUB_TOKEN` |
| Surefire artifact empty | No `*.xml` files found — this is normal when there are no tests; the step uses `if-no-files-found: ignore` |
| `mvn -B test` fails | Fix compilation errors or failing unit tests in `demo/` before merging |
