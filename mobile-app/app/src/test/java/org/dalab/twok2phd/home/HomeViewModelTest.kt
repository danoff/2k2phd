package org.dalab.twok2phd.home

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.dalab.twok2phd.analytics.TelemetryEvent
import org.dalab.twok2phd.analytics.TelemetryRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class HomeViewModelTest {
    @Test
    fun init_recordsHomeViewed() {
        val telemetryRepository = RecordingTelemetryRepository()

        HomeViewModel(telemetryRepository)

        assertEquals(listOf("home_viewed"), telemetryRepository.eventNames())
    }

    @Test
    fun searchFocusAndSubmit_recordExpectedEvents() {
        val telemetryRepository = RecordingTelemetryRepository()
        val viewModel = HomeViewModel(telemetryRepository)

        viewModel.onSearchFocused()
        viewModel.onSearchQueryChanged("  algebra  ")
        val submittedQuery = viewModel.onSearchSubmitted()

        assertEquals("algebra", submittedQuery)
        assertEquals(
            listOf("home_viewed", "search_focused", "search_submitted"),
            telemetryRepository.eventNames()
        )
    }

    @Test
    fun blankSubmit_returnsNullAndDoesNotRecordSubmit() {
        val telemetryRepository = RecordingTelemetryRepository()
        val viewModel = HomeViewModel(telemetryRepository)

        assertNull(viewModel.onSearchSubmitted())
        assertEquals(listOf("home_viewed"), telemetryRepository.eventNames())
    }
}

private class RecordingTelemetryRepository : TelemetryRepository {
    private val _events = MutableStateFlow<List<TelemetryEvent>>(emptyList())
    override val events: StateFlow<List<TelemetryEvent>> = _events

    override fun record(event: TelemetryEvent) {
        _events.value = _events.value + event
    }

    fun eventNames(): List<String> = events.value.map { it.name }
}
