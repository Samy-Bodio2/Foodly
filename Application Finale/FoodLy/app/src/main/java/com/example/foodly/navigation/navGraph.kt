package com.example.foodly.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodly.screens.Onboarding_SignUp_SignIn.AnimatedSplashScreen
import com.example.foodly.screens.Onboarding_SignUp_SignIn.Let_You_In
import com.example.foodly.screens.Onboarding_SignUp_SignIn.PageViewScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route){

        composable(route = Screen.Splash.route){
            AnimatedSplashScreen(navController)
        }
        composable(route = Screen.PageViewScreen.route){
            PageViewScreen(navController)
        }
        composable(route = Screen.Lets_You_In.route){
            Let_You_In(navController)
        }
    }
}