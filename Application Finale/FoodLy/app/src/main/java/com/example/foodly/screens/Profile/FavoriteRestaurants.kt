package com.example.foodly.screens.Profile

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowLeft
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodly.navigation.Screen

@Composable
fun FullFavoriteRestaurant(){

}

@Composable
fun EmptyFavoriteRestaurant(){

}


@Composable
fun FavoriteRestaurants(navController: NavController){
    Row {
        Icon(Icons.Outlined.ArrowLeft, null)
        Text(text = "My Favorite Restaurants", fontSize = 32.sp)
        Icon(Icons.Outlined.Search, contentDescription = null)
    }
}