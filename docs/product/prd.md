---
stepsCompleted:
  - step-01-init
  - step-02-discovery
  - step-02b-vision
  - step-02c-executive-summary
  - step-03-success
  - step-04-journeys
  - step-05-domain
  - step-06-innovation
  - step-07-project-type
  - step-01b-continue
  - step-08-scoping
  - step-09-functional
  - step-10-nonfunctional
  - step-11-polish
inputDocuments:
  - docs\product\product-requirements.md
  - docs\product\mvp-core-loop.md
  - docs\planning\decision-log.md
  - docs\planning\backlog.md
  - README.md
  - planning-artifacts\briefs\2k2phd-product-brief-2026-03-13.md
  - planning-artifacts\research\market-oer-mobile-app-research-2026-03-07.md
  - planning-artifacts\research\technical-oer-mobile-app-technical-needs-research-2026-03-08.md
  - planning-artifacts\research\domain-open-educational-resources-sector-research-2026-03-10.md
workflowType: prd
projectName: charl
user_name: CodexSandboxOffline
date: 2026-03-14
documentCounts:
  briefCount: 1
  researchCount: 3
  brainstormingCount: 0
  projectDocsCount: 5
classification:
  projectType: mobile_app
  domain: edtech
  complexity: medium
  projectContext: brownfield
discoveryNotes:
  - Charlie is the CEO and preferred form of address is Charlie.
  - Human-facing references should prefer BMad Leader.
  - Multilingual support is a near-term post-MVP requirement.
  - MVP must include localization readiness so future multilingual expansion is not blocked.
  - Add a documentation and planning task for CEO-authored short README descriptions in other languages.
  - Add internal aAR governance artifacts under planning outputs in their own directory.
  - Use the provided PVCS aAR Template v1.1 for those records.
  - BMad Leader is not part of the PVCS and should not be represented as a PVCS sign-off role.
  - Any aAR informed by BMad Leader should use stakeholder-perspective framing, not false PVCS membership.
visionNotes:
  - A strong delight moment is when a user finds an acceptable OER substitute for a paid course resource on the first useful match.
  - The differentiation moment is when the user realizes a free resource can be better than the paid option they expected to need.
  - The deeper mission includes advocating for the OER movement and reducing textbook costs across the broader learning ecosystem.
  - The aspirational product posture is to offer world-class Android UX/UI in service of learning.
  - If no acceptable OER is found, the product should support ticket creation with explicit expectation-setting and no guarantee of concierge fulfillment.
  - Ticket response expectations may range from 1 to 365 days because fulfillment depends on Charlie and unpaid volunteers.
  - Volunteer support is inspired in part by Wikimedia-style contribution models.
  - Documentation should distinguish CC0-style metadata or site text licensing from trademark ownership.
  - ORCID is a useful reference model for CC0 plus trademark separation.
  - README or related documentation should clarify trademark ownership for Mr. Danoff's Teaching Laboratory, LLC.
  - Future-state interoperability should consider Wikibase integration.
  - ORCID-linked identity or MFA is a future-state exploration.
  - Blockchain should remain exploratory future-state only, not a committed roadmap item.
lastStep: 11
---

# Product Requirements Document - charl

**Author:** CodexSandboxOffline
**Date:** 2026-03-14

## Executive Summary

`2k2phd` is an Android-first learning app that helps users find high-quality, trustworthy Open Educational Resources quickly enough to replace paid learning materials and start learning without unnecessary friction. The MVP is designed around a simple core loop: open the app, search, review results, inspect detail and trust signals, and take a low-friction action such as use-this, rate usefulness, or request a better match. The product operates in the education technology domain with medium complexity because its core challenges center on trust, licensing, provenance, accessibility, sponsorship restraint, privacy boundaries, and user confidence rather than high-regulation compliance regimes.

The product's near-term job is not to index as much OER as possible. Its job is to help a user find a useful, acceptable OER alternative within three searches, with a particularly strong success case when the user can replace a paid course resource on the first meaningful match. The product is intentionally trust-first: only clearly acceptable resources should be surfaced, source and license information must remain visible, and the experience must preserve learner attention rather than exploit it. If the product cannot find an acceptable match, it should offer an honest fallback path through a request ticket workflow with explicit expectation-setting and no false promise of concierge fulfillment.

The MVP should avoid unnecessary private-data collection. It will not begin with account creation as a core requirement. Instead, it should provide clear age and usage guidance indicating that the app is intended for people who have finished high school or are over 18, and that younger users should seek permission or guidance from a parent, guardian, or teacher before relying on it. This keeps early privacy and identity scope intentionally narrow while preserving room for future identity systems. The broader mission extends beyond search usability. `2k2phd` is intended to support the OER movement and help reduce textbook-cost burdens across the wider education ecosystem, while beginning with a tightly constrained Android MVP.

This creates a deliberate split between immediate launch scope and longer-term mission: minimal-friction anonymous or low-identity MVP execution now, broader educational affordability and ecosystem impact later. The product should therefore be built with future readiness for multilingual support, volunteer-informed contribution models, structured metadata interoperability, stronger identity and trust systems, and possible AI-agent or LLM integration, without allowing those ambitions to derail MVP delivery. The MVP itself should not depend on AI and is expected to rely primarily on non-AI mechanisms such as rules-based ranking and transparent recommendation logic.

### What Makes This Special

