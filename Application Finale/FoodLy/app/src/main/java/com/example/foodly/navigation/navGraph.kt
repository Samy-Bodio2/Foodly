package com.example.foodly.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodly.screens.Onboarding_SignUp_SignIn.AnimatedSplashScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route){

        composable(route = Screen.Splash.route){
            AnimatedSplashScreen(navController)
        }
    }
}