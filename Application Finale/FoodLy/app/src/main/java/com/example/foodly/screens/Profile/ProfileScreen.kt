package com.example.foodly.screens.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodly.R

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        //Top With the world profile
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Profile", fontSize = 32.sp)
            Spacer(modifier = Modifier.width(width = 242.dp))
            Icon(Icons.Outlined.MoreHoriz, contentDescription = null)
        }

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
                Text(text = "Andrew Ainsley", fontSize = 24.sp)
                Text(text = "+1 111 467 378 399", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(width = 40.dp))
            Icon(Icons.Rounded.DriveFileRenameOutline, null, tint = Color.Green)


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
                Text(text = "My Favorite Restaurants", fontSize = 24.sp)
                Spacer(modifier = Modifier.width(width = 55.dp))
                Icon(Icons.Outlined.ChevronRight, null)
            }

            Spacer(modifier = Modifier.size(size = 8.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Outlined.AccountBalanceWallet, null)
                Text(text = "Payment Methods", fontSize = 24.sp)
                Spacer(modifier = Modifier.width(width =  118.dp))
                Icon(Icons.Outlined.ChevronRight, null)
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
                Text(text = "Profile", fontSize = 24.sp)
                Spacer(modifier = Modifier.width(width =  242.dp))
                Icon(Icons.Outlined.ChevronRight, null)
            }

            Spacer(modifier = Modifier.size(size = 8.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Outlined.LocationOn, null)
                Text(text = "Address", fontSize = 24.sp)
                Spacer(modifier = Modifier.width(width =  224.dp))
                Icon(Icons.Outlined.ChevronRight, null)
            }

            Spacer(modifier = Modifier.size(size = 8.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Outlined.NotificationsNone, null)
                Text(text = "Notifications", fontSize = 24.sp)
                Spacer(modifier = Modifier.width(width =  176.dp))
                Icon(Icons.Outlined.ChevronRight, null)
            }

            Spacer(modifier = Modifier.size(size = 8.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Outlined.GppGood, null)
                Text(text = "Security", fontSize = 24.sp)
                Spacer(modifier = Modifier.width(width =  226.dp))
                Icon(Icons.Outlined.ChevronRight, null)
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
                Text(text = "Dark mode", fontSize = 24.sp)
                Spacer(modifier = Modifier.width(width = 180.dp))
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