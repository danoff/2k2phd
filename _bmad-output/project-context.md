---
project_name: 2k2phd
date: 2026-05-07
generated_by: bmad-generate-project-context
---

# Project Context for AI Agents

## Technology Stack & Versions

**Android client (`mobile-app/`)**
- Kotlin (JVM target 17), compileSdk 35, minSdk 26
- Jetpack Compose BOM 2024.06.00, Material 3
- Navigation Compose 2.7.7
- Hilt 2.51.1 (DI) + KSP
- Room 2.6.1 (local persistence) + KSP
- DataStore Preferences 1.1.1
- WorkManager 2.9.0
- Retrofit 2.11.0 + OkHttp 4.12.0 + kotlinx-serialization-json 1.6.3
- Lifecycle ViewModel/Runtime Compose 2.8.4
- Testing: JUnit4, Espresso, Compose UI Test

**Backend (planned, not yet in repo)**
- `oer-matching-api` — scoring engine + recommendation endpoint
- `oer-ingestion-worker` — OER metadata ingestion

**Shared (`shared/`)**
- `shared/contracts/` — API request/response contracts (markdown)
- `shared/schemas/` — data schema docs

## Package Structure

```
org.dalab.twok2phd/
├── MainActivity.kt          # Single activity, sets AppNavHost inside TwoKTwoPhdTheme
├── navigation/
│   ├── AppNavHost.kt        # All composable() routes in one place
│   └── AppRoute.kt          # Sealed class with typed route + arg helpers
├── home/
│   ├── HomeScreen.kt        # @Composable, takes callbacks — no NavController
│   ├── HomeViewModel.kt     # ViewModel with StateFlow<HomeUiState>
│   └── HomeContract.kt      # UiState data class + supporting data classes
├── results/
│   └── ResultsScreen.kt     # Currently static/seeded — replace with real ViewModel
└── theme/
    ├── Color.kt, Theme.kt, Type.kt
```

## Critical Implementation Rules

**Feature package pattern — follow exactly:**
- Every feature lives in its own package: `org.dalab.twok2phd.{feature}/`
- Each feature has three files: `{Feature}Screen.kt`, `{Feature}ViewModel.kt`, `{Feature}Contract.kt`
- `Contract.kt` holds `{Feature}UiState` (single data class) and any supporting model types for that screen
- ViewModels expose a single `val uiState: StateFlow<{Feature}UiState>`, backed by a private `MutableStateFlow`
- State updates always use `.copy()` — never reassign individual fields directly
- Screens are `@Composable` functions that accept typed callbacks (e.g. `onSearchSubmitted: (String) -> Unit`) — **never** pass `NavController` into a screen

**Navigation:**
- All routes are registered in `AppNavHost.kt` only — do not add `composable()` blocks anywhere else
- New routes must be added to `AppRoute` as `data object` entries with typed `create()` helpers for routes with arguments
- Pass string arguments via URL path segments as shown in `AppRoute.Results`

**Dependency Injection:**
- Hilt is installed — all new ViewModels must use `@HiltViewModel` + `@Inject constructor()`
- Screens must obtain Hilt ViewModels via `hiltViewModel()`, not `viewModel()` — the existing `HomeViewModel` is pre-Hilt and should be migrated when touched
- Repository and data-source classes must be `@Singleton` bound via `@Provides` in a Hilt module

**Repository layer (required for all new features):**
- No ViewModel should call Retrofit, Room, or DataStore directly
- Add a `data/` sub-package per feature or a top-level `data/` package for shared repositories
- Fake/in-memory implementations must be provided for local testing (no network required for unit tests)

**Serialization:**
- Use `kotlinx.serialization` (`@Serializable`) for all network DTOs — not Gson or Moshi
- Retrofit is wired with `retrofit2-kotlinx-serialization-converter`

**Coroutines / Flow:**
- `viewModelScope` for all coroutine launches inside ViewModels
- Collect StateFlow in Compose with `collectAsStateWithLifecycle()` — never `collectAsState()`
- `suspend` functions in repositories, not in ViewModels directly

**Room:**
- Entity class names use `Entity` suffix: e.g. `OerRecordEntity`
- DAO interfaces use `Dao` suffix
- Database class is a singleton provided via Hilt

**Testing:**
- Unit tests go in `app/src/test/` — pure JVM, no Android framework
- Instrumentation tests go in `app/src/androidTest/`
- Fake data sources (not mocks) preferred for repository testing

## Domain Vocabulary

- **OER** — Open Educational Resource
- **Remix-eligible** — resource whose license permits modification and redistribution (e.g. CC BY, CC BY-SA); excludes ND licenses and, for a for-profit monetized app, NC licenses unless legal review approves
- **Trust status** — combination of source, license, provenance, and review state surfaced to the user
- **Use This** — the primary success action; the explicit signal that a learner found a useful match
- **Need Better Match** — fallback action that escalates to a ticket workflow
- **Pulse** — home-screen section showing Hot / Fresh / Activity OER signals

## API Contract (from `shared/contracts/api-outline.md`)

**POST /v1/recommendations** — returns `recommendations[]` with `resource_id`, `title`, `score`, `rationale[]`, `remix_eligible`, `source`, `license`, `provenance`, `trust_status`

**POST /v1/feedback** — records `helpful` / `not_helpful` signal for a resource

**POST /v1/tickets** — creates a support ticket with search context and `last_recommendation_ids[]`

## License Filter Policy

Conservative MVP rule — surface only resources whose license is unambiguously acceptable:
- **Allow:** CC BY, CC BY-SA, CC0, Apache 2.0, MIT, BSD
- **Block:** CC BY-NC-*, CC BY-ND-*, CC BY-NC-ND-*, All Rights Reserved, unknown/missing license
- NC licenses require explicit legal-review approval before inclusion in a for-profit monetized app
- The filter must be applied server-side (scoring engine) and the `remix_eligible` field in the API response drives any remix-mode client-side UI

## What Is Not Yet Built

- Repository layer (all features use static/seeded data)
- Hilt injection in existing ViewModels (HomeViewModel uses plain `viewModel()`)
- API integration (ResultsScreen is fully seeded)
- Room entities and DAOs
- Telemetry pipeline
- OER detail screen
- Feedback / Use This actions
- Ticket workflow
- License filter logic
