# 2k2phd MVP Core Loop (Android)

## Product Intent
2k2phd gives adult learners a low-burden way to find useful, trustworthy Open Educational Resources quickly, then refine only when needed so they can stop searching and start learning.

## Core Loop v1
1. User opens the app without mandatory account creation.
2. User lands on the Home screen.
3. User sees a search-first layout with one clearly separated sponsor area.
4. User submits a query and immediately gets a results list.
5. User opens an OER detail view with source, provenance, and license information.
6. User takes an action: `Use This`, save, rate usefulness, open the original source, or request a better match.
7. If no acceptable result is found, the app offers a prefilled ticket fallback with clear expectation-setting.
8. App asks lightweight refinements only if quality signals are low or the user has not found a useful result within 3 searches.

## Home Screen v1
- Search-first region: ~80% of viewport.
- Sponsor region: ~20% of viewport for a single ad or sponsor placement.
- Prompt: `What do you want to learn today?`
- If sponsor cards are later introduced into recommendation flows, default target is no more than 1 sponsored card per 20 organic cards, always clearly labeled.

## OER Detail Actions (MVP)
- View Original OER
- View trust, source, provenance, and license info
- Save
- Rate Useful / Not Useful
- Use This
- Need Better Match

## Trust and License Requirements
- Show source for every surfaced OER.
- Show license for every surfaced OER.
- Exclude unsupported or ambiguous-license content from surfaced results.
- Keep sponsor content visually separate from organic OER results.

## Refinement Triggers
- User opens 2+ details and takes no action.
- User deep-scrolls results with no saves, positive ratings, or click-through.
- User taps `Need Better Match`.
- Result confidence is low or set is empty.
- User has not found a useful result within 3 searches.

## MVP Telemetry
- home_viewed
- search_focused
- search_submitted
- results_viewed
- oer_opened
- resource_saved
- oer_rated
- use_this_marked
- need_better_match_clicked
- ticket_submitted
- survey_completed
- sponsor_card_impression
- sponsor_card_clicked
