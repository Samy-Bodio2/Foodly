package com.example.foodly.Customers.splash_login

import com.example.foodly.Customers.Splash.navigation.Screen

sealed class bigScreen(val route: String){
    object Splash: bigScreen(route = "Splash_screen")
    object Home: bigScreen(route = "log_screen")
    object Detail: bigScreen(route = "start_screen")
}
