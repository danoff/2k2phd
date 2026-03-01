# GitHub Issues Seed

## 1. Build 3-tap onboarding + telemetry
- Labels: `mobile`, `p0`
- Acceptance:
  - User can pick intent/time/mode in <= 3 taps
  - Events emitted: onboarding_started/completed, intent_selected, time_selected, mode_selected

## 2. Implement scoring engine v1
- Labels: `api`, `p0`
- Acceptance:
  - Score based on intent/time/mode
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
  - One-tap feedback on each card
  - API persists feedback event with session context

## 6. Ticket-first fallback endpoint
- Labels: `api`, `p0`
- Acceptance:
  - Prefilled ticket includes intent/time/mode + last recommendation ids
  - Returns queue id and status

## 7. Persistent "Need better match?" control
- Labels: `mobile`, `p0`
- Acceptance:
  - Button available on recommendation flow
  - Escalates to prefilled ticket after defined triggers

## 8. Trust panel v1
- Labels: `mobile`, `api`, `p1`
- Acceptance:
  - Displays source, license, contributor signal, reference count

## 9. Offline/cache resilience
- Labels: `mobile`, `api`, `p1`, `reliability`
- Acceptance:
  - Handles API timeouts gracefully
  - Shows cached fallback cards when available

## 10. Accessibility validation on top flows
- Labels: `mobile`, `p0`, `a11y`
- Acceptance:
  - Screen reader support verified for onboarding, recommendation, feedback, ticket submit
