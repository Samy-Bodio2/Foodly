package com.example.foodly.Administrateur

import android.content.ContentValues.TAG
import android.hardware.lights.Light
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.MenuOpen
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.foodly.navigation.Screen
import com.example.foodly.ui.theme.LightGreen
import com.example.foodly.ui.theme.Teal200
import com.example.foodly.ui.theme.Yellow500
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoard(navController: NavController) {
    val db = Firebase.firestore
    val menuCollectionRef = db.collection("Menu")
    var menuCount by remember { mutableStateOf(0) }
    val auth  = Firebase.auth

    LaunchedEffect(true) {
        menuCollectionRef.get().addOnSuccessListener { querySnapshot ->
            menuCount = querySnapshot.size()
        }
    }

    Column(Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Administrator") },
            actions = {
                IconButton(onClick = { auth.signOut(); navController.navigate(Screen.LoginScreen.route) }) {
                    Icon(Icons.Filled.Logout, contentDescription = null, tint = Color.Red)
                }
            }
        )

        Text(
            text = "DashBoard",
            fontSize = 32.sp,
            modifier = Modifier.padding(16.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(100.dp)
                .background(
                    color = LightGreen,
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(16.dp),
            contentAlignment = Alignment.Center,


            ) {
            Row() {
                Text(
                    text = "Nombre de menus: $menuCount",
                    fontSize = 24.sp,
                )
                IconButton(onClick = { navController.navigate(Screen.AddMenuAdmin.route) }) {
                    Icon(Icons.Filled.MenuOpen, contentDescription = "Ajouter un menu", tint = Color.Black)
                }
            }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(100.dp)
                .background(
                    color = Teal200,
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(16.dp),
            contentAlignment = Alignment.Center,


            ) {
            Row() {
                Text(
                    text = "Nombre de restaurants: 8",
                    fontSize = 24.sp,
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Add, contentDescription = null, tint = Color.Black)
                }
            }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(100.dp)
                .background(
                    color = Yellow500,
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(16.dp),
            contentAlignment = Alignment.Center,


            ) {
            Row() {
                Text(
                    text = "Nombre de commande: 10",
                    fontSize = 24.sp,
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.MenuOpen, contentDescription = null, tint = Color.Black)
                }
            }

        }
    }

}