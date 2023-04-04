package com.example.foodly

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodly.Splash.AnimatedSplashScreen
import com.example.foodly.Splash.getStart
import com.example.foodly.Splash.navigation.Screen
import com.example.foodly.ui.auth.LoginPage
import com.example.foodly.ui.auth.RegisterPage
import com.example.foodly.ui.auth.ResetPage
import com.example.foodly.ui.theme.FoodlyTheme
import com.example.log_reg.ui.home.HomeScreen


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
            composable(route = Screen.Home.route){ getStart(navController = navController) }
            composable("login_page", content = { LoginPage(navController = navController) })
            composable("register_page", content = { RegisterPage(navController = navController) })
            composable("reset_page", content = { ResetPage(navController = navController) })
            composable("ROUTE_HOME", content = { HomeScreen(null, navController = navController)} )
        })
    }
}