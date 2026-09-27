package org.dalab.twok2phd.domain

data class OerRecord(
    val resourceId: String,
    val title: String,
    val resourceType: String,
    val estimatedEffort: String,
    val score: Float,
    val rationale: List<String>,
    val remixEligible: Boolean,
    val source: String,
    val license: String,
    val provenance: String,
    val trustStatus: TrustStatus,
)

enum class TrustStatus { VERIFIED, COMMUNITY, UNREVIEWED }
