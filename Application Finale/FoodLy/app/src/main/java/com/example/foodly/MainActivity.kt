package com.example.foodly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.foodly.component.StandardScaffold
import com.example.foodly.navigation.NavGraph
import com.example.foodly.navigation.Screen
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 66ad1931f5259f7c60ceb3989be5cc4fc660cde4


import com.example.foodly.screens.Onboarding_SignUp_SignIn.Let_You_In
import com.example.foodly.screens.Profile.ProfileScreen
import com.example.foodly.screens.Profile.SwitchButton
import com.example.foodly.screens.Profile.TopBar
<<<<<<< HEAD
=======
=======
import com.example.foodly.screens.Home_ActionMenu.HomeScreen
import com.example.foodly.screens.e_wallet.EWalletScreen
>>>>>>> 54d9f8e05d16c767646ee7286fef1fcb5e9adc80
>>>>>>> 66ad1931f5259f7c60ceb3989be5cc4fc660cde4
import com.example.foodly.ui.theme.FoodlyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodlyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //val navController = rememberNavController()
<<<<<<< HEAD
                    val navController = rememberNavController()
                    NavGraph(navController)
                    //ModifConfirm()
=======
                    //val navController = rememberNavController()
                    //NavGraph(navController)
                    TopBar()
=======
>>>>>>> 54d9f8e05d16c767646ee7286fef1fcb5e9adc80
                    LoginApplication()
>>>>>>> 66ad1931f5259f7c60ceb3989be5cc4fc660cde4
                }
            }
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
            Screen.OrderScreen.route,
            Screen.EWalletScreen.route,
            Screen.ProfileScreen.route
        ),
        modifier = Modifier.fillMaxSize(),
    ) {
        NavGraph(navController)
    }
}