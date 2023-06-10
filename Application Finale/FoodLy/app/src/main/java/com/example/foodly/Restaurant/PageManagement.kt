@file:OptIn(ExperimentalMaterialApi::class)

package com.example.foodly.Restaurant

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodly.R
import com.example.foodly.navigation.Screen
import com.example.foodly.ui.theme.colorRedLite
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun PageManagement(navController: NavController){
    val auth  = Firebase.auth
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            TopAppBar(
                title = { Text("Restaurant") },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Rounded.MoreVert, contentDescription = null)
                    }
                }
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.profil),
                    contentDescription = null,
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                )
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text("Jason Kamsu")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("+237 6 93 91 00 55")
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(start = 8.dp)) {
                    Icon(Icons.Rounded.Edit, contentDescription = null)
                }
            }
            Divider(modifier = Modifier.padding(horizontal = 16.dp))
        }
        items(10) {
            when (it) {
                0 -> ListItem(
                    icon = { Icon(Icons.Rounded.CalendarMonth, contentDescription = null) },
                    text = { Text("Menu") },
                    trailing = { Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = null) },
                    modifier = Modifier.clickable { navController.navigate(Screen.Consult_Menu.route) }
                )
                1 -> ListItem(
                    icon = { Icon(Icons.Rounded.FolderSpecial, contentDescription = null) },
                    text = { Text("Menu Detail") },
                    trailing = { Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = null) },
                    modifier = Modifier.clickable { /*TODO*/ }
                )
                2 -> {
                    ListItem(
                        icon = { Icon(Icons.Rounded.Wallet, contentDescription = null) },
                        text = { Text("Add Menu") },
                        trailing = { Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = null) },
                        modifier = Modifier.clickable { navController.navigate(Screen.HomeScreenResto.route) }
                    )
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                }
                3 -> ListItem(
                    icon = { Icon(Icons.Rounded.LocationOn, contentDescription = null) },
                    text = { Text("Address") },
                    trailing = { Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = null) },
                    modifier = Modifier.clickable { navController.navigate(Screen.AddressScreen.route) }
                )
                4 -> ListItem(
                    icon = { Icon(Icons.Rounded.Notifications, contentDescription = null) },
                    text = { Text("Notifications") },
                    trailing = { Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = null) },
                    modifier = Modifier.clickable { navController.navigate(Screen.NotificationsScreen.route) }
                )
                5 -> ListItem(
                    icon = { Icon(Icons.Rounded.Security, contentDescription = null) },
                    text = { Text("Security") },
                    trailing = { Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = null) },
                    modifier = Modifier.clickable { navController.navigate(Screen.SecurityScreen.route) }
                )
                6 -> ListItem(
                    icon = { Icon(Icons.Rounded.Language, contentDescription = null) },
                    text = { Text("Language") },
                    secondaryText = { Text("English(US)") },
                    trailing = { Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = null) },
                    modifier = Modifier.clickable { /*TODO*/ }
                )
                7 -> {
                    var isChecked by remember { mutableStateOf(false) }
                    ListItem(
                        icon = { Icon(Icons.Rounded.DarkMode, contentDescription = null) },
                        text = { Text("Dark Mode") },
                        trailing = {
                            Switch(
                                checked = isChecked,
                                onCheckedChange = { isChecked = it },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = Color(0xFF1CAD4C),
                                    uncheckedThumbColor = Color.White,
                                    uncheckedTrackColor = Color(0xFFBDBDBD)
                                )
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                8 -> ListItem(
                    icon = { Icon(Icons.Rounded.HelpCenter, contentDescription = null) },
                    text = { Text("Help Center") },
                    trailing = { Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = null) },
                    modifier = Modifier.clickable { /*TODO*/ }
                )

                9 -> ListItem(
                    icon = { Icon(Icons.Rounded.Logout, contentDescription = null, tint = colorRedLite) },
                    text = { Text("Logout") },
                    modifier = Modifier.clickable { auth.signOut(); navController.navigate(Screen.LoginScreen.route) }
                )
            }
        }
    }
}

