package org.dalab.twok2phd.domain

interface OerRepository {
    suspend fun getRecommendations(query: String): List<OerRecord>
}
