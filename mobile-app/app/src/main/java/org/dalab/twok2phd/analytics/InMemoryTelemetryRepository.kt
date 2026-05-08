package org.dalab.twok2phd.analytics

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InMemoryTelemetryRepository @Inject constructor() : TelemetryRepository {
    private val _events = MutableStateFlow<List<TelemetryEvent>>(emptyList())
    override val events: StateFlow<List<TelemetryEvent>> = _events.asStateFlow()

    override fun record(event: TelemetryEvent) {
        _events.value = _events.value + event
    }
}