`2k2phd` is differentiated by combining replacement-quality OER discovery with unusually strong UX expectations for an education product. The product is not merely a repository browser or generic search interface. It is intended to make users feel that the free option is not a compromise, but a better path: easier to use, more trustworthy, and more aligned with their actual learning needs than the paid material they expected to buy.

Its core insight is that the real product opportunity sits at the intersection of affordability, trust, and experience design. Users do not only need "more open resources." They need a system that helps them recognize which open resources are actually worth their time, why they were recommended, whether they are commercially and ethically safe to use, and what to do if the system does not yet have a good answer. That is why the product combines search, recommendation explanation, provenance visibility, conservative licensing rules, restrained sponsorship, privacy-aware scope control, and a transparent volunteer-supported fallback path.

The product also carries a future-state strategic posture. It should remain open to multilingual expansion, volunteer and community contribution models inspired in part by Wikimedia ecosystems, and structured metadata or identity integrations such as Wikibase, Wikimedia-account sign-in, ORCID, and possibly Authelia where they materially improve trust, provenance, interoperability, or account security. Future AI-agent or LLM-assisted capabilities may also be explored if they improve usefulness without weakening transparency or source traceability. Exploratory ideas such as blockchain-based educational ledgers and direct Touchpoints-style feedback-system integration may inform long-range thinking, but they are not part of the committed MVP or near-term delivery baseline.

## Project Classification

- **Project Type:** Mobile application
- **Domain:** Education technology
- **Complexity:** Medium
- **Project Context:** Brownfield

This is a brownfield product because substantial repo documentation, planning artifacts, research, backlog material, and initial product requirements already exist. The PRD is therefore formalizing and aligning an existing direction rather than defining a product from zero.

## Success Criteria

### User Success

MVP user success is defined by a fast, confidence-building path to a useful OER. The strongest success case is that a user finds a first useful match within 2 swipes or less after entering a search. A useful match should be understood behaviorally, similar to a dating-style matching interaction: the result is useful when the user actively chooses the OER because it meets their need in that moment. In MVP terms, the clearest primary signal of a successful match is the user selecting `Use This` on a surfaced OER.

A broader success case is that the user finds an acceptable OER alternative within 3 searches, with clear source, provenance, and license information visible enough to support trust. Success is not only about finding any open resource, but about finding one the user considers good enough to act on.

A second form of user success is constructive failure handling. If the app does not produce a satisfactory result, the user should be able to submit a request ticket for more OER help without confusion or false expectations. Ticket submission is itself a meaningful success signal because it shows the user still sees value in the product instead of abandoning it immediately. It should be treated as a retained-trust outcome, not only a failure outcome.

A third form of user success is appreciation and perceived usefulness. The MVP should include a lightweight survey or feedback mechanism that allows users to express whether the app helped them, whether they appreciated the experience, and whether they would try it again. A meaningful early signal is survey completion by at least 0.5% of users on a given day.

### Business Success

Near-term business success is defined by proof that the product is economically and behaviorally viable. In the first 3 months, Charlie should be able to see whether users are downloading the app, using it to search for OER, and generating enough engagement to justify continued iteration. Early business validation should focus on installs, search activity, successful-match behavior, ticket volume, and survey appreciation signals.

In the 12-month horizon, business success should be evaluated more directly through monetization and growth. The most important question is whether the ad or sponsor model generates enough money to cover operating costs. A stronger success state is reached if monetization not only covers costs but produces profit. A second question is whether growing usage and word-of-mouth make the app more attractive to advertisers or sponsors. Business success therefore depends on two linked outcomes: growing user attention around OER discovery and evidence that restrained sponsorship or advertising can sustain the product economically.

### Technical Success

The MVP is technically successful if users can reliably discover, install, and run the app on supported Android devices. Downloadability is the first non-negotiable technical requirement: if the app cannot be installed and opened easily, the concept has not reached a valid test state.

The second technical requirement is measurement fidelity. The system must track enough data to distinguish successful searches from failed searches and to connect those outcomes to user behavior such as result impressions, result opens, `Use This` actions, ticket creation, and survey completion. This tracking is essential because the product promise depends on proving whether users are actually finding acceptable OER quickly.

The third technical requirement is baseline trust and usability stability. The app must surface source and licensing information clearly, avoid obviously ambiguous or disallowed results, and maintain a usable feedback or ticket path when matching fails. Accessibility and sponsor restraint remain important technical-quality expectations even if the earliest MVP keeps implementation lightweight.

### Measurable Outcomes

The MVP should define success using a compact set of measurable outcomes:

- A meaningful percentage of users achieve a first useful match within 2 swipes or less.
- A meaningful percentage of users find an acceptable OER within 3 searches.
- A successful match is primarily captured through the explicit `Use This` action.
- Save, positive usefulness feedback, source click-through, and survey response are supporting signals rather than the primary success event.
- Users who fail to find a match can submit a request ticket successfully.
- At least 0.5% of users on a given day complete an appreciation or usefulness survey.
- The app can be successfully downloaded and opened by target users on supported Android devices.
- Search telemetry distinguishes successful searches from failed searches.
- Ad or sponsor activity can be measured clearly enough to determine whether monetization is covering costs and, at a stronger success level, generating profit.

Initial quantitative targets should be finalized later, but the MVP must be instrumented so these outcomes can be measured credibly.

## Product Scope

### MVP - Minimum Viable Product

