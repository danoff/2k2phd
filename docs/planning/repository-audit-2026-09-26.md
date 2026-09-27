# Repository Audit and Prototype Plan

**Audit date:** 2026-09-26
**Scope:** All tracked source, build configuration, contracts, and planning documents
**Recommendation:** Continue with the Android app, but treat the next milestone as a small, instrumented, local-data prototype rather than starting the backend now.

## Executive Summary

The repository is a promising product concept with a modern Android scaffold, but it is not yet a runnable or testable prototype. The strongest assets are the validated product narrative, a narrow search-first intent, the Compose/Hilt structure, a fake repository, recommendation cards, and an in-memory event model. The largest risk is not missing technology; it is that the product's central hypothesis is still untested while the documentation and dependency surface are larger than the implemented user journey.

The shortest path forward is one complete vertical slice:

> Search a small, curated local catalog -> inspect one resource -> open its real source -> mark `Use This` or `Not useful` -> request a better match -> export the session events for review.

This slice should use verified fixture data and work without a backend. It proves the interaction, language, license display, telemetry, and pilot workflow before committing to ingestion and ranking services.

## Current-State Scorecard

| Area | Status | Evidence | Prototype implication |
|---|---|---|---|
| Product intent | Strong | The PRD, implementation summary, and core loop agree on search, visible trust/license data, and success within three searches. | Preserve the core hypothesis, but condense day-to-day execution into this plan. |
| Android foundation | Partial | Compose, Navigation, Hilt, repository interfaces, fake data, and StateFlow are present. | Extend the existing app rather than rewrite it. |
| End-to-end journey | Blocked | Home reaches results, but a card tap only records an event; there is no detail, source-open, feedback, save, ticket, or back/refine flow. | Implement one complete journey before backend work. |
| Search quality | Misleading demo behavior | Fake search returns the entire catalog when there is no match and does no ranking despite carrying scores. | Make empty/weak results honest and deterministic. |
| Data trust | Unsafe as product data | Fixtures contain claims about providers, licenses, review dates, and usage with no source URLs or verification record. | Label fixtures as fictional or replace them with a small verified corpus. |
| Licensing rules | Blocked by decision | The license matrix and metadata baseline remain open decisions. | Resolve these before claiming resources are eligible or “commercially safe.” |
| Build reproducibility | Blocked | No Gradle wrapper is committed, and the README depends on Android Studio. | Add a wrapper and a documented supported JDK/SDK toolchain. |
| Quality controls | Missing | There are no source tests, CI workflows, lint policy, or accessibility automation. | Add a minimum test pyramid and CI with the first slice. |
| Operations/backend | Not started | Contracts are prose outlines; no API, ingestion, database, or operator view exists. | Defer production services; use fixtures and a local export during prototype validation. |
| Repository hygiene | Partial | Build cache was untracked; no ignore file, license text, contribution guide, or security/privacy note was present at audit time. | The new root `.gitignore` handles local output; add governance files before public distribution. |

## What Already Works

1. **The primary audience and outcome are explicit.** The implementation requirements identify adult learners and define success around an acceptable resource within three tries.
2. **The scope correctly avoids accounts for the MVP.** This reduces privacy, identity, and backend work.
3. **The UI architecture is adequate for a prototype.** ViewModels own state, screens observe lifecycle-aware flows, and interfaces isolate the fake data and telemetry implementations.
4. **The recommendation card exposes useful concepts.** It displays type, effort, rationale, source, license, remixability, and a trust badge.
5. **The app has the beginnings of observable behavior.** Search and results events can be captured in memory without choosing an analytics vendor.
6. **The planning artifacts identify the hard domain questions.** Metadata and license policy are explicitly open rather than silently assumed.

## Findings, Ordered by Priority

### P0 — Make the Repository Reproducibly Buildable

**Finding:** `mobile-app` has no `gradlew`, wrapper JAR, or wrapper properties. A new contributor cannot run the same Gradle version from the command line. The current dependency list also includes Room, WorkManager, DataStore, Retrofit, OkHttp, and serialization even though the implemented slice does not use them.

**Action:**

