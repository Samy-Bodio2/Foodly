package com.example.foodly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.foodly.component.StandardScaffold
import com.example.foodly.navigation.NavGraph
import com.example.foodly.navigation.Screen
import com.example.foodly.screens.Onboarding_SignUp_SignIn.Login
import com.example.foodly.ui.theme.FoodlyTheme
import com.facebook.login.Login
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import kotlin.random.Random

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
                    LoginApplication()
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