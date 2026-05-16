# 2k2phd — Epics and Stories

**Project:** 2k2phd
**Generated:** 2026-05-16
**Source:** docs/product/prd.md, docs/planning/issues-seed.md, docs/planning/backlog.md

---

## Epic 1: Core Discovery Loop (Mobile)

The end-to-end learner flow from app open through search, result review, feedback, and escalation. All mobile work. Covers FR1–FR26, FR38–FR46.

### Story 1.1: Search-First Home Flow and Telemetry

**GitHub Issue:** #1
**Labels:** mobile, p0
**Status at sprint-planning:** done

Build the search-first home screen with no mandatory sign-in gate. Emit telemetry events for the home and search phases of the core loop.

**Acceptance Criteria:**
- User can open app and reach search-first home without mandatory sign-in
- Events emitted: `HomeViewed`, `SearchFocused`, `SearchSubmitted`
- `TelemetryEvent` sealed class covers all 11 MVP event variants
- `InMemoryTelemetryRepository` records events; Hilt `@Singleton` binding in place
- Hilt fully bootstrapped: `@HiltAndroidApp App`, `@AndroidEntryPoint MainActivity`

**PRD FRs:** FR1, FR3, FR6, FR38–FR46

---

### Story 1.2: Recommendation Card UI with Why This Now

**GitHub Issue:** #4
**Labels:** mobile, p0
**Status at sprint-planning:** done

Display OER recommendation results as cards with title, type badge, effort badge, remix badge, top-3 rationale chips ("Why this now"), source/license/trust row.

**Acceptance Criteria:**
- Card shows title, resourceType chip, estimatedEffort chip, "Remixable" chip when eligible
- "Why this now" section shows top-3 rationale AssistChips in FlowRow
- Source, license, and TrustBadge (color-coded: VERIFIED/COMMUNITY/UNREVIEWED) on bottom row
- `OerRecord` domain model matches API contract in `shared/contracts/api-outline.md`
- `OerRepository` interface in `domain/`; `FakeOerRepository` with 5 seeded records in `data/`
- `ResultsViewModel` reads query from SavedStateHandle; `ResultsScreen` uses `hiltViewModel()`
- Loading state shows `CircularProgressIndicator`; empty state shows message

**PRD FRs:** FR4, FR13, FR15, FR16, FR17, FR18, FR19

---

### Story 1.3: Back-Navigation from Results to Home

**Labels:** mobile, p0
**Status at sprint-planning:** backlog

The Results screen currently has no back-navigation. This must be added before the detail screen is built, as the Navigation Compose back stack assumes the Results route is reachable from Home.

**Acceptance Criteria:**
- TopAppBar with back arrow on Results screen navigates back to Home
- Back gesture (predictive back) works correctly
- No NavController passed into ResultsScreen; navigation handled via callback from AppNavHost

**PRD FRs:** FR5

---

### Story 1.4: Helpful and Not Helpful Feedback Capture

**GitHub Issue:** #5
**Labels:** mobile, api, p0
**Status at sprint-planning:** backlog

Add "Use This", "Helpful", and "Not Helpful" actions to the result detail or result card flow. Wire `UseThisSelected`, `FeedbackSubmitted`, and `NeedBetterMatchTapped` telemetry events. Call `POST /v1/feedback` API (fake implementation acceptable for MVP).

**Acceptance Criteria:**
- "Use This" button available on result; taps emit `UseThisSelected(resourceId)`
- Thumbs-up / thumbs-down (or equivalent) available; taps emit `FeedbackSubmitted(resourceId, HELPFUL|NOT_HELPFUL)`
- Feedback call routed through `FeedbackRepository` interface backed by fake implementation
- Hilt binding in place; real implementation can be swapped without ViewModel changes

**PRD FRs:** FR21, FR22, FR23, FR26, FR40, FR41, FR44

---

### Story 1.5: Persistent Need Better Match Control

**GitHub Issue:** #7
**Labels:** mobile, p0
**Status at sprint-planning:** backlog

Add a persistent "Need Better Match?" button/control available throughout the recommendation flow. Tapping it after a defined trigger threshold escalates to the ticket submission flow (Story 2.3).

**Acceptance Criteria:**
- "Need Better Match?" control is visible on the results or detail screen
- Tapping emits `NeedBetterMatchTapped` telemetry event
- After defined triggers, navigates to ticket submission UI (can be stubbed if Story 2.3 incomplete)
- Clear expectation-setting copy: no guarantee of concierge fulfillment

**PRD FRs:** FR24, FR27, FR29, FR30, FR43

---

### Story 1.6: Accessibility Validation on Top Flows

**GitHub Issue:** #10
**Labels:** mobile, p0, a11y
**Status at sprint-planning:** backlog

