package com.example.foodly.screens.Profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodly.ui.theme.LightGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun SecurityScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Security",fontWeight = FontWeight.Bold) },
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
                    androidx.compose.material.Text(text = "Remember me", fontSize = 24.sp)
                    SwitchButton()
                }
                Spacer(modifier = Modifier.size(size = 12.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    androidx.compose.material.Text(text = "Face ID", fontSize = 24.sp)
                    SwitchButton()
                }
                Spacer(modifier = Modifier.size(size = 12.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    androidx.compose.material.Text(text = "Biometric ID", fontSize = 24.sp)
                    SwitchButton()
                }
                Spacer(modifier = Modifier.size(size = 12.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    androidx.compose.material.Text(text = "Google authenticator", fontSize = 24.sp)
                    Icon(Icons.Outlined.ChevronRight, null)
                }

                Spacer(modifier = Modifier.size(size = 30.dp))

                RoundedButton(
                    label = "Change PIN",
                    backgroundColor = LightGreen
                )
                Spacer(modifier = Modifier.size(size = 10.dp))

                RoundedButton(
                    label = "Change Password",
                    backgroundColor = LightGreen
                )
            }
        }
    )
}



@Preview
@Composable
fun PreviewSecurity(){
    SecurityScreen()
}