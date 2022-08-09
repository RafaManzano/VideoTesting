package es.rafamanzano.jetpackcomposesplashscreen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import es.rafamanzano.jetpackcomposesplashscreen.MainScreen
import es.rafamanzano.jetpackcomposesplashscreen.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = AppScreen.SplashScreen.route) {
        composable(AppScreen.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(AppScreen.MainScreen.route) {
            MainScreen()
        }
    }

}