The MVP proves the core concept: people can download the app, search for OER, review trustworthy results, and find useful learning resources quickly. It should support the minimum trust layer required for credibility, including visible source and license information, restrained sponsorship, and a feedback or ticket path when the app does not find a good answer. The MVP should also include telemetry for search success, failure, ticket usage, and appreciation feedback.

### Product Definition Notes

- **Replacement-quality OER:** A resource is replacement-quality when a learner is willing to use it instead of a paid, unavailable, or otherwise unsuitable alternative.
- **Tickets as product-learning signals:** Request tickets are both fallback support and product-learning signals. MVP reporting should capture ticket themes, not only ticket counts, so failed searches improve future discovery.
- **Glossary follow-up:** Downstream documentation should define recurring terms such as OER, provenance, replacement-quality, `Use This`, retained-trust signal, and commercially safe license to prevent drift across UX, architecture, epics, and external copy.

### Growth Features (Post-MVP)

Growth begins when the product shows enough user value that word-of-mouth, repeat usage, and broader attention increase downloads. Post-MVP growth features should strengthen discoverability, recommendation quality, feedback handling, multilingual readiness, sponsorship attractiveness, and broader ecosystem trust. The practical growth goal is to make the app valuable enough, and visible enough, that advertisers or sponsors are willing to pay without the product becoming exploitative.

### Vision (Future)

The long-term vision is larger than app success. The aspiration is for OER to become the standard learning-resource model worldwide rather than proprietary materials remaining the default. In that future, `2k2phd` would function not only as an app, but as part of a broader trust, discovery, metadata, and advocacy ecosystem that helps open learning resources become the normal path for learners everywhere.

## User Journeys

### Journey 1: Adult Learner Finds a Useful Match Fast

Charlie meets Maya, a 29-year-old adult learner who needs a substitute for an expensive course resource. She opens `2k2phd` hoping not just to find something free, but to find something good enough to actually use. She is skeptical because free educational resources often feel scattered, low-quality, or hard to trust.

Maya enters a search, scans the first set of results, and quickly notices that `2k2phd` does not feel like a cluttered repository. She sees a focused interface, visible trust and license information, and recommendations that appear curated rather than random. Within 2 swipes or less, she finds an OER that looks credible, relevant, and practical for what she needs right now.

The decision point in her journey is when she selects `Use This`. That is the use decision: she has found a free resource that genuinely meets her need and may replace something she thought she would have to pay for. Her emotional state changes from doubt and cost-anxiety to relief and momentum. The product has not just shown her open content; it has helped her act on it.

This journey reveals requirements for high-quality ranking, fast result comprehension, visible provenance and license data, and a clearly instrumented `Use This` success event.

### Journey 2: Adult Learner Does Not Find a Match and Requests Help

BMad Leader also meets Jordan, a learner whose search is more difficult. Jordan opens the app with a specific need but does not find a satisfying result in the first pass. He reviews the details, checks the trust information, and still feels that nothing fits well enough.

Instead of abandoning the product entirely, Jordan chooses the fallback path. He submits a request ticket asking for more OER help. The app sets expectations honestly: this is not guaranteed concierge support, and response times may vary from 1 to 365 days because help depends on Charlie and unpaid volunteers. Even so, Jordan submits the request because he trusts that the app is trying to help rather than pretending everything is solved.

The decision point in this journey is not immediate content discovery, but whether Jordan still trusts the system enough to ask for help. His emotional state moves from disappointment to cautious optimism. The system preserves credibility by acknowledging its limits and offering a structured next step.

This journey reveals requirements for transparent failure handling, low-friction ticket submission, clear SLA language, and telemetry that treats ticket creation as a retained-trust signal rather than only as failure.

### Journey 3: Charlie Reviews Tickets and Supports Learners

In MVP, Charlie is not only the CEO but also the primary human support and review layer behind the fallback workflow. He receives ticket submissions from learners who could not find a satisfactory OER and needs enough context to decide what, if anything, can be done.

Charlie's journey starts when he reviews a submitted request. He needs to understand what the learner searched for, what results were shown, why they still failed to find a match, and whether a better OER can realistically be suggested. In the future, unpaid volunteers may share this workload, but in MVP the flow must be usable by Charlie alone.

The decision point in this journey is whether Charlie can triage the request efficiently and decide on a realistic next action: suggest a better resource, identify a metadata gap, spot a search-quality issue, or conclude that the system currently lacks a good answer. His emotional state should move from overload risk toward manageable triage. If the system gives him poor context, support becomes unsustainable.

This journey reveals requirements for ticket context capture, reviewer triage views, basic workflow organization, and minimal operational burden for a one-person MVP support model.

### Journey 4: Charlie Reviews Product Health and Monetization Signals

Charlie also interacts with the system as an operator who wants to know if the product is actually working. He is not asking abstractly whether the app feels promising. He wants to know whether users are downloading it, finding OER, submitting tickets, completing surveys, and generating ad or sponsor value.

His journey begins in an operations or analytics view, where he checks whether users are getting first useful matches, whether `Use This` events are happening within the target interaction window, whether failed searches are creating ticket demand, and whether survey completion signals appreciation. He also wants to understand whether advertising or sponsorship is covering costs and whether growth is making the audience more attractive to sponsors. Because MVP has no account system, this journey depends on session-level telemetry that can still distinguish search success and failure patterns credibly.

The decision point in this journey is whether the data is strong enough to support product and business decisions. Charlie should be able to tell whether the app is earning trust, improving access, and becoming economically sustainable. Without that visibility, he is building in the dark.