Validate screen reader support, touch target sizes, and color contrast on the five top flows: home/search, results list, result card, feedback actions, and ticket submission.

**Acceptance Criteria:**
- TalkBack navigation tested on home → search → results → card → feedback flow
- All interactive elements have content descriptions
- Touch targets meet 48dp minimum
- Color contrast meets WCAG AA on all text/background combinations
- Compose Semantics APIs used where needed to fix gaps

**PRD FRs:** FR10 (NFR: accessibility)

---

## Epic 2: Backend Matching Service

New service (`oer-matching-api`) not yet in the repository. Scoring, license filtering, and ticket intake are all API-side work. Mobile fake implementations exist for each; these stories replace them with real endpoints.

### Story 2.1: Scoring Engine v1

**GitHub Issue:** #2
**Labels:** api, p0
**Status at sprint-planning:** backlog

Implement the OER scoring engine in `oer-matching-api`. Score based on search query similarity, trust-eligible metadata, license eligibility, and resource type fit. Return top-N recommendations with `score` and `rationale[]` fields.

**Acceptance Criteria:**
- `POST /v1/recommendations` returns scored list ordered by score descending
- Each result includes `score` (float), `rationale[]` (ordered string list), all fields in API contract
- Scoring considers: query-title/description similarity, trust_status weight, resource_type fit
- Unit tests cover scoring formula with representative fixtures

**PRD FRs:** FR4, FR7, FR8, FR9, FR10

---

### Story 2.2: Remix License Hard Filter

**GitHub Issue:** #3
**Labels:** api, p0, compliance
**Status at sprint-planning:** backlog

Add a license eligibility hard filter to the recommendation endpoint. Resources with non-remix-eligible licenses must be excluded from results when the learner is in remix mode.

**Acceptance Criteria:**
- Allow list: CC BY, CC BY-SA, CC0, Apache 2.0, MIT, BSD
- Block list: NC variants (CC BY-NC, CC BY-NC-SA, CC BY-NC-ND), ND variants, unknown/unlicensed
- Filter applied server-side before scoring; blocked resources do not appear in response
- Unit tests cover allow/deny matrix (each license variant tested explicitly)
- Zero remix license errors is a KPI; test suite enforces it

**PRD FRs:** FR7, FR16

---

### Story 2.3: Ticket-First Fallback Endpoint

**GitHub Issue:** #6
**Labels:** api, p0
**Status at sprint-planning:** backlog

Implement `POST /v1/tickets` to accept a prefilled ticket from the mobile client when no acceptable OER is found. Return a `ticket_id`, `status`, and `eta_hint`.

**Acceptance Criteria:**
- Endpoint accepts `session_id`, `query`, optional `learner_note`, `trigger_reason`, `last_recommendation_ids[]`
- Returns `ticket_id`, `status`, `eta_hint`
- Persists ticket to database; Charlie can view submitted tickets
- Mobile client can submit and display ticket confirmation with eta_hint copy

**PRD FRs:** FR27, FR28, FR29, FR30, FR31, FR37

---

## Epic 3: Trust, Resilience, and Enrichment

P1 work that deepens the learner trust signal and hardens the app for real-world network conditions.

### Story 3.1: Trust Panel v1

**GitHub Issue:** #8
**Labels:** mobile, api, p1
**Status at sprint-planning:** backlog

Show a trust panel on the OER detail screen displaying source, license, provenance, and contributor signal or reference count when available. The `trustStatus` field is already on `OerRecord`; this story adds the detail screen and trust panel composable.

**Acceptance Criteria:**
- Detail screen accessible from result card tap
- Trust panel shows: source URL, license, provenance string, trustStatus badge, reference count (if available)
- `TrustStatus.VERIFIED` shows green badge, `COMMUNITY` shows amber, `UNREVIEWED` shows grey
- Detail screen follows feature package pattern: `detail/DetailScreen.kt`, `DetailViewModel.kt`, `DetailContract.kt`

**PRD FRs:** FR14, FR15, FR16, FR17, FR18, FR20

---

### Story 3.2: Offline and Cache Resilience

**GitHub Issue:** #9
**Labels:** mobile, api, p1, reliability
**Status at sprint-planning:** backlog

Handle API timeouts gracefully and show cached fallback recommendation cards when the network is unavailable or the API returns an error.

**Acceptance Criteria:**
- Room cache stores last successful recommendation set per query
- On network failure, cached results shown with "Showing cached results" banner
- API timeout threshold configurable (default: 10s)
- OkHttp retry interceptor with exponential backoff (max 3 attempts)
- Unit tests cover cache-hit and timeout paths

**PRD FRs:** FR4, FR5 (NFR: reliability)

---
