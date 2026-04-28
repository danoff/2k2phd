# GitHub Issues Seed

## 1. Build search-first home flow + telemetry
- Labels: `mobile`, `p0`
- Acceptance:
  - User can open app and reach search-first home without mandatory sign-in
  - Events emitted: home_viewed, search_focused, search_submitted

## 2. Implement scoring engine v1
- Labels: `api`, `p0`
- Acceptance:
  - Score based on search query and trust-eligible metadata
  - Returns top-N with score explanation fields

## 3. Add remix license hard filter
- Labels: `api`, `p0`, `compliance`
- Acceptance:
  - Remix mode excludes ineligible licenses
  - Unit tests cover allow/deny matrix

## 4. Recommendation card UI with "Why this now"
- Labels: `mobile`, `p0`
- Acceptance:
  - Card shows title, type, estimated effort, top-3 rationale factors

## 5. Add Helpful / Not helpful feedback capture
- Labels: `mobile`, `api`, `p0`
- Acceptance:
  - `Use This`, helpful, and not-helpful actions are available on result detail flow
  - API persists feedback event with session context

## 6. Ticket-first fallback endpoint
- Labels: `api`, `p0`
- Acceptance:
  - Prefilled ticket includes search query + last recommendation ids + trigger reason
  - Returns queue id and status

## 7. Persistent "Need better match?" control
- Labels: `mobile`, `p0`
- Acceptance:
  - Button available on recommendation flow
  - Escalates to prefilled ticket after defined triggers

## 8. Trust panel v1
- Labels: `mobile`, `api`, `p1`
- Acceptance:
  - Displays source, license, provenance, and contributor signal/reference count when available

## 9. Offline/cache resilience
- Labels: `mobile`, `api`, `p1`, `reliability`
- Acceptance:
  - Handles API timeouts gracefully
  - Shows cached fallback cards when available

## 10. Accessibility validation on top flows
- Labels: `mobile`, `p0`, `a11y`
- Acceptance:
  - Screen reader support verified for search, recommendation, feedback, ticket submit