1. Generate and commit a Gradle wrapper compatible with Android Gradle Plugin 8.4.2.
2. Document one supported JDK (prefer JDK 17 for the current configuration) and Android SDK setup.
3. Add `./gradlew lint testDebugUnitTest assembleDebug` to CI.
4. Remove unused dependencies until their features enter the slice; add them back with tests when needed.
5. Add an Android resource theme owned by the app rather than referencing a theme that is not declared in this repository.

**Exit criterion:** A clean checkout builds from one documented command in CI and on a contributor machine.

### P0 — Finish the Core Interaction Before Building Services

**Finding:** Selecting a recommendation does not navigate anywhere. Most actions that define success in the PRD do not exist in the UI. As a result, the current app can demonstrate cards but cannot test whether a learner starts learning.

**Action:** Add a detail route and screen with:

- title, description, provider, canonical source URL, resource format, and accessibility notes;
- explicit license name and canonical license URL;
- provenance and a plain-language explanation of the trust status;
- primary `View original` and `Use This` actions;
- secondary `Helpful`, `Not useful`, and `Need a better match` actions;
- a simple fallback request form with expectation-setting;
- back navigation and query refinement.

For the prototype, `Save` can be deferred unless interviews show it is necessary. “Use This” and opening the source are much closer to the central outcome.

**Exit criterion:** A tester can complete the full loop without encountering a dead control.

### P0 — Replace Unverifiable Fixtures and Define License Policy

**Finding:** The local catalog presents specific third-party attribution, popularity, review, and license claims, but the data model has no URL, verification timestamp, or evidence reference. One rationale says “MIT License” while the displayed license for the same record is `CC BY-SA 4.0`. Another record is marked non-remixable while its rationale describes Apache 2.0 and its displayed license is `CC BY-NC-SA 4.0`. These contradictions undermine the product's trust promise.

**Action:**

1. Immediately label the existing catalog as synthetic in the UI, or replace it.
2. Create a hand-reviewed set of 20–50 real records with canonical URLs and evidence.
3. Decide and encode a license allow/deny/review matrix. Keep “commercially safe,” “open,” and “remixable” as separate concepts.
4. Add `licenseUrl`, `sourceUrl`, `verifiedAt`, `evidenceUrl`, `description`, `language`, and accessibility fields to the record/schema.
5. Reject ambiguous data by default and unit-test every license classification.

**Exit criterion:** Every surfaced claim can be traced to a source, and contradictory fixture states are impossible in tests.

### P0 — Make Search Behavior Honest and Measurable

**Finding:** A no-match query returns the first four catalog entries, so the empty state and `SearchFailed` event are effectively unreachable for non-empty searches. Scores are displayed in the model but not calculated or used for sorting. Quick filters are appended to free text instead of represented as structured criteria.

**Action:**

1. Define a tiny deterministic scorer (token/title/tag match plus explicit filter matches).
2. Represent filters as state, not query suffixes.
3. Apply license eligibility before ranking.
4. Return a genuine empty/low-confidence state rather than unrelated results.
5. Show which terms or fields produced the rationale.
6. Write table-driven tests for match, rank, filter, and no-match behavior.

**Exit criterion:** Given a fixed catalog and query, result ordering and explanations are deterministic and covered by tests.

### P0 — Align Telemetry With Privacy and the Product Vocabulary

**Finding:** Code event names diverge from the documented event contract (`ResultOpened` versus `oer_opened`, for example). Events have no session identifier or timestamp, raw queries are stored in memory, impressions are emitted when results load rather than when cards are actually visible, and process death loses everything.

**Action:**

1. Define a versioned event schema in machine-readable JSON Schema or Kotlin serialization models.
2. Include anonymous session ID, event ID, timestamp, schema version, search attempt number, and relevant resource/position context.
3. Establish a privacy rule for raw queries; for pilot export, obtain informed consent and redact obvious sensitive data.
4. Record impressions from actual visibility or rename the event to `results_returned`.
5. Persist an offline queue only after the schema and consent behavior are accepted.
6. Provide a developer/pilot “export session” action so a human can inspect the evidence without an analytics SDK.

**Exit criterion:** One pilot session can be reconstructed without creating a user profile, and event names match the contract.

### P1 — Reduce Product and Documentation Ambiguity

