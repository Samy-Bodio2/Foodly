package com.example.foodly

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Screen(
    val route:String,
    @StringRes val title:Int,
    val icon: ImageVector
){


    object Home:Screen("homes", R.string.home, Icons.Rounded.Home)
    object Favorites:Screen("favorites",R.string.favorites, Icons.Rounded.Favorite)
    object Profile:Screen("profile",R.string.profile, Icons.Rounded.Person)
    object Settings:Screen("settings",R.string.settings, Icons.Rounded.Settings)

    object Search:Screen("search",R.string.search, Icons.Rounded.Search)


}