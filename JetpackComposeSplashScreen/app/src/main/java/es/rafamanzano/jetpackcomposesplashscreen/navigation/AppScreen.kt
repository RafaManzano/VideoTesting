package es.rafamanzano.jetpackcomposesplashscreen.navigation

sealed class AppScreen(val route: String) {
    object SplashScreen: AppScreen("splash_screen")
    object MainScreen: AppScreen("main_screen")
}