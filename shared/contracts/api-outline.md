# API Contract Outline

## POST /v1/recommendations
Request:
- session_id
- intent
- time_bucket
- mode
- optional: language, accessibility, connectivity, level

Response:
- recommendations[]
  - resource_id
  - title
  - score
  - rationale[]
  - remix_eligible

## POST /v1/feedback
Request:
- session_id
- resource_id
- signal (`helpful` | `not_helpful`)
- context

## POST /v1/tickets
Request:
- session_id
- intent
- time_bucket
- mode
- deadline
- level
- trigger_reason
- last_recommendation_ids[]

Response:
- ticket_id
- status
- eta_hint
