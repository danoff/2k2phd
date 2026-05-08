package org.dalab.twok2phd.analytics

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InMemoryTelemetryRepository @Inject constructor() : TelemetryRepository {
    private val maxEvents = 500
    private val _events = MutableStateFlow<List<TelemetryEvent>>(emptyList())

    override val events: StateFlow<List<TelemetryEvent>> = _events.asStateFlow()

    override fun record(event: TelemetryEvent) {
        _events.update { currentEvents ->
            (currentEvents + event).takeLast(maxEvents)
        }
    }
}
