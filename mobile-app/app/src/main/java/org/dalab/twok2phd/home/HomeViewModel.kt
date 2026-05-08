package org.dalab.twok2phd.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.dalab.twok2phd.analytics.TelemetryEvent
import org.dalab.twok2phd.analytics.TelemetryRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val telemetryRepository: TelemetryRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(
        HomeUiState(
            pulseItems = listOf(
                PulseItem("hot-1", "Hot", "Top this week: Intro to Fractions", "Used by 127 educators"),
                PulseItem("fresh-1", "Fresh", "New: Creative Writing Prompt Pack", "Added 3 hours ago"),
                PulseItem("activity-1", "Activity", "Your OER was used", "12 learners opened it yesterday")
            )
        )
    )
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        telemetryRepository.record(TelemetryEvent.HomeViewed())
    }

    fun onSearchFocused() {
        telemetryRepository.record(TelemetryEvent.SearchFocused())
    }

    fun onSearchQueryChanged(query: String) {
        _uiState.update { currentState -> currentState.copy(searchQuery = query) }
    }

    fun onQuickFilterSelected(filter: String) {
        _uiState.update { currentState ->
            val updated = if (currentState.searchQuery.isBlank()) {
                filter
            } else {
                "${currentState.searchQuery} $filter"
            }
            currentState.copy(searchQuery = updated)
        }
    }

    fun onSearchSubmitted(): String? {
        val trimmedQuery = _uiState.value.searchQuery.trim()
        if (trimmedQuery.isBlank()) return null

        telemetryRepository.record(TelemetryEvent.SearchSubmitted(trimmedQuery))
        return trimmedQuery
    }
}
