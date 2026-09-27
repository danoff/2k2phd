package org.dalab.twok2phd.domain.oer

interface OerRecommendationRepository {
    fun getRecommendations(query: String): List<OerRecommendation>
}