This journey reveals requirements for telemetry dashboards, search success and failure reporting, survey metrics, ticket-volume visibility, and monetization reporting tied to cost coverage and profit.

### Journey 5: OER Content Creator Wants Their Resource Found and Used

BMad Leader meets Elena, an OER content creator who has published useful educational material and wants learners to actually find it. She does not want her work buried under poor metadata, weak attribution, or irrelevant ranking systems. She wants discoverability, proper credit, and confidence that the right learners can benefit from what she created.

Elena's journey begins outside the app but matters deeply to the ecosystem. If her metadata is structured well and her licensing is clear, `2k2phd` can surface her work to learners who need it. If not, the system may miss valuable resources entirely. She cares that the app treats provenance, attribution, and open-license logic seriously.

The decision point in this journey is whether the system actually gives quality open work a fair chance to be discovered and selected. Her resource is surfaced, trusted, and chosen by a learner through a `Use This` event. Her emotional outcome is validation that quality open work can actually compete with proprietary alternatives.

This journey reveals requirements for strong metadata handling, conservative license logic, attribution fidelity, and future ecosystem thinking around creator visibility and trust.

### Journey 6: Partner Ecosystem User Wants Interoperability and Trust

BMad Leader meets Sam, who works with a partner ecosystem organization such as OER Commons or a Wikimedia-aligned project. Sam is interested in whether `2k2phd` handles open content responsibly, preserves attribution, respects metadata quality, and creates value for the broader open-education ecosystem rather than simply extracting from it.

Sam's journey begins when evaluating `2k2phd` as a potential ecosystem participant. He wants to see that partner resources are surfaced accurately, linked back appropriately, and contextualized with clear source and license signals. Over time, he may care about referral traffic, metadata interoperability, and structured integrations such as Wikibase.

The decision point in this journey is whether Sam sees `2k2phd` as a credible discovery and advocacy layer rather than a low-trust scraper or opaque recommendation engine. His emotional state moves from caution to cautious partnership interest.

This journey reveals requirements for partner attribution, source-link fidelity, metadata interoperability, referral awareness, and future integration readiness.

### Journey 7: Teacher or School Administrator Recommends the App to Adult Learners

BMad Leader meets Professor Lewis, a college instructor or school administrator who works with students who are over 18. Lewis is not looking for entertainment software. He wants to know whether `2k2phd` is trustworthy enough to recommend as a practical option for students who need lower-cost or no-cost learning materials.

His journey begins when evaluating whether the app is credible, appropriate, and safe to mention to adult learners. He wants to see clear age guidance, honest claims, visible licensing and source information, and enough quality in the app experience that recommending it does not feel reckless or embarrassing. If the app looks chaotic, low-trust, or deceptive about sponsorship, he will not recommend it.

The decision point in this journey is whether Lewis feels comfortable telling adult students to try `2k2phd` instead of assuming they must buy a proprietary resource. His emotional outcome should move from skepticism to professional confidence.

This journey reveals requirements for recommendation-worthy trust signals, clear age-positioning, visible attribution and licensing, restrained sponsorship, and a user experience polished enough for educational endorsement.

### Journey 8: Future Admin or Integration Steward Expands the System

Finally, BMad Leader meets Priya, a future admin or integration steward responsible for managing trust rules, metadata structures, and ecosystem integrations as the product matures. Priya is not an MVP actor in full form, but this role matters because current decisions can either support or block future evolution.

Her journey begins when the system grows beyond its earliest manual phase. She may need to manage license rules, trust heuristics, multilingual readiness, identity integrations, or external metadata systems such as Wikibase, ORCID-linked trust flows, or other federation paths. She needs the product to have been built with enough structure that future enhancement is possible without major rewrites.

The decision point in this journey is whether new integrations and governance systems can be added without breaking the trust-first core. Her emotional outcome is confidence that the product has a scalable foundation rather than a fragile prototype.

This journey reveals requirements for modular rules, structured metadata design, future integration boundaries, and architectural readiness for growth beyond MVP.

### Journey Requirements Summary

These journeys include both direct MVP interaction journeys and broader ecosystem or future-state journeys. Together they reveal several capability areas that the PRD must cover:

- Fast learner-facing search and result evaluation
- Clear `Use This` success action
- Visible provenance, source, and license information
- Honest fallback ticket workflow with expectation-setting
- Reviewer context and lightweight support triage for Charlie in MVP
- Search-success, search-failure, survey, and monetization telemetry
- Strong metadata handling and attribution fidelity
- Partner-trust and referral-aware ecosystem behavior
- Recommendation-worthy trust signals for teachers and administrators serving adult learners
- Future readiness for multilingual support, structured metadata systems, and identity or interoperability integrations

## Domain-Specific Requirements

### Compliance & Regulatory

- The MVP should be positioned for users who have finished high school or are over 18.
- If younger users encounter the product, the app should provide clear guidance to seek parent, guardian, or teacher permission before relying on it.
- The product should minimize collection of personal data in MVP and avoid unnecessary private-data stewardship.
- The app should maintain accessibility expectations appropriate for educational software and adult learners using Android devices.
- The system should conservatively respect licensing boundaries for surfaced OER and avoid ambiguous or non-approved content by default.
- Noncommercial Creative Commons licenses such as `CC BY-NC-SA` should not be treated as automatically safe for MVP inclusion in a for-profit, monetized app context. They should remain an explicit policy and legal-review decision before inclusion.

