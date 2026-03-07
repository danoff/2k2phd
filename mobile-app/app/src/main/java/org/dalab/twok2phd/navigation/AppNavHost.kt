package org.dalab.twok2phd.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.dalab.twok2phd.home.HomeScreen
import org.dalab.twok2phd.results.ResultsScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoute.Home.route
    ) {
        composable(AppRoute.Home.route) {
            HomeScreen(
                onSearchSubmitted = { query ->
                    navController.navigate(AppRoute.Results.create(query))
                }
            )
        }

        composable(
            route = AppRoute.Results.route,
            arguments = listOf(navArgument(AppRoute.Results.ARG_QUERY) { type = NavType.StringType })
        ) { backStackEntry ->
            val query = backStackEntry.arguments?.getString(AppRoute.Results.ARG_QUERY).orEmpty()
            ResultsScreen(query = query)
        }
    }
}
