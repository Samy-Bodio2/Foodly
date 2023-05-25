package com.example.foodly.screens.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodly.R
import com.example.foodly.navigation.Screen
import com.example.foodly.ui.theme.LightGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    Column(modifier = Modifier.padding(horizontal = 16.dp), ) {
        //Top With the world profile
        TopAppBar(
            title = { androidx.compose.material3.Text(text = "Profile") },
            navigationIcon = {
                androidx.compose.material3.IconButton(onClick = { navController.navigate(Screen.ProfileScreen.route) }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                androidx.compose.material3.IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.MoreVert, contentDescription = null)
                }
            }
        )

        Spacer(modifier = Modifier.size(size = 32.dp))

        //Avatar with Name and number
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painterResource(id = R.drawable.profil),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(40.dp))
                    .size(80.dp)
            )

            Column(modifier = Modifier.padding(start = 24.dp))
            {
                Text(text = "Jason Kamsu", fontSize = 24.sp)
                Text(text = "237 6 93 91 00 55", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(width = 40.dp))
            Icon(Icons.Rounded.DriveFileRenameOutline, null, tint = LightGreen)


        }

        Spacer(modifier = Modifier.size(size = 24.dp))

        //First part of the menu
        Column() {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Outlined.CalendarMonth, null)
                Spacer(modifier = Modifier.width(width =  8.dp))
                Text(text = "My Favorite Restaurants", fontSize = 24.sp )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = { navController.navigate(Screen.FavoriteRestaurants.route) },
                    modifier = Modifier.padding(horizontal = 5.dp)
                ) {
                    Icon(Icons.Outlined.ChevronRight, null)
                }
            }

            Spacer(modifier = Modifier.size(size = 8.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Outlined.AccountBalanceWallet, null)
                Spacer(modifier = Modifier.width(width =  8.dp))
                Text(text = "Payment Methods", fontSize = 24.sp)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { navController.navigate(Screen.PayementMethodsProfile.route) }) {
                    Icon(Icons.Outlined.ChevronRight, null)
                }
            }
        }

        Spacer(modifier = Modifier.size(size = 24.dp))

        //Second Part of the menu
        Column() {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Outlined.PersonOutline, null)
                Spacer(modifier = Modifier.width(width =  8.dp))
                Text(text = "Profile", fontSize = 24.sp)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { navController.navigate(Screen.UpdateProfileScreen.route) }) {
                    Icon(Icons.Outlined.ChevronRight, null)
                }
            }

            Spacer(modifier = Modifier.size(size = 8.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Outlined.LocationOn, null)
                Spacer(modifier = Modifier.width(width =  8.dp))
                Text(text = "Address", fontSize = 24.sp)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { navController.navigate(Screen.AddressScreen.route) }) {
                    Icon(Icons.Outlined.ChevronRight, null)
                }
            }

            Spacer(modifier = Modifier.size(size = 8.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Outlined.NotificationsNone, null)
                Spacer(modifier = Modifier.width(width =  8.dp))
                Text(text = "Notifications", fontSize = 24.sp)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { navController.navigate(Screen.NotificationsScreen.route) }) {
                    Icon(Icons.Outlined.ChevronRight, null)
                }
            }

            Spacer(modifier = Modifier.size(size = 8.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Outlined.GppGood, null)
                Spacer(modifier = Modifier.width(width =  8.dp))
                Text(text = "Security", fontSize = 24.sp)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { navController.navigate(Screen.SecurityScreen.route) }) {
                    Icon(Icons.Outlined.ChevronRight, null)
                }
            }

            Spacer(modifier = Modifier.size(size = 8.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Outlined.Casino, null)
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "Language", fontSize = 24.sp)
                }

                Spacer(modifier = Modifier.width(width = 60.dp))

                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "English (US)", fontSize = 24.sp)
                    Spacer(modifier = Modifier.width(width = 16.dp))
                    Icon(Icons.Outlined.ChevronRight, null)
                }
            }

            Spacer(modifier = Modifier.size(size = 8.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Outlined.RemoveRedEye, null)
                Spacer(modifier = Modifier.width(width =  8.dp))
                Text(text = "Dark mode", fontSize = 24.sp)
                Spacer(modifier = Modifier.weight(1f))
                SwitchButton()
            }

            Spacer(modifier = Modifier.size(size = 8.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Outlined.Logout,
                    null,
                    tint = Color.Red,
                    modifier = Modifier.size(size = 24.dp)
                )
                Spacer(modifier = Modifier.width(width =  8.dp))
                Text(text = "Logout", color = Color.Red, fontSize = 24.sp)
            }
        }
    }

}

@Composable
fun SwitchButton(){
    var isChecked by remember { mutableStateOf(false) }

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
}