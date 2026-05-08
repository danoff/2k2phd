package org.dalab.twok2phd.analytics

sealed interface TelemetryEvent {
    val name: String
    val occurredAtMillis: Long

    data class HomeViewed(
        override val occurredAtMillis: Long = System.currentTimeMillis()
    ) : TelemetryEvent {
        override val name = "home_viewed"
    }

    data class SearchFocused(
        override val occurredAtMillis: Long = System.currentTimeMillis()
    ) : TelemetryEvent {
        override val name = "search_focused"
    }

    data class SearchSubmitted(
        val query: String,
        override val occurredAtMillis: Long = System.currentTimeMillis()
    ) : TelemetryEvent {
        override val name = "search_submitted"
    }

    data class ResultsViewed(
        val query: String,
        val resultCount: Int,
        override val occurredAtMillis: Long = System.currentTimeMillis()
    ) : TelemetryEvent {
        override val name = "results_viewed"
    }

    data class SearchFailed(
        val query: String,
        override val occurredAtMillis: Long = System.currentTimeMillis()
    ) : TelemetryEvent {
        override val name = "search_failed"
    }

    data class ResultImpression(
        val resourceId: String,
        val position: Int,
        override val occurredAtMillis: Long = System.currentTimeMillis()
    ) : TelemetryEvent {
        override val name = "result_impression"
    }

    data class OerOpened(
        val resourceId: String,
        override val occurredAtMillis: Long = System.currentTimeMillis()
    ) : TelemetryEvent {
        override val name = "oer_opened"
    }

    data class UseThisMarked(
        val resourceId: String,
        override val occurredAtMillis: Long = System.currentTimeMillis()
    ) : TelemetryEvent {
        override val name = "use_this_marked"
    }

    data class NeedBetterMatchClicked(
        val query: String,
        val lastRecommendationIds: List<String>,
        override val occurredAtMillis: Long = System.currentTimeMillis()
    ) : TelemetryEvent {
        override val name = "need_better_match_clicked"
    }

    data class OerRated(
        val resourceId: String,
        val helpful: Boolean,
        override val occurredAtMillis: Long = System.currentTimeMillis()
    ) : TelemetryEvent {
        override val name = "oer_rated"
    }

    data class TicketSubmitted(
        val query: String,
        val triggerReason: String,
        override val occurredAtMillis: Long = System.currentTimeMillis()
    ) : TelemetryEvent {
        override val name = "ticket_submitted"
    }

    data class SurveyCompleted(
        override val occurredAtMillis: Long = System.currentTimeMillis()
    ) : TelemetryEvent {
        override val name = "survey_completed"
    }
}