### Technical Constraints

- Source, provenance, and license information must remain visible at the point of the use decision.
- The app must separate open metadata concerns from any private user or ticket-submission data.
- The no-account MVP means telemetry must work through privacy-conscious session-level tracking rather than user-account histories.
- Ticket workflows must be transparent about volunteer-supported response expectations and non-guaranteed fulfillment.
- The product should avoid architecture choices that block future multilingual support, Wikibase-style metadata integration, future identity systems, or future community contribution workflows.
- The app should support a trust-first recommendation model where learners can make fast decisions without losing visibility into source quality or licensing status.

### Integration Requirements

- OER metadata quality and attribution fidelity matter because creators and partners need their work surfaced correctly.
- Partner ecosystems such as OER Commons and Wikimedia-style projects should be treated as important reference environments for attribution, interoperability, and trust.
- Future interoperability with Wikibase is a serious strategic option and should remain architecturally feasible.
- ORCID-linked identity or MFA is future-state only, not MVP.
- Touchpoints-style feedback handling is a reference or future-state possibility, not a required MVP integration.
- Community contribution pathways should remain feasible in the future for metadata improvement, quality review, advocacy, and possible volunteer support participation.

### Risk Mitigations

- **Risk:** Users see low-quality or ambiguous-license resources.
  **Mitigation:** Conservative filtering, explicit trust signals, visible provenance, and conservative license-policy decisions.

- **Risk:** Teachers or administrators do not trust the app enough to recommend it.
  **Mitigation:** Polished UX, honest claims, visible licensing, restrained sponsorship, and clear age-positioning.

- **Risk:** Ticket demand exceeds Charlie's and volunteer capacity.
  **Mitigation:** Explicit SLA expectations, triage-friendly workflows, honest non-concierge positioning, and gradual community-supported contribution models where appropriate.

- **Risk:** Partner ecosystems see the app as extractive rather than collaborative.
  **Mitigation:** Attribution fidelity, referral awareness, ecosystem-respecting integration design, and visible respect for open-content norms.

- **Risk:** Privacy scope expands unintentionally.
  **Mitigation:** No-account MVP, strict separation of public metadata from private user-related information, and minimal-data collection practices.

- **Risk:** The app fails to attract sponsors or ad revenue, leaving no sustainable income.
  **Mitigation:** Measure monetization early, preserve restrained but testable sponsor placement, track cost coverage explicitly, and keep optional future business-model exploration open.

- **Risk:** The product feels too one-sided or top-down rather than like an open-source, mission-aligned community effort.
  **Mitigation:** Preserve a credible pathway for community contribution, make the project's open values legible, and enable future participation in review, advocacy, metadata improvement, or ecosystem support.

## Innovation & Novel Patterns

### Detected Innovation Areas

The primary innovative aspect of `2k2phd` is not flashy mobile interaction or a brand-new app category. It is the attempt to make OER discovery function as replacement-quality matching rather than generic open-resource browsing. The product is trying to help a learner find an open resource that is good enough to substitute for a paid educational resource they otherwise expected to use or purchase. That framing is more specific and more demanding than ordinary search or repository browsing.

A second innovation pattern is ethical execution rather than novelty theater. `2k2phd` is intentionally trying to execute an existing category of learning-resource discovery much better and more effectively through trust-first UX, visible provenance, conservative license logic, restrained sponsorship, and honest fallback support. The innovation is therefore partly in combination: better usability, better trust signaling, and stronger alignment with the values of open education.

A third innovation pattern sits in the product's future-state strategic posture. The most novel long-range idea is blockchain-style educational ledger thinking: a possible future where open educational ecosystems, metadata, provenance, and trust relationships are coordinated through a more shared and durable ledger model. This is exploratory rather than committed, but it represents the most conceptually ambitious part of the broader vision.

### Market Context & Competitive Landscape

In the current market, many products either provide generic search, repository access, textbook platforms, or mission-driven OER infrastructure. `2k2phd` is not trying to beat those systems by merely hosting more material. Its differentiation is the attempt to improve the quality of the matching decision itself: helping users find open resources they are actually willing to use in place of proprietary options.

This means the product's market position is not "new category creator" so much as "higher-trust, higher-utility rethinking of an existing category." That is strategically important because it lowers the burden of claiming radical novelty while still preserving meaningful differentiation.

### Validation Approach

The innovation should be validated through user behavior, not branding language. The most important validation question is whether learners actually treat surfaced OER as acceptable substitutes for paid resources. For MVP, this should be tested through measurable actions such as `Use This`, success within 2 swipes or less, success within 3 searches, ticket creation after failure, and appreciation feedback.

A second validation question is whether ethical execution creates real product advantage. This can be tested by observing whether users trust the app enough to continue using it after failed searches, whether teachers or administrators feel comfortable recommending it to adult learners, and whether creators or partners see the system as respectful rather than extractive.

The future-state innovation ideas should be validated separately and later. Blockchain-style educational ledger thinking, AI-assisted capabilities, and more advanced ecosystem coordination should be treated as exploratory concepts that require research, feasibility review, and staged experimentation rather than premature roadmap commitment.

### Risk Mitigation

The main innovation risk is overclaiming novelty when the product is really a strong execution play. This should be mitigated by describing the product honestly: the novelty is in replacement-quality OER matching, trust-first design, and ecosystem-oriented thinking, not in pretending the app invented learning discovery.

