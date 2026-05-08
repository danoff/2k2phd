package org.dalab.twok2phd.analytics

import org.junit.Assert.assertEquals
import org.junit.Test

class InMemoryTelemetryRepositoryTest {
    @Test
    fun record_appendsEventsInOrder() {
        val repository = InMemoryTelemetryRepository()

        repository.record(TelemetryEvent.HomeViewed(occurredAtMillis = 1L))
        repository.record(TelemetryEvent.SearchFocused(occurredAtMillis = 2L))

        assertEquals(
            listOf("home_viewed", "search_focused"),
            repository.events.value.map { it.name }
        )
    }

    @Test
    fun record_keepsMostRecentFiveHundredEvents() {
        val repository = InMemoryTelemetryRepository()

        repeat(505) { index ->
            repository.record(
                TelemetryEvent.SearchSubmitted(
                    query = "query-$index",
                    occurredAtMillis = index.toLong()
                )
            )
        }

        val events = repository.events.value
        assertEquals(500, events.size)
        assertEquals("query-5", (events.first() as TelemetryEvent.SearchSubmitted).query)
        assertEquals("query-504", (events.last() as TelemetryEvent.SearchSubmitted).query)
    }
}
