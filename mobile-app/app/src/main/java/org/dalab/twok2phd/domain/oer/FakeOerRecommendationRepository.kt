package org.dalab.twok2phd.domain.oer

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeOerRecommendationRepository @Inject constructor() : OerRecommendationRepository {
    override fun getRecommendations(query: String): List<OerRecommendation> {
        val normalizedQuery = query.trim().ifBlank { "Open learning" }
        return listOf(
            OerRecommendation(
                resourceId = "intro-guide-${normalizedQuery.slug()}",
                title = "$normalizedQuery: open intro guide",
                resourceType = "Guide",
                estimatedEffort = "20 min",
                scorePercent = 94,
                rationale = listOf(
                    "Strong title match for your search",
                    "Beginner-friendly structure",
                    "License is remix-safe for classroom adaptation"
                ),
                source = "Open Textbook Library placeholder",
                license = "CC BY 4.0",
                provenance = "Curated seed data until matching API is available",
                trustStatus = "Reviewed placeholder",
                remixEligible = true
            ),
            OerRecommendation(
                resourceId = "worksheet-${normalizedQuery.slug()}",
                title = "$normalizedQuery: worksheet collection",
                resourceType = "Worksheet",
                estimatedEffort = "15 min",
                scorePercent = 88,
                rationale = listOf(
                    "Practice-focused resource type",
                    "Short estimated effort",
                    "Source and license fields are visible"
                ),
                source = "OER Commons placeholder",
                license = "CC BY-SA 4.0",
                provenance = "Seeded local recommendation for MVP UI validation",
                trustStatus = "Source visible",
                remixEligible = true
            ),
            OerRecommendation(
                resourceId = "video-${normalizedQuery.slug()}",
                title = "$normalizedQuery: open lesson video",
                resourceType = "Video",
                estimatedEffort = "12 min",
                scorePercent = 81,
                rationale = listOf(
                    "Fast first-learning option",
                    "Useful when a learner wants a quick overview",
                    "Needs final metadata verification before production ranking"
                ),
                source = "Public media placeholder",
                license = "CC0",
                provenance = "Local fake repository; replace with /v1/recommendations",
                trustStatus = "Metadata placeholder",
                remixEligible = true
            )
        )
    }
}

private fun String.slug(): String =
    lowercase()
        .replace(Regex("[^a-z0-9]+"), "-")
        .trim('-')
        .ifBlank { "open-learning" }
