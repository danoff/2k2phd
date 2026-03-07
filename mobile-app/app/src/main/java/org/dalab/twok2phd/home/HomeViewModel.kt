package org.dalab.twok2phd.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
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

    fun onSearchQueryChanged(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
    }

    fun onQuickFilterSelected(filter: String) {
        val updated = if (_uiState.value.searchQuery.isBlank()) filter else "${_uiState.value.searchQuery} $filter"
        _uiState.value = _uiState.value.copy(searchQuery = updated)
    }
}
