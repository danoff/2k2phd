package org.dalab.twok2phd.results

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.dalab.twok2phd.analytics.TelemetryEvent
import org.dalab.twok2phd.analytics.TelemetryRepository
import org.dalab.twok2phd.navigation.AppRoute
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val telemetry: TelemetryRepository,
) : ViewModel() {

    private val query: String = checkNotNull(savedStateHandle[AppRoute.Results.ARG_QUERY])

    private val _uiState = MutableStateFlow(buildInitialState(query))
    val uiState: StateFlow<ResultsUiState> = _uiState.asStateFlow()

    init {
        _uiState.value.results.forEachIndexed { index, item ->
            telemetry.record(TelemetryEvent.ResultImpression(resourceId = item.id, position = index))
        }
    }

    fun onResultOpened(resourceId: String) {
        telemetry.record(TelemetryEvent.ResultOpened(resourceId))
    }

    private fun buildInitialState(query: String): ResultsUiState {
        // Seeded until the real scoring API is wired
        val seeded = listOf(
            ResultItem("$query-intro", "$query: Intro guide"),
            ResultItem("$query-worksheet", "$query: Worksheet collection"),
            ResultItem("$query-video", "$query: Open lesson video"),
            ResultItem("$query-remix", "$query: Remixable activity set"),
        )
        return ResultsUiState(query = query, results = seeded)
    }
}
