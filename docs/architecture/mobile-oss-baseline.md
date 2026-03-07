# Mobile OSS Baseline (Frozen v0.1)

## Objective
Maintain an open-source-first Android stack for 2k2phd with scalable architecture and minimal vendor lock-in.

## Core Stack
- Kotlin + Jetpack Compose (Material 3)
- MVVM + UDF state model (StateFlow)
- Navigation Compose
- Hilt dependency injection
- Room (local persistence)
- DataStore (preferences)
- WorkManager (background jobs)
- Retrofit + OkHttp + kotlinx.serialization

## Open Source Policy
- Prefer Apache/MIT/BSD licensed libraries.
- Avoid closed SDK dependencies in MVP.
- Keep analytics event model backend-agnostic.
- Keep data model and API contracts in repo under `shared/`.

## Initial Module Layout
- `mobile-app/app`: Android application module
- `shared/contracts`: API and event contracts
- `shared/schemas`: shared data schema docs

## Planned Next Technical Steps
1. Add domain/data/ui package boundaries in app module.
2. Add repository layer and fake datasource for local-first testing.
3. Implement OER detail screen and action handling.
4. Add first telemetry pipeline contract and local queue.
5. Add CI checks for lint, test, and static analysis.
