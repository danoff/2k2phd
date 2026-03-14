# 2k2phd Product Requirements

**Status:** Draft  
**Date:** 2026-03-13  
**Author:** OpenAI Codex (BMad Master)  
**Requested by:** CodexSandboxOffline  
**Platform:** Android-first MVP

## 1. Purpose

This document defines the product requirements for the `2k2phd` MVP. It is intended for repo use as an implementation-facing artifact derived from the current product brief and planning materials.

## 2. Product Summary

`2k2phd` is an Android-first learning app for adults age 18+ that helps users find trustworthy, commercially safe Open Educational Resources quickly enough to stop searching and start learning.

The MVP is optimized for a simple outcome:

1. user enters a search
2. user receives relevant OER results with visible trust and license information
3. user finds a useful result within 3 searches

## 3. Target User

Primary user:

1. Adult learner age 18+

Primary contexts:

1. Finding material for a formal course
2. Finding material for self-education

## 4. Primary User Job

Help the user find OER that matches their search within 3 tries so they can stop searching and start learning.

## 5. Product Principles

1. Search must stay primary.
2. Trust must be visible, not implied.
3. Licensing must be conservative and explicit.
4. Ads must not compromise usability or credibility.
5. The app should help users start learning quickly, not trap them in browsing.
6. The product must respect learner attention and avoid manipulative UX patterns.

### 5.1 UX Inspiration and Emulation Goals

The product should study and selectively emulate successful mobile patterns from widely used consumer apps:

1. Instagram
   - Emulate intuitive onboarding, fast visual clarity, and immediate ease of use
2. Discord
   - Emulate clear information hierarchy, strong community-oriented interaction patterns, and low-friction navigation
3. WhatsApp
   - Emulate simple, confidence-building interface decisions and low cognitive overhead
4. Google Search
   - Emulate direct query-first interaction, speed, and obvious relevance-oriented design
5. Duolingo
   - Emulate motivating learning UX, lightweight gamification, and momentum-building feedback loops

These references are inspiration targets, not copying instructions. `2k2phd` should adapt the underlying usability strengths while maintaining its own identity, trust model, and learning purpose.

## 6. MVP Scope

The MVP includes:

1. Android app
2. Account creation and sign-in
3. Search-first home screen
4. OER results list
5. OER detail screen
6. Trust and licensing display
7. Save and rating actions
8. Search refinement support
9. One ad or sponsor placement on the home landing page only

The MVP excludes:

1. iOS or multi-platform launch
2. Child or minor accounts
3. In-app remixing or authoring
4. Advanced AI-generated learning plans
5. Multiple ad placements
6. Broad volunteer-governance systems

## 7. Functional Requirements

### 7.1 Account and Identity

1. The app must allow a user to create an account.
2. The app must allow a user to sign in and sign out.
3. The app must persist saved resources and ratings to the signed-in account.
4. The app should minimize onboarding friction.
5. The MVP does not require MFA.
6. Future-state identity exploration may include MFA and Wikimedia-aligned federation, but neither is an MVP requirement.

### 7.2 Home Screen

1. The home screen must prioritize search as the primary action.
2. Approximately 80% of the home landing view should support search and discovery activity.
3. Approximately 20% of the home landing view may be reserved for one ad or sponsor placement.
4. The ad or sponsor placement must be clearly distinguishable from search results.
5. The home screen must not present additional ad surfaces beyond the single reserved area.

### 7.3 Search and Recommendations

1. The app must allow the user to submit a free-text search query.
2. The app must return a results list after query submission.
3. The app must rank results using rules-based matching for MVP.
4. The app must support refinement when the initial results are weak or the user requests a better match.
5. The app should optimize for useful discovery within 3 searches.
6. The app should show a short explanation of why a result is being shown when feasible.
7. Sponsored recommendations, if shown in recommendation flows beyond the home landing page, must be clearly labeled and interleaved conservatively, with a default target of no more than one sponsored card per 20 organic recommendation cards unless later product decisions explicitly change that ratio.

