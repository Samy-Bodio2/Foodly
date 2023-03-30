package com.example.splash_samy.navigation

sealed class Screen(val route: String){
    object Splash: Screen("Splash_screen")
    object Home: Screen("home_screen")
}
