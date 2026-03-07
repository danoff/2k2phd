package org.dalab.twok2phd.home

data class PulseItem(
    val id: String,
    val kind: String,
    val title: String,
    val subtitle: String
)

data class HomeUiState(
    val searchQuery: String = "",
    val quickFilters: List<String> = listOf("Lesson Plan", "Video", "Worksheet", "Assessment", "Remixable"),
    val pulseItems: List<PulseItem> = emptyList()
)
