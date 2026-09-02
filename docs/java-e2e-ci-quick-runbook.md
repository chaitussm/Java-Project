# Java E2E CI — Quick Runbook

<!-- TOC -->
- [Java E2E CI — Quick Runbook](#java-e2e-ci--quick-runbook)
	- [Trigger the pipeline manually](#trigger-the-pipeline-manually)
	- [Check build results](#check-build-results)
	- [Download Surefire test reports](#download-surefire-test-reports)
	- [Pull the Docker image](#pull-the-docker-image)
	- [Secrets setup](#secrets-setup)
	- [Common issues](#common-issues)
	- [Failure resolution guide](#failure-resolution-guide)
<!-- /TOC -->

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

Navigate to **Settings → Secrets and variables → Actions**.

### Recommended: Resend API (works reliably from GitHub Actions)

Gmail SMTP often returns `535 BadCredentials` from GitHub-hosted runners even with a valid App Password. Use Resend instead:

| Secret            | Example value                          |
| ----------------- | -------------------------------------- |
| `RESEND_API_KEY`  | `re_xxxxxxxxxxxx`                      |
| `RESEND_FROM`     | `Java CI <onboarding@resend.dev>`      |
| `SMTP_TO`         | `team@example.com`                     |

**Setup:**

1. Create a free account at [resend.com](https://resend.com)
2. Create an API key at [resend.com/api-keys](https://resend.com/api-keys)
3. Add `RESEND_API_KEY` to GitHub secrets
4. Keep `SMTP_TO` as the recipient address
5. Optional: set `RESEND_FROM` after verifying your domain; otherwise the workflow uses `Java E2E CI <onboarding@resend.dev>`

When `RESEND_API_KEY` is set, the workflow uses Resend and **ignores Gmail SMTP secrets**.

### Legacy: Gmail SMTP (often fails from CI)

| Secret          | Example value        |
| --------------- | -------------------- |
| `SMTP_SERVER`   | `smtp.gmail.com`     |
| `SMTP_PORT`     | `587`                |
| `SMTP_USERNAME` | `you@gmail.com`      |
| `SMTP_PASSWORD` | `abcdefghijklmnop`   |
| `SMTP_FROM`     | `you@gmail.com`      |
| `SMTP_TO`       | `team@example.com`   |

### Gmail setup (required for `smtp.gmail.com`)

Google rejects regular account passwords with error `535-5.7.8 BadCredentials`. Use an **App Password** instead:

1. Turn on [2-Step Verification](https://myaccount.google.com/signinoptions/two-step-verification) for the Gmail account.
2. Open [App Passwords](https://myaccount.google.com/apppasswords) and create one (App: **Mail**, Device: **Other** → `GitHub Actions`).
3. Copy the 16-character password into the `SMTP_PASSWORD` secret (spaces are optional; the workflow removes them).
4. Set `SMTP_USERNAME` and `SMTP_FROM` to the **same** full Gmail address (`you@gmail.com`).
5. Use port `587` (STARTTLS) or `465` (SSL).

## Common issues

| Symptom                    | Fix                                                                                                        |
| -------------------------- | ---------------------------------------------------------------------------------------------------------- |
| `535 BadCredentials` (Gmail) | Gmail SMTP is unreliable from GitHub Actions — add **`RESEND_API_KEY`** instead (see above)              |
| `ENETUNREACH 2607:f8b0:...` | Runner tried Gmail over IPv6 — fixed in workflow; prefer **Resend API**                                    |
| Email step skipped         | Add `RESEND_API_KEY` + `SMTP_TO`, or all legacy SMTP_* secrets                                             |
| Docker push `unknown blob` | GHCR rejects BuildKit provenance manifests — workflow uses `provenance: false` on build-push                 |
| Surefire artifact empty    | No `*.xml` files found — this is normal when there are no tests; the step uses `if-no-files-found: ignore` |
| `mvn -B test` fails        | Fix compilation errors or failing unit tests in `demo/` before merging                                     |

For full failure analysis with diagrams, see [java-e2e-ci-pipeline-guide.md — Troubleshooting Known Failures](java-e2e-ci-pipeline-guide.md#troubleshooting-known-failures).

## Failure resolution guide

### 1. Gmail SMTP — `535 BadCredentials`

**When it happens:** `notify` job → `Send email notification` step fails with `535-5.7.8 ... gsmtp`.

**Why:** Gmail rejected the login — usually a regular password instead of an App Password, or a newly generated App Password not yet saved in GitHub secrets.

```mermaid
flowchart TD
    A["535 BadCredentials"] --> B["Create new App Password"]
    B --> C["Update SMTP_PASSWORD secret"]
    C --> D["SMTP_USERNAME = SMTP_FROM\nsame Gmail address"]
    D --> E["Re-run workflow"]
```

**Fix checklist:**

1. [Enable 2-Step Verification](https://myaccount.google.com/signinoptions/two-step-verification)
2. [Create App Password](https://myaccount.google.com/apppasswords) → Mail / Other → `GitHub Actions`
3. Update `SMTP_PASSWORD` in repo secrets (**old App Password stops working immediately**)
4. Set `SMTP_USERNAME` and `SMTP_FROM` to the same `@gmail.com` address
5. Re-run: **Actions → select run → Re-run all jobs**

---

### 2. GHCR Docker push — `unknown blob`

**When it happens:** `docker` job → push fails after layers upload with `unknown blob`.

**Why:** Docker BuildKit attaches provenance attestation manifests that GHCR rejects.

```mermaid
flowchart TD
    A["unknown blob on push"] --> B["Workflow uses\nprovenance: false"]
    B --> C["Merge latest main\nincludes PR #22 fix"]
    C --> D["Re-run workflow"]
    D --> E["Check GHCR for :sha and :latest tags"]
```

**Fix:** Ensure `main` includes the `docker/build-push-action@v6` step with `provenance: false` and `sbom: false`. No secret changes required.

**Verify images:**

```bash
docker pull ghcr.io/chaitussm/java-project:latest
```

---

### 3. Healthy run checklist

```mermaid
flowchart LR
    A["build-test ✓"] --> B["docker ✓"]
    B --> C["notify ✓"]
    C --> D["email received ✓"]
    B --> E["GHCR tags ✓"]
```

```bash
gh run list --workflow java-end-to-end_ci.yml --limit 1
gh run view <run-id> --json jobs --jq '.jobs[] | {name,conclusion}'
```
