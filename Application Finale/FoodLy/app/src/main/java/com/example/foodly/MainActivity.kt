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
<<<<<<< HEAD
import com.example.foodly.Splash.getStart
=======
<<<<<<< HEAD
import com.example.foodly.commander.*
=======
>>>>>>> 5dea9794a1d72792fe99ba39dd8b5328c33c7614
import com.example.foodly.commander.DesignMap
import com.example.foodly.commander.FoodOrderScreen
import com.example.foodly.commander.facturation
import com.example.foodly.commander.momoOM
import com.example.foodly.component.StandardScaffold
import com.example.foodly.screens.Destinations
import com.example.foodly.screens.DetailScreen
import com.example.foodly.screens.HomeScreene
>>>>>>> 358bb64113d7cb21aa0216acaeb3db98142fc836
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

<<<<<<< HEAD
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
=======
<<<<<<< HEAD
        NavHost(navController = navController, startDestination = "track", builder = {
=======
<<<<<<< HEAD
        NavHost(navController = navController, startDestination = Screen.Splash.route, builder = {
=======
        NavHost(navController = navController, startDestination = "homescreen", builder = {
>>>>>>> 4b1f2869787b4d6abca73ec94f7578854c2bf9f0
>>>>>>> 358bb64113d7cb21aa0216acaeb3db98142fc836
            composable(route = Screen.Splash.route){ AnimatedSplashScreen(navController) }
            composable(route = Screen.PageScreen.route){PageViewScreen(navController) }
            /*composable("name", content = { Name(navController = navController) })
            composable("email", content = { Email(navController = navController)} )
            composable("phone_number", content = { Phone_number(navController = navController) })
            composable("password", content = { Password(navController = navController) })*/
            //composable("login_page", content = { LoginPage(null, navController = navController) })
            composable("homescreen", content = { HomeScreen(null, navController = navController)} )
            composable(Destinations.Home){ HomeScreene(navController=navController)}
            composable(Destinations.Detail){ DetailScreen(navController=navController)}
            composable("register_page", content = { RegisterPage(navController = navController) })
            composable("reset_page", content = { ResetPage(navController = navController) })
            composable("otpVerify", content = { OtpVerifyScreen(navController = navController) })
            composable("panierscreen",content={MealList(navController = navController) })
            composable("passComm",content={FoodOrderScreen(navController = navController) })
            composable("factu", content = { facturation(navController = navController) })
            composable("momoOM", content = { momoOM(navController = navController) })
            composable("mapF", content = { DesignMap(context = this@MainActivity, navController = navController) })
            composable("track", content = { Interface(navController = navController) })
        })
>>>>>>> 5dea9794a1d72792fe99ba39dd8b5328c33c7614
    }
}