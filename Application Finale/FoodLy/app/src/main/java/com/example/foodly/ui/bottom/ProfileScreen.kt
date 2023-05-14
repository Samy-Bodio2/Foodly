package com.example.foodly.ui.bottom


import android.annotation.SuppressLint

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodly.ProfileFile.User
import com.example.foodly.R
import com.example.foodly.ui.theme.colorWhite
import com.example.foodly.ui.theme.orange2

import java.util.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController : NavController) {

    val user = remember { mutableStateOf(User(name = "Angele", email = "angele@example.com")) }
    val isEditing = remember { mutableStateOf(false) }
    Scaffold(
        topBar = { TopAppBar(title = { Text("Profile") }) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { isEditing.value = !isEditing.value },
                content = {
                    Icon(
                        if (isEditing.value) Icons.Filled.Done else Icons.Filled.Edit,
                        contentDescription = ""
                    )
                }
            )
        },
        bottomBar = {
            if (isEditing.value) {
                Button(
                    onClick = { isEditing.value = false },
                    modifier = Modifier.padding(32.dp).height(8.dp)
                ) {
                    Text(text = "Save")
                }
            } else {
                null
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_face_24),
                contentDescription = "User profile picture",
                modifier = Modifier
                    .size(128.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 48.dp, end = 48.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                if (isEditing.value) {
                    OutlinedTextField(
                        value = user.value.name,
                        onValueChange = { user.value = user.value.copy(name = it) },
                        label = { Text("Name") }
                    )
                } else {
                    Text(text = user.value.name, style = MaterialTheme.typography.h5)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            if (isEditing.value) {
                OutlinedTextField(
                    value = user.value.email,
                    onValueChange = { user.value = user.value.copy(email = it) },
                    label = { Text("Email") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email
                    )
                )
            } else {
                Text(text = user.value.email, style = MaterialTheme.typography.subtitle1)
            }
            Spacer(modifier = Modifier.height(16.dp))
            val date = Date()
            Text(
                text = "$date",
                style = MaterialTheme.typography.body2,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navController.navigate("mapF") {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = orange2),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = "Localisation",
                    color = colorWhite,
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navController.navigate("login_page") {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = orange2),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = "Log out",
                    color = colorWhite,
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
            }
        }
    }
}
