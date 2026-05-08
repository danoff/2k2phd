package org.dalab.twok2phd.results

data class ResultItem(
    val id: String,
    val title: String,
)

data class ResultsUiState(
    val query: String = "",
    val results: List<ResultItem> = emptyList(),
)
