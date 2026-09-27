package org.dalab.twok2phd.domain.oer

data class OerRecommendation(
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
