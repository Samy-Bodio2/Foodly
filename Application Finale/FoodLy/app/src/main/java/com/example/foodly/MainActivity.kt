package com.example.foodly

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.foodly.Customers.Splash.navigation.Screen
/*import com.example.foodly.Inscription.Email
import com.example.foodly.Inscription.Name
import com.example.foodly.Inscription.Password
import com.example.foodly.Inscription.Phone_number*/


import com.example.foodly.Splash.AnimatedSplashScreen
import com.example.foodly.Splash.PageViewScreen
import com.example.foodly.Splash.getStart
import com.example.foodly.commander.DesignMap
import com.example.foodly.commander.FoodOrderScreen
import com.example.foodly.commander.facturation
import com.example.foodly.commander.momoOM
import com.example.foodly.component.StandardScaffold
import com.example.foodly.screens.Destinations
import com.example.foodly.screens.DetailScreen
import com.example.foodly.screens.HomeScreene
import com.example.foodly.ui.auth.LoginPage
import com.example.foodly.ui.auth.OtpVerifyScreen
import com.example.foodly.ui.auth.RegisterPage
import com.example.foodly.ui.auth.ResetPage
import com.example.foodly.ui.bottom.*
import com.example.foodly.ui.home.HomeScreen
import com.example.foodly.ui.theme.FoodlyTheme
import com.example.foodly.ui.card.MealList



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
    fun LoginApplication() {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        StandardScaffold(
            navController = navController,
            showBottomBar = navBackStackEntry?.destination?.route in listOf(
                Screen.HomeScreen.route,
                Screen.FavoriteScreen.route,
                Screen.OrderScreen.route,
                Screen.ProfileScreen.route,
                Screen.HomeScreenRestaurant.route,
            ),
            modifier = Modifier.fillMaxSize(),
        ) {

            NavHost(
                navController = navController,
                startDestination = "mapF",
                builder = {
                    composable(route = Screen.Splash.route) { AnimatedSplashScreen(navController) }
                    composable(route = Screen.PageScreen.route) { PageViewScreen(navController) }
                    /*composable("name", content = { Name(navController = navController) })
            composable("email", content = { Email(navController = navController)} )
            composable("phone_number", content = { Phone_number(navController = navController) })
            composable("password", content = { Password(navController = navController) })*/
                    composable("get_started", content = { getStart(navController = navController) })
                    composable("login_page", content = { LoginPage(navController = navController) })
                    composable(
                        "homescreen",
                        content = { HomeScreen(null, navController = navController) })
                    composable(Destinations.Home) { HomeScreene(navController = navController) }
                    composable(Destinations.Detail) { DetailScreen(navController = navController) }
                    composable(
                        "register_page",
                        content = { RegisterPage(navController = navController) })
                    composable("reset_page", content = { ResetPage(navController = navController) })
                    composable(
                        "otpVerify",
                        content = { OtpVerifyScreen(navController = navController) })
                    composable(
                        "panierscreen",
                        content = { MealList(navController = navController) })
                    composable(
                        "passComm",
                        content = { FoodOrderScreen(navController = navController) })
                    composable("factu", content = { facturation(navController = navController) })
                    composable("momoOM", content = { momoOM(navController = navController) })
                    composable(
                        "mapF",
                        content = {
                            DesignMap(
                                context = this@MainActivity,
                                navController = navController
                            )
                        })
                    composable(
                        route = Screen.LoginScreen.route
                    ) {
                        LoginScreen(navController)
                    }

                    composable(
                        route = Screen.HomeScreen.route
                    ) {
                        HomeScreen(navController)
                    }
                    composable(
                        route = Screen.FavoriteScreen.route
                    ) {
                        FavoriteScreen(navController)
                    }
                    composable(
                        route = Screen.SearchScreen.route
                    ) {
                        SearchScreen(navController)
                    }
                    composable(
                        route = Screen.OrderScreen.route
                    ) {
                        OrderScreen(navController)
                    }

                    composable(
                        route = Screen.ProfileScreen.route
                    ) {
                        ProfileScreen(navController)
                    }
                })
        }
    }
}