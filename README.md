# Intro

The idea for this app is to be an easy way to find [Open Educational Resources](https://en.wikipedia.org/wiki/Open_educational_resources), or OER, on a mobile device. I am using the "[Build More Architect Dreams](https://github.com/bmad-code-org/BMAD-METHOD) — An AI-driven agile development module for the BMad Method" to try and build this app. The rest of the markdown file below and all the other files in the repo so far have been made by [ChatGPT Codex](https://en.wikipedia.org/wiki/OpenAI_Codex) using this approach. - Charles Danoff of [Mr. Danoff's Teaching Laboratory, LLC](https://mr.danoff.org)

## 2k2phd Monorepo

This workspace contains the core services for the MVP:

- `mobile-app`: Android client app (single-platform first release)
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

1. Review product loop in `docs/product/mvp-core-loop.md`.
2. Review mobile architecture baseline in `docs/architecture/mobile-oss-baseline.md`.
3. Implement API contracts in `shared/contracts`.
4. Build vertical slice: home search -> results -> detail actions -> feedback/ticket.

## Android Scaffold Run (MVP)

1. Open `mobile-app` in Android Studio.
2. Sync Gradle and run `app` on an emulator/device.
3. Validate Home flow: Search prompt -> submit -> Results list.