**Finding:** The repo contains a 620-line PRD, a 610-line validation report, a second requirements summary, a core-loop document, backlog, issue seed, status report, and project context. Several are useful records, but there is no single short execution board and some status text is stale (for example, the status report describes results as placeholder titles even though recommendation cards now exist).

**Action:**

1. Keep `prd.md` as the product source of truth and this audit as the delivery plan.
2. Turn the next slice into 8–12 issues with an owner, acceptance criteria, dependency, and estimate.
3. Mark historical reports as historical; do not use them as current status.
4. Update the decision log whenever metadata, license policy, success event, pilot data handling, or ticket workflow is settled.
5. Make README quick-start commands executable and link to the active milestone.

### P1 — Add Failure, Accessibility, and UI-State Coverage

**Finding:** Repository calls have no error handling, retry, cancellation-specific UX, or error state. Strings are embedded in Kotlin. Chip-like informational labels have empty click handlers, creating misleading semantics. There are no content descriptions, focus/keyboard checks, font-scale checks, screenshot tests, or accessibility tests.

**Action:**

1. Model loading, content, empty, and recoverable error states explicitly.
2. Move user-visible text to string resources.
3. Render noninteractive metadata as labels, not clickable chips.
4. Test screen reader order, 200% font scaling, contrast, touch targets, keyboard action, and reduced connectivity.
5. Add ViewModel unit tests and a small number of Compose navigation/action tests.

### P1 — Define Prototype Operations Without Overbuilding

**Finding:** The ticket endpoint and operator workflow do not exist, and the prose API outline is too loose for parallel client/server development. Starting a production ingestion pipeline now would add substantial work before demand and usefulness are established.

**Action:** For the pilot, submit fallback requests to a clearly disclosed external form or local export. If a service becomes necessary, first replace the prose outline with OpenAPI and define validation, errors, idempotency, abuse controls, retention, and deletion. Do not promise response times until an operator can support them.

### P2 — Repository Governance and Release Readiness

Before distributing builds or accepting contributors:

- add the actual CeCILL and CC0 license texts or clarify exactly which files/content each covers;
- add `CONTRIBUTING.md`, a code of conduct, security contact, privacy/data-handling note, and release checklist;
- add Dependabot or Renovate and pin CI actions;
- configure release signing outside Git and document secret handling;
- add application icons, adaptive icon resources, versioning, and an internal testing distribution path.

## Recommended Prototype Boundary

### Include

- Android only, no account;
- 20–50 verified local OER records in one narrow subject domain;
- deterministic local search, filters, and licensing gate;
- results and detail screens;
- canonical source launch;
- `Use This`, helpful/not-useful, and better-match actions;
- anonymous per-session events with consented export;
- honest empty, error, and offline behavior;
- accessibility pass on the single journey.

### Explicitly Defer

- automated web ingestion and generalized metadata normalization;
- production recommendation API and ranking ML/AI;
- Room, WorkManager, Retrofit, and remote analytics unless the slice proves their need;
- accounts, cross-device saves, social/community features, sponsorship, and gamification;
- a custom ticket backend and dashboard.

This boundary is intentionally smaller than the documented MVP. A prototype should answer whether learners understand and trust the recommendation experience; an MVP can then operationalize what works.

## Four-Week Execution Plan

### Week 1 — Reproducible Baseline and Decisions

1. Add Gradle wrapper, supported JDK instructions, and CI.
2. Make `assembleDebug`, lint, and unit tests pass from a clean checkout.
3. Decide the first subject/audience cohort, metadata fields, license matrix, success event, and pilot data policy.
4. Replace questionable fixtures with an evidence-backed seed corpus.
5. Add scorer and license-rule unit tests before UI integration.

**Demo:** A CI-built APK searches a trustworthy local corpus and correctly returns no match.

### Week 2 — Complete Vertical Slice

1. Add encoded/type-safe navigation arguments and a detail route.
2. Implement detail, original-source launch, `Use This`, feedback, and query refinement.
3. Add structured UI states and clear errors.
4. Align and test the telemetry schema.

**Demo:** Five internal testers can complete every branch of the core loop.

### Week 3 — Better-Match Workflow and Accessibility

