# Intro

The idea for this app is to be an easy way to find [Open Educational Resources](https://en.wikipedia.org/wiki/Open_educational_resources), or OER, on a mobile device. To build it, I'm using the "[Build More Architect Dreams](https://github.com/bmad-code-org/BMAD-METHOD) - An AI-driven agile development module for the BMad Method". The rest of the markdown file below and all the other files in the repo so far have been made by [ChatGPT Codex](https://en.wikipedia.org/wiki/OpenAI_Codex) and using this approach. I added and often requested the `$bmad-agent-bmad-leader` command name, but the underlying BMAD system still loads `bmad-master.md` and related `master` naming that is hard-written into the current implementation. I prefer the term "BMad Leader" over "BMad Master", but that is not currently part of my system that is maintained consistently.

Charles Danoff of [Mr. Danoff's Teaching Laboratory, LLC](https://mr.danoff.org)
Chicago
14 March 2026

---

Maintained project guidance below was drafted by OpenAI Codex (BMad Leader) based on the current repo planning artifacts and user direction.

---

# 2k2phd Monorepo

This workspace currently contains the mobile MVP scaffold plus planning and shared-contract docs:

- `mobile-app`: Android client app (single-platform first release)
- `shared`: shared schemas and service contracts
- `docs`: planning, architecture, and operations documentation

Planned backend services such as `oer-matching-api` and `oer-ingestion-worker` are not yet implemented in this workspace.

## MVP Priorities

1. Search-first OER discovery without mandatory account creation
2. Rules-based scoring with approved-license hard filters
3. Recommendation cards with "Why this now," trust signals, and feedback events
4. Clear `Use This` and `Need Better Match` actions
5. Ticket fallback and telemetry that prove whether users find useful OER within 3 searches

## Tier 2 Sandbox

Unlike the core daLab infrastructure (Tier 1) which requires strict human-readability for manual publishing, this project is a "Vibe Coding" experiment. The AI team is authorized and encouraged to implement advanced Android patterns to push the limits of rapid prototyping.

This repo is maintained as a Tier 2 Sandbox within Mr. Danoff's Teaching Laboratory, governed by the Pseudo-Virtual C-Suite (PVCS) roles, including CEO, COO 4, CAO 3, CRO 5, and BMad Leader.

## UX Inspiration

The product experience is intended to emulate the strongest usability qualities of successful mobile apps while applying them to learning (even though not all of them are open source applications):

1. [Podverse](https://github.com/podverse/) for open-source media app patterns and user-respecting product execution
2. [Wikimedia Projects](https://github.com/wikimedia) for trust, public-interest knowledge UX, and long-term community contribution models
3. [DuckDuckGo](https://github.com/duckduckgo) for privacy-aware mobile product thinking and clean interaction patterns
4. [Librera Reader](https://github.com/foobnix/LibreraReader) for open-source mobile reading UX and document-centric interaction ideas
5. [Duolingo](https://github.com/duolingo) for learning-focused motivation and lightweight gamification
6. [WhatsApp](https://github.com/whatsapp) for simplicity and low cognitive overhead
7. [Google Maps](https://github.com/googlemaps/) for direct, high-speed, task-first interaction design
8. [Discord](https://github.com/discord) for clear hierarchy and low-friction navigation
9. [Instagram](https://github.com/facebook) and [TikTok](https://github.com/tiktok) for intuitive onboarding and immediate usability

These are reference models for UX quality, not feature-copying instructions.

## Quick Start

1. Review product loop in `docs/product/mvp-core-loop.md`.
2. Review product requirements in `docs/product/product-requirements.md`.
3. Review mobile architecture baseline in `docs/architecture/mobile-oss-baseline.md`.
4. Implement API contracts in `shared/contracts`.
5. Build vertical slice: open -> home search -> results -> detail actions -> `Use This` / save / rate / fallback ticket.

## Android Scaffold Run (MVP)

1. Open `mobile-app` in Android Studio.
2. Sync Gradle and run `app` on an emulator/device.
3. Validate Home flow: open -> search prompt -> submit -> results list.

## Licensing

1. Code: CeCILL Free Software License Agreement
2. Content and metadata: CC0 1.0 Universal

## Contributors

1. Charles Danoff (Iceman) - Lead Architect
2. daLab Contributors (First Cohort) - Synthetic support team

## Further Reading

For the agent and pattern framework informing this project's governance, see [Patterns for a New Generation: AI and Agents](https://arxiv.org/abs/2506.09696) by Corneli et al.

## Changelog

### 2026-03-14

1. Preserved the original repo intro authored by Charles Danoff at the top of the README. Signed: OpenAI Codex (BMad Master)
2. Added a clearly separated maintained project-guidance section drafted by OpenAI Codex (BMad Master). Signed: OpenAI Codex (BMad Master)
3. Updated MVP priorities to match the current product requirements and core loop documents. Signed: OpenAI Codex (BMad Master)
4. Added a formal UX inspiration section with linked reference organizations and open-source apps. Signed: OpenAI Codex (BMad Master)
5. Updated Quick Start and Android validation flow to match the current no-account search -> results -> action path. Signed: OpenAI Codex (BMad Master)
6. Skimmed and added some edits. Signed: Charles Danoff
7. Added the Tier 2 Sandbox philosophy, formal licensing section, contributor governance bridge, and BMad Leader working title in maintained guidance. Signed: OpenAI Codex (BMad Leader)
8. Added an explicit PVCS governance note and a further-reading link to the patterns paper for project context. Signed: OpenAI Codex (BMad Leader)
