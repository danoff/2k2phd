package org.dalab.twok2phd.results

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.dalab.twok2phd.analytics.TelemetryEvent
import org.dalab.twok2phd.analytics.TelemetryRepository
import org.dalab.twok2phd.domain.oer.OerRecommendation
import org.dalab.twok2phd.domain.oer.OerRecommendationRepository
import org.dalab.twok2phd.navigation.AppRoute
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val recommendationRepository: OerRecommendationRepository,
    private val telemetryRepository: TelemetryRepository
) : ViewModel() {
    private val query: String = savedStateHandle.get<String>(AppRoute.Results.ARG_QUERY).orEmpty()
    private val _uiState = MutableStateFlow(ResultsUiState(query = query))

    val uiState: StateFlow<ResultsUiState> = _uiState.asStateFlow()

    init {
        loadRecommendations()
    }

    fun onRecommendationOpened(resourceId: String) {
        telemetryRepository.record(TelemetryEvent.OerOpened(resourceId))
        _uiState.update { currentState ->
            currentState.copy(statusMessage = "Opened trust details for ${resourceId.shortId()}")
        }
    }

    fun onUseThis(resourceId: String) {
        telemetryRepository.record(TelemetryEvent.UseThisMarked(resourceId))
        _uiState.update { currentState ->
            currentState.copy(statusMessage = "Marked this OER as useful for learning")
        }
    }

    fun onRate(resourceId: String, helpful: Boolean) {
        telemetryRepository.record(TelemetryEvent.OerRated(resourceId = resourceId, helpful = helpful))
        _uiState.update { currentState ->
            val label = if (helpful) "Helpful" else "Not helpful"
            currentState.copy(statusMessage = "$label feedback captured")
        }
    }

    fun onNeedBetterMatch() {
        val visibleIds = _uiState.value.recommendations.map { it.resourceId }
        telemetryRepository.record(
            TelemetryEvent.NeedBetterMatchClicked(
                query = query,
                lastRecommendationIds = visibleIds
            )
        )
        _uiState.update { currentState ->
            currentState.copy(statusMessage = "Better-match request started with current search context")
        }
    }

    private fun loadRecommendations() {
        val recommendations = recommendationRepository.getRecommendations(query).map { it.toUiState() }
        telemetryRepository.record(
            TelemetryEvent.ResultsViewed(
                query = query,
                resultCount = recommendations.size
            )
        )

        if (recommendations.isEmpty()) {
            telemetryRepository.record(TelemetryEvent.SearchFailed(query))
        } else {
            recommendations.forEachIndexed { index, recommendation ->
                telemetryRepository.record(
                    TelemetryEvent.ResultImpression(
                        resourceId = recommendation.resourceId,
                        position = index + 1
                    )
                )
            }
        }

        _uiState.update { currentState ->
            currentState.copy(recommendations = recommendations)
        }
    }
}

private fun OerRecommendation.toUiState(): RecommendationCardUiState =
    RecommendationCardUiState(
        resourceId = resourceId,
        title = title,
        resourceType = resourceType,
        estimatedEffort = estimatedEffort,
        scorePercent = scorePercent,
        rationale = rationale,
        source = source,
        license = license,
        provenance = provenance,
        trustStatus = trustStatus,
        remixEligible = remixEligible
    )

private fun String.shortId(): String = take(16)