A second innovation risk is strategic distraction. Long-range concepts such as blockchain-ledger thinking can be intellectually valuable without being MVP-relevant. This should be mitigated by keeping exploratory innovation clearly separated from near-term product scope.

A third innovation risk is that the boldest future-state concepts may never materialize. If that happens, the product should still be worth building because it serves as a practical engine for learning more about AI, coding, product design, and sustainable for-profit OER business strategy. In other words, the fallback value is not only market success but also capability-building and sharper understanding of how an ethical OER business could work in practice.

## Mobile App Specific Requirements

### Project-Type Overview

`2k2phd` is an explicitly native Android application for MVP. The product is not intended to launch as cross-platform, web-first, or desktop-first in its initial form. This simplifies the early product surface and allows the MVP to focus on the Android learner experience, store compliance posture, trust-first presentation, and fast OER discovery rather than spreading effort across multiple client platforms.

The mobile-app strategy is intentionally narrow: Android only, adult-oriented positioning, minimal private-data scope, and strong reliance on remote access to OER repository data through APIs or other service-layer integrations. The product should therefore be designed as a lightweight but credible mobile discovery layer rather than a self-contained offline content platform in MVP.

### Technical Architecture Considerations

The app should be implemented as a native Android client that retrieves OER discovery data through backend or repository-facing API integrations. The mobile layer is primarily responsible for search input, result presentation, trust signaling, use-decision capture, ticket fallback, and telemetry. Repository access should be handled through network-dependent service calls rather than assuming fully local content availability.

Because the MVP has no account system, session-level telemetry becomes especially important. The app must support measurement of search attempts, result views, `Use This` selections, failed-search paths, ticket submissions, survey completion, and sponsor interactions without relying on persistent user profiles. This makes instrumentation quality a core mobile requirement rather than a secondary analytics concern.

The architecture should also preserve room for future capabilities without forcing them into MVP. That includes future multilingual readiness, richer offline behavior, community contribution pathways, advanced identity systems, and possible ecosystem integrations such as Wikibase or ORCID-linked trust features.

### Platform Requirements

- MVP is native Android only.
- The initial release should prioritize common Android devices and a stable, readable search-to-result experience.
- The app should rely on live network access to retrieve OER-related data through APIs or connected service layers.
- Offline support is not a firm MVP requirement, but limited offline behavior may be included if it is easy to implement without distorting scope.
- If offline behavior is introduced in MVP, it should remain narrow and defensive, such as basic caching or graceful degraded viewing rather than full offline discovery.

### Device Permissions

The MVP should follow a minimal-permissions posture. No special device capability should be required unless it directly supports a proven core user need.

- Avoid unnecessary access to location, camera, microphone, contacts, or similar sensitive device features.
- Request only the minimum platform permissions needed for core app functionality.
- If storage-related behavior is needed for lightweight caching or opening linked resources, it should be implemented conservatively and with minimal user friction.
- The product should not depend on hardware novelty to create value; its differentiation is in matching quality, trust signals, and usability.

### Offline Mode

Offline mode should be treated as conditional and scope-sensitive rather than assumed.

- Core MVP behavior should assume network access for search and repository-linked discovery.
- If implementation cost is low, limited caching or graceful fallback can be included to improve resilience.
- Full offline browsing, offline-first architecture, or local content synchronization should be treated as post-MVP unless later evidence makes them essential.
- The product should fail clearly and honestly when network conditions prevent effective search, rather than pretending the system is more offline-capable than it is.

### Push Strategy

Push notifications are included in MVP, but they should be used carefully and in a trust-preserving way.

- Push should support legitimate learner or product-value use cases rather than manipulative engagement.
- The app should avoid spammy notification patterns or attention-extractive nudging.
- Notifications should be aligned with trust-first product behavior, such as meaningful updates or useful reminders, not generic retention pressure.
- Exact push use cases can be refined later, but the MVP should preserve implementation room for them without letting notifications become a distraction from the core search experience.

### Store Compliance

The core mobile store compliance stance for MVP should include:

- adult-oriented positioning
- clear age guidance
- minimal data collection
- non-deceptive sponsorship labeling

This means the app should present itself honestly as a product intended for users who have finished high school or are over 18, while providing guidance that younger users should seek parent, guardian, or teacher permission. Sponsorship or ad presentation must remain clearly distinguished from organic OER results. Privacy disclosures, age-related language, and product claims should all be consistent with a trust-first educational app rather than an attention-maximizing consumer app.

### Implementation Considerations

The implementation should favor simplicity and credibility over feature breadth.

- Optimize for fast search, fast comprehension of results, and fast use decisions.
- Keep mobile UX polished enough that educators, administrators, and adult learners feel comfortable trusting and recommending it.
- Use network-dependent repository access as the primary discovery path in MVP.
- Keep permissions narrow, privacy scope low, and sponsorship behavior clearly labeled.
- Treat offline expansion, richer identity, deeper partner integration, and more sophisticated ecosystem features as future growth areas unless they become cheap and essential enough to include earlier.

## Project Scoping & Phased Development

### MVP Strategy & Philosophy

**MVP Approach:** Lean native-Android problem-solving MVP with strong trust and usability quality

**Resource Requirements:** Small cross-functional effort focused on Android delivery, OER/repository integration, trust logic, telemetry, ticket handling, and restrained monetization instrumentation.

This MVP is not trying to prove every future-state ambition. It is trying to prove one core claim: `2k2phd` can help a learner find an acceptable OER substitute for a paid learning resource quickly enough to act on it, while preserving trust when no good match is found.

