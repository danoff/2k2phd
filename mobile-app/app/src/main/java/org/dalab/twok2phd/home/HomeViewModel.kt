package org.dalab.twok2phd.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.dalab.twok2phd.analytics.TelemetryEvent
import org.dalab.twok2phd.analytics.TelemetryRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val telemetry: TelemetryRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        HomeUiState(
            pulseItems = listOf(
                PulseItem("hot-1", "Hot", "Top this week: Intro to Fractions", "Used by 127 educators"),
                PulseItem("fresh-1", "Fresh", "New: Creative Writing Prompt Pack", "Added 3 hours ago"),
                PulseItem("activity-1", "Activity", "Your OER was used", "12 learners opened it yesterday"),
            )
        )
    )
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        telemetry.record(TelemetryEvent.HomeViewed)
    }

    fun onSearchQueryChanged(query: String) {
        val wasBlank = _uiState.value.searchQuery.isBlank()
        _uiState.value = _uiState.value.copy(searchQuery = query)
        if (wasBlank && query.isNotBlank()) {
            telemetry.record(TelemetryEvent.SearchFocused)
        }
    }

    fun onSearchSubmitted() {
        val query = _uiState.value.searchQuery.trim()
        if (query.isNotBlank()) {
            telemetry.record(TelemetryEvent.SearchSubmitted(query))
        }
    }

    fun onQuickFilterSelected(filter: String) {
        val updated = if (_uiState.value.searchQuery.isBlank()) filter
                      else "${_uiState.value.searchQuery} $filter"
        _uiState.value = _uiState.value.copy(searchQuery = updated)
    }
}
