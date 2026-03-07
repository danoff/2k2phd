package org.dalab.twok2phd.navigation

sealed class AppRoute(val route: String) {
    data object Home : AppRoute("home")
    data object Results : AppRoute("results/{query}") {
        const val ARG_QUERY = "query"
        fun create(query: String): String = "results/$query"
    }
}
