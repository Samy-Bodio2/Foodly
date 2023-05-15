package com.example.foodly.navigation

sealed class Screen(val route: String){

    object Splash: Screen("Splash_screen")
    object PageViewScreen: Screen("page_view_screen")
    object Lets_You_In: Screen("letyouin")
    object HomeScreen: Screen("homescreen")
    object OrderScreen: Screen("orderscreen")
    object EWalletScreen: Screen("ewallet")
    object ProfileScreen: Screen("profilescreen")


}
