package com.example.mapactivity.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mapactivity.DesignMap
import com.example.mapactivity.MapView
import com.example.mapactivity.OSMMap

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "Map"
    ){
        composable(route = "Map"){
            DesignMap(navController)
        }
        composable(route = "MapView"){
            MapView(navController)
        }
    }
}