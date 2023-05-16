package com.example.foodly.screens.Profile


import androidx.compose.foundation.layout.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun NotificationScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Notification",fontWeight = FontWeight.Bold) },
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
                Spacer(modifier = Modifier.size(size = 80.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    androidx.compose.material.Text(text = "General Notification", fontSize = 24.sp)
                    SwitchButton()
                }

                Spacer(modifier = Modifier.size(size = 12.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    androidx.compose.material.Text(text = "Sound", fontSize = 24.sp)
                    SwitchButton()
                }
                Spacer(modifier = Modifier.size(size = 12.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    androidx.compose.material.Text(text = "Vibrate", fontSize = 24.sp)
                    SwitchButton()
                }
                Spacer(modifier = Modifier.size(size = 12.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    androidx.compose.material.Text(text = "Special offers", fontSize = 24.sp)
                    SwitchButton()
                }

                Spacer(modifier = Modifier.size(size = 12.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    androidx.compose.material.Text(text = "Promo & Discount", fontSize = 24.sp)
                    SwitchButton()
                }
                Spacer(modifier = Modifier.size(size = 12.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    androidx.compose.material.Text(text = "Payements", fontSize = 24.sp)
                    SwitchButton()
                }

                Spacer(modifier = Modifier.size(size = 12.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    androidx.compose.material.Text(text = "Cashback", fontSize = 24.sp)
                    SwitchButton()
                }
                Spacer(modifier = Modifier.size(size = 12.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    androidx.compose.material.Text(text = "App Updates", fontSize = 24.sp)
                    SwitchButton()
                }

                Spacer(modifier = Modifier.size(size = 12.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    androidx.compose.material.Text(text = "New service Available", fontSize = 24.sp)
                    SwitchButton()
                }


                @Preview
@Composable
fun PreviewNotification(){
    NotificationScreen()
}