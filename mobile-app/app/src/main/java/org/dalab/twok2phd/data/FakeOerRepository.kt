package org.dalab.twok2phd.data

import kotlinx.coroutines.delay
import org.dalab.twok2phd.domain.OerRecord
import org.dalab.twok2phd.domain.OerRepository
import org.dalab.twok2phd.domain.TrustStatus
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeOerRepository @Inject constructor() : OerRepository {

    // Simulates network latency so loading states are visible during development
    override suspend fun getRecommendations(query: String): List<OerRecord> {
        delay(600)
        return CATALOG.filter { record ->
            val q = query.lowercase()
            record.title.lowercase().contains(q) ||
                record.resourceType.lowercase().contains(q) ||
                record.rationale.any { it.lowercase().contains(q) }
        }.ifEmpty { CATALOG }.take(4)
    }

    companion object {
        private val CATALOG = listOf(
            OerRecord(
                resourceId = "oer-001",
                title = "Introduction to Algebra: Variables and Expressions",
                resourceType = "Lesson Plan",
                estimatedEffort = "~45 min",
                score = 0.94f,
                rationale = listOf(
                    "Strong match for algebra fundamentals",
                    "CC BY 4.0 — free to use and adapt",
                    "Peer-reviewed by 3 educators in 2023",
                ),
                remixEligible = true,
                source = "OER Commons",
                license = "CC BY 4.0",
                provenance = "Peer reviewed, 2023",
                trustStatus = TrustStatus.VERIFIED,
            ),
            OerRecord(
                resourceId = "oer-002",
                title = "Fractions and Decimals: A Visual Approach",
                resourceType = "Worksheet",
                estimatedEffort = "~30 min",
                score = 0.88f,
                rationale = listOf(
                    "Highly rated by adult learners",
                    "MIT License — no restrictions",
                    "Used by 340+ educators this month",
                ),
                remixEligible = true,
                source = "Khan Academy OER",
                license = "CC BY-SA 4.0",
                provenance = "Community reviewed, 2024",
                trustStatus = TrustStatus.COMMUNITY,
            ),
            OerRecord(
                resourceId = "oer-003",
                title = "Creative Writing Prompt Pack: Character Development",
                resourceType = "Activity Set",
                estimatedEffort = "1–2 hrs",
                score = 0.85f,
                rationale = listOf(
                    "Matches creative writing search context",
                    "Remixable — build your own variant",
                    "Fresh addition — added this week",
                ),
                remixEligible = true,
                source = "OpenStax",
                license = "CC BY 4.0",
                provenance = "Publisher verified, 2024",
                trustStatus = TrustStatus.VERIFIED,
            ),
            OerRecord(
                resourceId = "oer-004",
                title = "Introduction to Python Programming",
                resourceType = "Video Series",
                estimatedEffort = "3–4 hrs",
                score = 0.81f,
                rationale = listOf(
                    "Top result for programming topics",
                    "Apache 2.0 — commercially safe",
                    "Transcript and captions included",
                ),
                remixEligible = false,
                source = "MIT OpenCourseWare",
                license = "CC BY-NC-SA 4.0",
                provenance = "Institution verified, 2022",
                trustStatus = TrustStatus.VERIFIED,
            ),
            OerRecord(
                resourceId = "oer-005",
                title = "Human Biology: Cell Structure and Function",
                resourceType = "Textbook Chapter",
                estimatedEffort = "~1 hr",
                score = 0.78f,
                rationale = listOf(
                    "Peer-reviewed academic source",
                    "Accessible language for self-study",
                    "CC BY — free to download and share",
                ),
                remixEligible = true,
                source = "OpenStax",
                license = "CC BY 4.0",
                provenance = "Peer reviewed, 2023",
                trustStatus = TrustStatus.VERIFIED,
            ),
        )
    }
}