### MVP Feature Set (Phase 1)

**Core User Journeys Supported:**

- Adult learner finds a useful match and selects `Use This`.
- Adult learner fails to find a match and submits a ticket.
- Charlie reviews ticket demand and product-health signals.
- Charlie evaluates whether trust-preserving monetization has viability.

**Must-Have Capabilities:**

- Native Android app only.
- Reliable app install and launch.
- Search-first OER discovery through live API/repository access.
- Results and detail views with visible source, provenance, and license information.
- Explicit `Use This` action as the primary success signal.
- `Need Better Match` and request-ticket fallback.
- No account creation as core MVP scope.
- Age guidance and adult-oriented positioning.
- Minimal private-data collection.
- Session-level telemetry as a foundational MVP system for impressions, opens, `Use This`, failed-search paths, tickets, surveys, and sponsor activity.
- Narrow, trust-preserving push notifications.
- Restrained sponsor/ad presentation with clear labeling.
- Conservative license and trust filtering that excludes resources when licensing, source, provenance, or suitability is unclear.
- Optional only-if-cheap offline resilience such as lightweight caching or graceful fallback.

### Post-MVP Features

**Phase 2 (Growth After Proof):**

- Better recommendation quality and refinement logic.
- More mature ticket/reviewer operations.
- Actual multilingual support beyond readiness.
- Community contribution pathways.
- Better partner/referral behavior.
- Stronger sponsor attractiveness through credible user growth.

**Phase 3 (Expansion):**

- Wikibase interoperability.
- ORCID-linked trust or identity exploration.
- Wikimedia-account or other federated sign-in.
- Authelia-style identity infrastructure if later justified.
- AI-agent or LLM-assisted capabilities.
- Touchpoints-style deeper feedback integration.
- Exploratory blockchain-style educational-ledger concepts.

### Risk Mitigation Strategy

**Technical Risks:** Telemetry integrity, licensing correctness, and trust-signal clarity matter more than feature breadth.

**Market Risks:** Users may not get enough value fast enough, and sponsors may not see enough value to support the product.

**Resource Risks:** Charlie and volunteers have limited capacity, so MVP must remain narrow and triage-oriented rather than concierge-oriented.

## Functional Requirements

### Discovery & Search

- FR1: Learners can open the app without creating an account.
- FR2: Learners can view clear age and usage guidance before or during initial use.
- FR3: Learners can submit a free-text OER search query.
- FR4: Learners can view OER search results returned from repository or service-layer data.
- FR5: Learners can refine or retry a search when results do not meet their needs.
- FR6: The system can distinguish successful search paths from failed search paths.
- FR7: The system can exclude resources when licensing, source, provenance, or suitability is unclear.

### OER Records & Result Evaluation

- FR8: The system can maintain app-managed OER records containing metadata, source links, license, provenance, trust context, and source/review status.
- FR9: The system can represent app-managed OER records without hosting the full OER content in MVP.
- FR10: The system can classify OER records by source or review status, including repository-discovered records and manually reviewed approved records.
- FR11: Charlie or an authorized reviewer can mark an OER record as manually reviewed and approved.
- FR12: Charlie or an authorized reviewer can edit or deactivate an OER record if trust, license, provenance, or suitability concerns are found.
- FR13: Learners can view enough result information to decide whether an OER may meet their immediate need.
- FR14: Learners can open an OER detail view or OER record from a result.
- FR15: Learners can view source information for surfaced OER.
- FR16: Learners can view license information for surfaced OER.
- FR17: Learners can view provenance or trust context for surfaced OER.
- FR18: Learners can see understandable source/review status when it helps them evaluate trust.
- FR19: Learners can understand why a result is being recommended when explanation data is available.
- FR20: Learners can access the original external OER source from the app.

### Use Decision & Feedback

- FR21: Learners can select `Use This` on an OER they judge useful.
- FR22: The system can treat `Use This` as the primary successful-match event.
- FR23: Learners can rate or mark usefulness for an OER.
- FR24: Learners can indicate that they need a better match.
- FR25: Learners can complete a lightweight appreciation or usefulness survey.
- FR26: The system can record supporting signals such as source click-through, usefulness feedback, and survey completion.

### Ticket & Fallback Support

- FR27: Learners can submit a request ticket when they do not find an acceptable OER.
- FR28: Learners can include search or topic context in a request ticket.
- FR29: Learners can see clear expectation-setting that request fulfillment is not guaranteed concierge support.
- FR30: Learners can see that ticket response expectations may vary because follow-up depends on Charlie and volunteer capacity.
- FR31: Charlie can review submitted request tickets.
- FR32: Charlie can see enough ticket context to triage whether a better OER may be suggested, a metadata gap exists, or no good answer is currently available.
- FR33: Charlie can manually add or update an OER record after resolving a request ticket.
- FR34: Charlie can associate a manually added OER record with the original ticket or search context that surfaced it.
- FR35: Charlie can mark whether a ticket-resolved OER was verified as a useful result.
- FR36: The system can make a manually added and verified OER record available in future search results.
- FR37: The system can treat ticket submission as a retained-trust signal, not only a failure signal.

### Telemetry & Product Health

