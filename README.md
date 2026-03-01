# OER Matcher Monorepo

This workspace contains three services for the MVP:

- `mobile-app`: client app (single-platform first release)
- `oer-matching-api`: rules-based recommendation and ticket APIs
- `oer-ingestion-worker`: OER metadata ingestion and normalization
- `shared`: shared schemas and service contracts
- `docs`: planning, architecture, and operations documentation

## MVP Priorities

1. 3-tap onboarding (`intent`, `time`, `mode`)
2. Rules-based scoring with license hard filters for remix
3. Recommendation cards with "Why this now" and feedback events
4. Ticket-first fallback workflow
5. Trust panel (source, license, contributor signal)

## Quick Start

1. Choose the launch platform in `docs/planning/decision-log.md`.
2. Fill out `docs/planning/backlog.md` with owners and dates.
3. Implement API contracts in `shared/contracts`.
4. Build vertical slice: onboarding -> recommendations -> feedback -> ticket.
