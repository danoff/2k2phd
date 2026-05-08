package org.dalab.twok2phd.results

import org.dalab.twok2phd.domain.OerRecord

data class ResultsUiState(
    val query: String = "",
    val results: List<OerRecord> = emptyList(),
    val isLoading: Boolean = true,
)
