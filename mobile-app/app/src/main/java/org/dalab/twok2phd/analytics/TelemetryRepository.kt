package org.dalab.twok2phd.analytics

import kotlinx.coroutines.flow.StateFlow

interface TelemetryRepository {
    val events: StateFlow<List<TelemetryEvent>>

    fun record(event: TelemetryEvent)
}
