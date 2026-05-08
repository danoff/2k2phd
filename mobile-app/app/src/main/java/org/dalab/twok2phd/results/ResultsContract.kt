package org.dalab.twok2phd.results

data class ResultsUiState(
    val query: String = "",
    val recommendations: List<RecommendationCardUiState> = emptyList(),
    val statusMessage: String? = null
)

data class RecommendationCardUiState(
    val resourceId: String,
    val title: String,
    val resourceType: String,
    val estimatedEffort: String,
    val scorePercent: Int,
    val rationale: List<String>,
    val source: String,
    val license: String,
    val provenance: String,
    val trustStatus: String,
    val remixEligible: Boolean
)