### 7.4 OER Detail and Actions

1. The app must allow the user to open a result detail view.
2. The detail view must show source and license information.
3. The detail view must provide a path to the original OER.
4. The detail view must allow the user to save a resource.
5. The detail view must allow the user to rate usefulness.
6. The detail view must allow the user to indicate they need a better match.

### 7.5 Trust, Provenance, and Licensing

1. The app must display source provenance for surfaced OER.
2. The app must display the applicable license for surfaced OER.
3. The app must exclude content with unclear provenance or ambiguous licensing.
4. The app must conservatively filter out license classes that are not explicitly approved for MVP.
5. The MVP approved content classes are:
   - CC0
   - CC BY
   - CC BY-SA
   - similar commercially safe and open licenses such as the FreeBSD Documentation License and CeCILL, subject to explicit validation

### 7.6 Ratings and Feedback

1. The app must allow the user to submit a usefulness rating for an opened OER.
2. The app must capture whether a result was helpful or not helpful.
3. The app should use this feedback to inform future ranking improvements.

## 8. Non-Functional Requirements

### 8.1 Usability

1. The app must maintain a low-friction search-to-learning flow.
2. The app must avoid cluttered layouts that compete with the primary search task.
3. The app must keep sponsorship visually restrained.
4. The app should aim for consumer-grade intuitiveness comparable to leading mobile apps in onboarding, navigation clarity, and motivational interaction design.

### 8.2 Trust

1. Sponsored placement must not be confused with organic OER recommendations.
2. The app must not present manipulative or attention-extractive ad patterns.
3. Trust and license information must be visible without requiring deep navigation.

### 8.3 Accessibility

1. The MVP must include an accessibility pass for the top 5 flows.
2. Core search, result browsing, detail viewing, save, and rating flows must be accessible.

### 8.4 Performance

1. The product should target time to first useful card under 20 seconds in pilot conditions.
2. The app should support fast query submission and readable result presentation on common Android devices.

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
10. `sponsor_card_impression`
11. `sponsor_card_clicked`

The telemetry model should support these product metrics:

1. Downloads
2. Successful search rate
3. OER rating quality

Metric definitions:

1. Successful search rate: percentage of users who find and open a useful OER within 3 searches
2. OER rating quality: percentage of opened OERs receiving positive usefulness ratings
3. Sponsor card impression: a tracked view of a clearly labeled sponsor placement in an eligible screen context
4. Sponsor card click: a tracked user tap on a clearly labeled sponsor placement

## 10. Backlog Alignment

The following backlog items are P0-aligned with this requirements set:

1. Onboarding screen and telemetry events
2. Rules-based scoring engine v1
3. License eligibility hard filter
4. Recommendation feed UI and "Why this now"
5. Helpful / Not helpful event capture
6. Accessibility pass for top 5 flows

The following require clarification before implementation if kept in MVP:

1. Ticket creation endpoint and prefilled context
2. Trust panel depth and contributor signal fields

## 11. Open Decisions

The following planning decisions remain open and should be resolved before implementation is considered complete:

1. Metadata standard baseline
2. Final license validation matrix, including FreeBSD Documentation License handling, CeCILL handling, and any other approved license classes
3. Exact success threshold for a "useful" result event
4. Persistence model and auth provider for account creation and sign-in

## 12. Acceptance Criteria Summary

The MVP should be considered functionally ready when:

1. an adult learner can create an account and sign in
2. the learner can search for OER from the home screen
3. the learner receives results with visible source and license information
4. the learner can open, save, and rate a result
5. the learner can request a better match
6. only one home-screen ad or sponsor placement is present
7. sponsored content is clearly separated from organic results
8. sponsor-card interleaving, if used beyond the home landing page, does not exceed the current default target of one sponsored card per 20 organic recommendation cards and remains clearly labeled
9. unsupported or unclear-license content is excluded from surfaced results
10. telemetry is available for the defined MVP events and success metrics, including sponsor impressions and clicks