- FR38: The system can track result impressions.
- FR39: The system can track result opens.
- FR40: The system can track `Use This` actions.
- FR41: The system can track failed-search paths and ticket submissions.
- FR42: The system can track survey completion.
- FR43: The system can track sponsor or ad impressions and interactions.
- FR44: The system can track whether OER records, including manually reviewed records, later receive `Use This` actions.
- FR45: Charlie can review product-health signals related to downloads, searches, successful matches, tickets, surveys, and monetization.
- FR46: The system can support session-level telemetry without requiring user accounts.

### Sponsorship & Monetization

- FR47: Learners can distinguish sponsor or ad content from organic OER results.
- FR48: The system can support restrained sponsor or ad placement in the MVP.
- FR49: Charlie can evaluate whether sponsor or ad activity is contributing toward cost coverage or profit.
- FR50: The product can preserve search and OER evaluation as the primary user experience even when sponsorship is present.

### Mobile App Capabilities

- FR51: Learners can use the MVP as a native Android app.
- FR52: The app can retrieve OER discovery data through live API or repository access.
- FR53: The app can fail clearly when network conditions prevent effective search.
- FR54: The app can support limited offline resilience only where it does not distort MVP scope.
- FR55: The app can support narrow, trust-preserving push notifications.
- FR56: The app can operate without requiring unnecessary device permissions.

### Ecosystem & Future Readiness

- FR57: The system can preserve attribution fidelity for OER creators and partner ecosystems.
- FR58: The system can support future community contribution and editing pathways for metadata improvement, review, advocacy, or volunteer support.
- FR59: The product can remain localization-ready for future multilingual support.
- FR60: The system can preserve architectural room for future structured metadata interoperability such as Wikibase.
- FR61: The system can preserve future room for optional identity or trust integrations such as ORCID, Wikimedia-account sign-in, or Authelia.
- FR62: The system can preserve future room for AI-agent, LLM-assisted, Touchpoints-style, or blockchain-ledger explorations without making them MVP requirements.

## Non-Functional Requirements

### Performance

- NFR1: The app should support a search-to-results experience fast enough that users can evaluate a first useful OER candidate without losing task momentum.
- NFR2: Search submission to first result should target under 3 seconds on typical WiFi; detail view loading should target under 2 seconds; `Use This` recording should target under 1 second; and degraded or offline state communication should appear within 5 seconds of detected network loss. These targets are provisional and should be reviewed before MVP release.
- NFR3: The app should preserve readable, responsive interaction on common supported Android devices.
- NFR4: Network delay or service degradation should be communicated clearly to users instead of creating ambiguous empty states.

### Reliability

- NFR5: The app should install, open, and complete the core search-to-result flow reliably on supported Android versions and devices.
- NFR6: The system should preserve submitted feedback, ticket, and telemetry events against ordinary retry or intermittent-network conditions.
- NFR7: Repository/API failures should degrade gracefully without surfacing unclear or untrusted OER results as substitutes.

### Security & Privacy

- NFR8: The MVP should minimize private-data collection and avoid requiring account creation unless explicitly retained as product scope.
- NFR9: Any user, ticket, feedback, telemetry, or session data should be protected in transit and at rest.
- NFR10: Access to reviewer/admin functions should be restricted to authorized users.
- NFR11: The product should avoid unnecessary Android device permissions.

### Accessibility

- NFR12: Core flows should target WCAG 2.1 AA-aligned accessibility before MVP release, including Android TalkBack support for search, results, and detail views.
- NFR13: Search, result review, detail inspection, `Use This`, feedback, ticket submission, and survey completion should support minimum 48dp touch targets, text scaling up to 200% without layout breakage, and usable interaction for visual, motor, and screen-reader needs.
- NFR14: Trust, license, source, sponsorship, and age-guidance information should be perceivable and understandable without relying only on color or visual placement, and should meet appropriate contrast targets.

### Integration & Data Quality

- NFR15: OER source, license, provenance, and review-status data should be stored and transmitted with enough fidelity to support trust decisions.
- NFR16: The system should exclude or clearly suppress records with ambiguous licensing, unclear provenance, or insufficient trust context.
- NFR17: External repository/API integrations should be monitored for freshness, schema drift, and failed imports.
- NFR18: API and telemetry contracts should be versioned to prevent silent breakage between mobile, backend, ingestion, and analytics components.

### Compliance & Trust

- NFR19: Sponsorship or ad content should remain clearly distinguishable from organic OER results.
- NFR20: Age and usage guidance should remain consistent with adult-oriented MVP positioning, and users under 18 should be encouraged to ask permission or guidance from a parent, guardian, or teacher before relying on the app.
- NFR21: License and attribution presentation should support conservative commercially safe OER use.
- NFR22: Product and external communication language should avoid overstating ticket fulfillment, recommendation certainty, future capabilities, or the maturity of unproven features.

### Scalability

- NFR23: The architecture should support growth in users, searches, OER records, tickets, and telemetry events without requiring a full product redesign.
- NFR24: The system should preserve future multilingual expansion without making it an MVP dependency, including string resource usage, language metadata fields, query handling that does not assume English-only input, and early avoidance of UI decisions that would block RTL support.

### Observability

- NFR25: The MVP should provide enough operational and product telemetry to distinguish successful searches, failed searches, `Use This` events, ticket submissions, survey completions, and sponsor interactions.
- NFR26: Charlie should be able to evaluate whether app usage, search outcomes, ticket demand, and monetization signals justify continued iteration.
- NFR27: Telemetry should be reliable enough to support MVP success evaluation without requiring persistent user profiles unless account scope is explicitly retained.

