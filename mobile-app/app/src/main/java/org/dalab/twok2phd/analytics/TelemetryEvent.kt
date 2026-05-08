package org.dalab.twok2phd.analytics

sealed class TelemetryEvent {
    // Home
    data object HomeViewed : TelemetryEvent()
    data object SearchFocused : TelemetryEvent()
    data class SearchSubmitted(val query: String, val quickFilter: String? = null) : TelemetryEvent()
    data class SearchFailed(val query: String) : TelemetryEvent()

    // Results
    data class ResultImpression(val resourceId: String, val position: Int) : TelemetryEvent()
    data class ResultOpened(val resourceId: String) : TelemetryEvent()

    // Use decision
    data class UseThisSelected(val resourceId: String) : TelemetryEvent()
    data object NeedBetterMatchTapped : TelemetryEvent()
    data class FeedbackSubmitted(
        val resourceId: String,
        val signal: FeedbackSignal,
    ) : TelemetryEvent()

    // Ticket & survey
    data class TicketSubmitted(val query: String) : TelemetryEvent()
    data object SurveyCompleted : TelemetryEvent()
}

enum class FeedbackSignal { HELPFUL, NOT_HELPFUL }
