package com.example.foodly.Splash.navigation

sealed class Screen(val route: String){
    object Splash: Screen("Splash_screen")
    object Home: Screen("home_screen")
}