1. Add the better-match form with transparent response expectations.
2. Add session event export and a lightweight reviewer template.
3. Complete TalkBack, large-text, contrast, touch-target, and poor-connectivity checks.
4. Run a moderated usability rehearsal and fix blocking confusion.

**Demo:** A tester who finds nothing can submit/export useful context, and a reviewer can triage it.

### Week 4 — Small Pilot and Decision

1. Distribute an internal build to 5–10 consenting adult learners.
2. Give each participant 2–3 realistic learning tasks.
3. Review task completion, search attempts, source opens, `Use This`, false trust assumptions, and interview notes.
4. Decide whether to iterate locally, build the first API, change the corpus/domain, or stop.

**Demo:** A written evidence review supports a specific go/change/stop decision.

## Prototype Success Measures

Use a small set of interpretable measures rather than the current aspirational top-3 usefulness target:

1. At least 8 of 10 participants can complete a search and open an original resource without assistance.
2. At least 7 of 10 can correctly explain the displayed source, license, and trust status after one task.
3. Median time from app open to original-source open is under 60 seconds for a corpus-covered task.
4. At least 6 of 10 corpus-covered tasks produce `Use This` within three searches.
5. Zero surfaced records violate the approved license matrix or lack evidence.
6. Every failed task yields an understandable reason from observation, feedback, or the better-match request.

These are prototype learning thresholds, not launch KPIs. Adjust them after the first pilot rather than treating a tiny sample as statistical proof.

## First Issue Set

Create issues in this dependency order:

1. **Build:** Commit Gradle wrapper, JDK 17 setup, root ignore rules, and CI checks.
2. **Domain:** Decide metadata baseline and encode the license eligibility matrix.
3. **Data:** Build the verified seed corpus and evidence checklist.
4. **Search:** Implement deterministic scoring, structured filters, and honest empty results.
5. **Navigation:** Safely encode query/resource arguments and add back/refine behavior.
6. **Detail:** Add trust/license/source detail and original-resource launch.
7. **Outcome:** Add `Use This` and helpful/not-useful interactions.
8. **Fallback:** Add better-match request and expectation-setting.
9. **Telemetry:** Version the event contract, session context, privacy handling, and export.
10. **Quality:** Add unit/UI tests and complete the accessibility checklist.
11. **Pilot:** Produce signed/internal APK, study script, consent text, and evidence review template.

Issues 2 and 3 are product/domain work, not merely engineering tasks, and should have a named human decision owner.

## Decisions Required From the Product Owner

Work can begin on build reliability and navigation immediately. These choices should be made during Week 1:

1. What single subject area and learner context will the first corpus serve?
2. Does “commercially safe” mean commercial reuse is required, or only that the app itself can link to the work?
3. Which licenses are allowed for linking, copying, adapting, and commercial reuse?
4. Is success `Use This`, opening the original resource, a positive rating, or a combination?
5. May pilot exports contain raw queries, and what is the retention/deletion process?
6. Who receives better-match requests, through what tool, and what response expectation is honest?
7. Are the `Pulse` area and sponsor concept needed to test the central hypothesis? The audit recommendation is **no** for the prototype.

## Definition of Prototype Ready

The prototype is ready for a small external pilot only when:

- a clean checkout builds through the committed wrapper and CI;
- all records have canonical source/license URLs and verification evidence;
- license rules, ranking, ViewModels, and event serialization have unit tests;
- the app has no dead controls in the core journey;
- loading, empty, error, and offline states are understandable;
- TalkBack and large-text checks pass for the entire journey;
- telemetry/export behavior is disclosed and avoids persistent identity;
- the better-match expectation is truthful;
- a human has reviewed every resource and the pilot script;
- an APK, test protocol, rollback path, and evidence-review owner exist.

## Audit Notes and Limitations

The audit reviewed every tracked file and repository history/status. A command-line build was attempted with the environment's system Gradle, but the only available Java runtime reported version 25.0.2 and the Android build failed before compilation. Because the repository has no wrapper or declared toolchain bootstrap, this does not establish whether the source compiles under the intended JDK 17 environment. No emulator/device validation or screenshot was possible from the current reproducibility state.
