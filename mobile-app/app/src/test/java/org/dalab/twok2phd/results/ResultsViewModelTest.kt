package org.dalab.twok2phd.results

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.dalab.twok2phd.analytics.TelemetryEvent
import org.dalab.twok2phd.analytics.TelemetryRepository
import org.dalab.twok2phd.domain.oer.OerRecommendation
import org.dalab.twok2phd.domain.oer.OerRecommendationRepository
import org.dalab.twok2phd.navigation.AppRoute
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ResultsViewModelTest {
    @Test
    fun init_recordsResultsViewedAndImpressions() {
        val telemetryRepository = RecordingTelemetryRepository()
        val viewModel = ResultsViewModel(
            savedStateHandle = SavedStateHandle(mapOf(AppRoute.Results.ARG_QUERY to "biology")),
            recommendationRepository = StaticOerRecommendationRepository(listOf(sampleRecommendation("one"), sampleRecommendation("two"))),
            telemetryRepository = telemetryRepository
        )

        assertEquals(2, viewModel.uiState.value.recommendations.size)
        assertEquals(
            listOf("results_viewed", "result_impression", "result_impression"),
            telemetryRepository.eventNames()
        )
    }

    @Test
    fun init_recordsSearchFailedWhenNoResultsReturn() {
        val telemetryRepository = RecordingTelemetryRepository()

        ResultsViewModel(
            savedStateHandle = SavedStateHandle(mapOf(AppRoute.Results.ARG_QUERY to "zzzz")),
            recommendationRepository = StaticOerRecommendationRepository(emptyList()),
            telemetryRepository = telemetryRepository
        )

        assertEquals(listOf("results_viewed", "search_failed"), telemetryRepository.eventNames())
    }

    @Test
    fun actions_recordOutcomeTelemetry() {
        val telemetryRepository = RecordingTelemetryRepository()
        val viewModel = ResultsViewModel(
            savedStateHandle = SavedStateHandle(mapOf(AppRoute.Results.ARG_QUERY to "history")),
            recommendationRepository = StaticOerRecommendationRepository(listOf(sampleRecommendation("one"))),
            telemetryRepository = telemetryRepository
        )

        viewModel.onRecommendationOpened("one")
        viewModel.onUseThis("one")
        viewModel.onRate("one", helpful = true)
        viewModel.onNeedBetterMatch()

        assertTrue("oer_opened" in telemetryRepository.eventNames())
        assertTrue("use_this_marked" in telemetryRepository.eventNames())
        assertTrue("oer_rated" in telemetryRepository.eventNames())
        assertTrue("need_better_match_clicked" in telemetryRepository.eventNames())
    }
}

private class StaticOerRecommendationRepository(
    private val recommendations: List<OerRecommendation>
) : OerRecommendationRepository {
    override fun getRecommendations(query: String): List<OerRecommendation> = recommendations
}

private class RecordingTelemetryRepository : TelemetryRepository {
    private val _events = MutableStateFlow<List<TelemetryEvent>>(emptyList())
    override val events: StateFlow<List<TelemetryEvent>> = _events

    override fun record(event: TelemetryEvent) {
        _events.value = _events.value + event
    }

    fun eventNames(): List<String> = events.value.map { it.name }
}

private fun sampleRecommendation(id: String): OerRecommendation =
    OerRecommendation(
        resourceId = id,
        title = "Sample $id",
        resourceType = "Guide",
        estimatedEffort = "10 min",
        scorePercent = 90,
        rationale = listOf("Reason"),
        source = "Source",
        license = "CC BY 4.0",
        provenance = "Test",
        trustStatus = "Reviewed",
        remixEligible = true
    )
