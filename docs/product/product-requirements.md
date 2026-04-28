# 2k2phd Product Requirements

**Status:** Aligned to validated PRD  
**Date:** 2026-04-27  
**Source of truth:** `docs/product/prd.md`  
**Platform:** Android-first MVP

## 1. Purpose

This document is the repo-facing implementation summary for the validated `2k2phd` MVP. If this file conflicts with the validated PRD, the PRD wins.

## 2. Product Summary

`2k2phd` is an Android-first learning app for adults age 18+ that helps users find trustworthy, commercially safe Open Educational Resources quickly enough to stop searching and start learning.

The MVP is optimized for a simple outcome:

1. User opens the app without mandatory account creation.
2. User enters a search.
3. User receives relevant OER results with visible trust and license information.
4. User finds a useful result within 3 searches, or requests a better match.

## 3. Target User

Primary user:

1. Adult learner age 18+

Primary contexts:

1. Finding material for a formal course
2. Finding material for self-education

Secondary operator:

1. Charlie as reviewer for ticket triage and product-health review

## 4. Primary User Job

Help the user find an acceptable OER alternative within 3 tries so they can stop searching and start learning.

## 5. Product Principles

1. Search must stay primary.
2. Trust must be visible, not implied.
3. Licensing must be conservative and explicit.
4. Ads must not compromise usability or credibility.
5. The app should help users start learning quickly, not trap them in browsing.
6. The product must respect learner attention and avoid manipulative UX patterns.
7. The MVP should avoid unnecessary private-data collection.

## 6. MVP Scope

The MVP includes:

1. Android app
2. Search-first home screen
3. OER results list
4. OER detail view
5. Trust, provenance, and licensing display
6. `Use This` as the primary success action
7. Save and usefulness-rating actions
8. `Need Better Match` fallback
9. Ticket creation with clear expectation-setting
10. Session-level telemetry without mandatory accounts
11. One restrained sponsor or ad placement strategy with clear labeling

The MVP excludes:

1. Mandatory account creation and sign-in
2. iOS or multi-platform launch
3. Child or minor accounts
4. In-app remixing or authoring
5. Advanced AI-generated learning plans
6. Broad volunteer-governance systems

## 7. Functional Requirements

### 7.1 Discovery and Search

1. The app must allow a learner to open and use core discovery flows without creating an account.
2. The app must present clear age and usage guidance before or during initial use.
3. The app must allow a learner to submit a free-text search query.
4. The app must return a results list after query submission.
5. The app must support refinement when the initial results are weak or the learner requests a better match.
6. The system must distinguish successful search paths from failed search paths.

### 7.2 OER Result Evaluation

1. The app must allow the learner to open a result detail view.
2. The detail view must show source information.
3. The detail view must show license information.
4. The detail view must show provenance or trust context.
5. The detail view must provide a path to the original OER.
6. The system must exclude or suppress content with unclear provenance, ambiguous licensing, or insufficient trust context.
7. The app should show a short explanation of why a result is being shown when explanation data is available.

### 7.3 Actions and Feedback

1. The detail view must allow the learner to select `Use This`.
2. The system must treat `Use This` as the primary successful-match event.
3. The detail view must allow the learner to save a resource.
4. The detail view must allow the learner to rate usefulness.
5. The detail view must allow the learner to indicate they need a better match.
6. The app must support a lightweight appreciation or usefulness survey.

### 7.4 Ticket Fallback

1. The app must allow a learner to submit a request ticket when they do not find an acceptable OER.
2. Ticket submission must include search or topic context.
3. Ticket UX must state clearly that fulfillment is not guaranteed concierge support.
4. Ticket UX must state clearly that response timing depends on Charlie and volunteer capacity.
5. Charlie must be able to review submitted request tickets with enough context to triage them.

### 7.5 Telemetry and Product Health

1. The system must track result impressions and result opens.
2. The system must track `Use This`, save, usefulness feedback, ticket submission, and survey completion.
3. The system must track sponsor or ad impressions and interactions when present.
4. Charlie must be able to review product-health signals related to downloads, searches, successful matches, tickets, surveys, and monetization.
5. The telemetry model must support session-level tracking without requiring persistent user profiles.

## 8. Non-Functional Requirements

### 8.1 Usability

1. The app must maintain a low-friction search-to-learning flow.
2. Search must remain the dominant interaction on the home screen.
3. Trust and license information must be visible without deep navigation.

### 8.2 Performance

1. Search submission to first result should target under 3 seconds on typical WiFi.
2. Detail view loading should target under 2 seconds.
3. `Use This` recording should target under 1 second.

### 8.3 Reliability

1. The app should fail clearly when network conditions prevent effective search.
2. Ticket, feedback, and telemetry events should be preserved across ordinary retry conditions when feasible.

### 8.4 Accessibility

1. The MVP must include an accessibility pass for the top flows.
2. Search, result browsing, detail viewing, `Use This`, feedback, ticket submission, and survey flows must be accessible.

### 8.5 Trust and Sponsorship

1. Sponsored placement must not be confused with organic OER recommendations.
2. The app must not present manipulative or attention-extractive ad patterns.
3. Sponsorship must not obscure source, license, provenance, or trust-status information.

## 9. Telemetry Requirements

The MVP must capture the following events at minimum:

1. `home_viewed`
2. `search_focused`
3. `search_submitted`
4. `results_viewed`
5. `oer_opened`
6. `use_this_marked`
7. `need_better_match_clicked`
8. `oer_rated`
9. `resource_saved`
10. `ticket_submitted`
11. `survey_completed`
12. `sponsor_card_impression`
13. `sponsor_card_clicked`

The telemetry model should support these product metrics:

1. Downloads
2. Successful search rate
3. Ticket submission rate
4. OER rating quality
5. Survey completion rate

## 10. Backlog Alignment

The following backlog items are P0-aligned with this requirements set:

1. Search-first home and results flow
2. Rules-based scoring engine v1
3. License eligibility hard filter
4. Recommendation cards with trust information and rationale
5. `Use This` plus usefulness feedback capture
6. Ticket creation endpoint with prefilled context
7. Accessibility pass for top flows
8. Telemetry events for search outcomes and fallback paths

## 11. Open Decisions

The following planning decisions remain open and should be resolved before implementation is considered complete:

1. Metadata standard baseline
2. Final license validation matrix, including FreeBSD Documentation License handling, CeCILL handling, and any other approved license classes
3. Exact success threshold for a "useful" result event
4. Minimum ticket-context bundle for reviewer triage
5. Minimum product-health dashboard or report shape for Charlie

## 12. Acceptance Criteria Summary

The MVP should be considered functionally ready when:

1. An adult learner can open the app without mandatory account creation.
2. The learner can search for OER from the home screen.
3. The learner receives results with visible source, license, and trust information.
4. The learner can open, save, rate, and mark `Use This` on a result.
5. The learner can request a better match and submit a ticket with context.
6. Ticket expectation-setting is clear and non-deceptive.
7. Sponsored content, if present, is clearly separated from organic results.
8. Unsupported or unclear-license content is excluded or clearly suppressed from surfaced results.
9. Telemetry is available for the defined MVP events and success metrics, including search outcomes, ticket submissions, survey completions, and sponsor interactions.

