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
import com.example.foodly.screens.Home_ActionMenu.HomeScreen
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
<<<<<<< HEAD
                    val navController = rememberNavController()
                    HomeScreen(navController)
=======

                    //val navController = rememberNavController()
=======
<<<<<<< HEAD
                    //val navController = rememberNavController()
                    //NavGraph(navController)
                    TopBar()
<<<<<<< HEAD

=======
=======
>>>>>>> 6c236502539f32078ded7a733def96f8de05ed91
>>>>>>> 6a83b548425b5c0091d4e5e8fb386ab050aee4e6
                    LoginApplication()

>>>>>>> c48361f35b996ae3ad28c992a0acb92f7ca3349b
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