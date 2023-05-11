package com.example.foodly.Customers.Splash.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.foodly.R

sealed class Screen(
    val route: String,
    val title: Int?,
    val icon: ImageVector?
){
    object Splash: Screen("Splash_screen",null,null)
    object PageScreen: Screen("page_view_screen",null,null)
    object Home: Screen("home_screen",null,null)

    object Homes:Screen("home", R.string.home, Icons.Rounded.Home)
    object Favorites:Screen("favorites",R.string.favorites, Icons.Rounded.Favorite)
    object Profile:Screen("profile",R.string.profile, Icons.Rounded.Person)
    object Settings:Screen("settings",R.string.settings, Icons.Rounded.Settings)

    object Search:Screen("search",R.string.search, Icons.Rounded.Search)
}