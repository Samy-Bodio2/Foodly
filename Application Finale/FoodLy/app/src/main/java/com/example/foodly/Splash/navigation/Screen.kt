package com.example.foodly.Customers.Splash.navigation

sealed class Screen(val route: String){
    object Splash: Screen("Splash_screen")
    object PageScreen: Screen("page_view_screen")
    object Home: Screen("home_screen")

    object WelcomeScreen : Screen("welcome_screen")
    object LoginScreen : Screen("login_screen")
    object CreateAccountScreen : Screen("create_account_screen")
    object OtpVerifyScreen : Screen("otp_verify_screen")
    object ForgotPasswordScreen : Screen("forgot_password_screen")
    object HomeScreen : Screen("home_screen")
    object FavoriteScreen : Screen("favorite_screen")
    object SearchScreen : Screen("search_screen")
    object OrderScreen : Screen("order_screen")
    object TrackOrderScreen : Screen("track_order_screen")
    object SavesScreen : Screen("saves_screen")
    object ProfileScreen : Screen("profile_screen")
    object HomeScreenRestaurant : Screen("homescreen")
}