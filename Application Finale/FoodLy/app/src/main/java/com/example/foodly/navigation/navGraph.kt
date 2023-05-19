package com.example.foodly.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodly.screens.Home_ActionMenu.CategoryItem
import com.example.foodly.screens.Home_ActionMenu.CategoryScreen
import com.example.foodly.screens.Home_ActionMenu.HomeScreen
import com.example.foodly.screens.Onboarding_SignUp_SignIn.*

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route){

        composable(route = Screen.Splash.route){
            AnimatedSplashScreen(navController)
        }
        composable(route = Screen.PageViewScreen.route){
            PageViewScreen(navController)
        }
        composable(route = Screen.Lets_You_In.route){
            Let_You_In(navController)
        }
        composable(route = Screen.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(route = Screen.RegisterScreen.route){
            RegisterScreen(navController)
        }
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = Screen.HomeScreen.route){
            CategoryItem(navController)
        }
        composable(route = Screen.HomeScreen.route){
            CategoryScreen(navController)
        }

        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController)
        }
    }
}