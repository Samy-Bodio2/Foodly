package com.example.foodly.Administrateur

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodly.screens.Profile.SwitchButton
import com.example.foodly.ui.theme.LightGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenAdministrateur(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Administrator",fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back button click */ }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                Button(
                    onClick = {

                    },
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(LightGreen)
                ) {
                    Text(text = "Change PIN", color = Color.White)
                }
                Spacer(modifier = Modifier.size(size = 10.dp))
                Button(
                    onClick = {

                    },
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(LightGreen)
                ) {
                    Text(text = "Change Password", color = Color.White)
                }

            }
        }
    )
}