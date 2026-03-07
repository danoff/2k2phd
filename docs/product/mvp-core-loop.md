# 2k2phd MVP Core Loop (Android)

## Product Intent
2k2phd gives educators and learners a low-burden way to find useful Open Educational Resources quickly, then improve relevance only when needed.

## Core Loop v1
1. User lands on post-login Home screen.
2. User sees question prompt and search bar.
3. User submits query and immediately gets a results list.
4. User opens OER detail and can take low-stakes actions.
5. User marks `Use This` to signal intent and continue browsing.
6. App asks lightweight refinements only if quality signals are low.

## Home Screen v1
- Search-first region: ~80% of viewport.
- Pulse region: <=20% of viewport for Hot/Fresh/Activity updates.
- Prompt: `What type of OER do you want to find today?`

## OER Detail Actions (MVP)
- View Original OER
- Save
- Remix
- Use This (mark intent, continue browsing)
- Need Better Match

## Refinement Triggers
- User opens 2+ details and takes no action.
- User deep-scrolls results with no saves/click-through.
- User taps `Need Better Match`.
- Result confidence is low or set is empty.

## MVP Telemetry
- home_viewed
- search_focused
- search_submitted
- results_viewed
- oer_opened
- use_this_marked
- need_better_match_clicked
