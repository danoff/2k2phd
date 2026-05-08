package org.dalab.twok2phd.results

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.dalab.twok2phd.analytics.TelemetryEvent
import org.dalab.twok2phd.analytics.TelemetryRepository
import org.dalab.twok2phd.domain.OerRepository
import org.dalab.twok2phd.navigation.AppRoute
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val oerRepository: OerRepository,
    private val telemetry: TelemetryRepository,
) : ViewModel() {

    private val query: String = checkNotNull(savedStateHandle[AppRoute.Results.ARG_QUERY])

    private val _uiState = MutableStateFlow(ResultsUiState(query = query))
    val uiState: StateFlow<ResultsUiState> = _uiState.asStateFlow()

    init {
        loadRecommendations()
    }

    fun onResultOpened(resourceId: String) {
        telemetry.record(TelemetryEvent.ResultOpened(resourceId))
    }

    private fun loadRecommendations() {
        viewModelScope.launch {
            val results = oerRepository.getRecommendations(query)
            _uiState.value = _uiState.value.copy(results = results, isLoading = false)
            if (results.isEmpty()) {
                telemetry.record(TelemetryEvent.SearchFailed(query))
            } else {
                results.forEachIndexed { index, record ->
                    telemetry.record(
                        TelemetryEvent.ResultImpression(resourceId = record.resourceId, position = index)
                    )
                }
            }
        }
    }
}
