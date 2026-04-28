# API Contract Outline

## POST /v1/recommendations
Request:
- session_id
- query
- optional: language, accessibility, connectivity, level, context_tags[]

Response:
- recommendations[]
  - resource_id
  - title
  - score
  - rationale[]
  - remix_eligible
  - source
  - license
  - provenance
  - trust_status

## POST /v1/feedback
Request:
- session_id
- resource_id
- signal (`helpful` | `not_helpful`)
- context

## POST /v1/tickets
Request:
- session_id
- query
- optional: learner_note
- trigger_reason
- last_recommendation_ids[]

Response:
- ticket_id
- status
- eta_hint
