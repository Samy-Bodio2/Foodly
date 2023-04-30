package com.example.foodly

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodly.Customers.Splash.navigation.Screen
import com.example.foodly.Log.Email


import com.example.foodly.Splash.AnimatedSplashScreen
import com.example.foodly.Splash.PageViewScreen
import com.example.foodly.screens.MealList
import com.example.foodly.ui.auth.LoginPage
import com.example.foodly.ui.auth.OtpVerifyScreen
import com.example.foodly.ui.auth.RegisterPage
import com.example.foodly.ui.auth.ResetPage
import com.example.foodly.ui.home.HomeScreen
import com.example.foodly.ui.theme.FoodlyTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            FoodlyTheme() {
                LoginApplication()

            }
        }
    }

    @Composable
    fun LoginApplication(){
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "Splash_screen", builder = {
            composable(route = Screen.Splash.route){ AnimatedSplashScreen(navController) }
            composable(route = Screen.PageScreen.route){PageViewScreen(navController) }
            composable("login_page", content = { LoginPage(navController = navController) })
            composable("homescreen", content = { HomeScreen(null, navController = navController)} )
            composable("register_page", content = { RegisterPage(navController = navController) })
            composable("reset_page", content = { ResetPage(navController = navController) })
            composable("otpVerify", content = { OtpVerifyScreen(navController = navController) })


            composable("email", content = { Email(navController = navController)})
        })
    }
}