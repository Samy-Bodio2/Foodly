package com.example.foodly.screens.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
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
fun ProfileScreen(){
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        //Top With the world profile
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Profile", fontSize = 32.sp)
            Spacer(modifier = Modifier.size(24.dp))
            Icon(Icons.Rounded.Add,contentDescription = null)
        }

        //Avatar with Name and number
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {
            Image(painterResource(id = R.drawable.profil),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(40.dp))
                    .size(80.dp))
            Column()
            {
                Text(text = "Andrew Ainsley", fontSize = 32.sp)
                Text(text = "+1 111 467 378 399", fontSize = 24.sp)
            }

                Icon(Icons.Rounded.DriveFileRenameOutline, null)


        }

        //First part of the menu
        Column() {
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically){
                Icon(Icons.Rounded.CalendarMonth, null)
                Text(text = "My Favorite Restaurants", fontSize = 24.sp)
                Icon(Icons.Outlined.ChevronRight, null)
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically){
                Icon(Icons.Rounded.Wallet, null)
                Text(text = "Payment Methods", fontSize = 24.sp)
                Icon(Icons.Outlined.ChevronRight, null)
            }
        } 
        
        //Second Part of the menu
        Column() {
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Outlined.PersonOutline, null)
                Text(text = "Profile", fontSize = 24.sp)
                Icon(Icons.Outlined.ChevronRight, null)
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically){
                Icon(Icons.Outlined.LocationOn, null)
                Text(text = "Address", fontSize = 24.sp)
                Icon(Icons.Outlined.ChevronRight, null)
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Outlined.NotificationsNone, null)
                Text(text = "Notifications", fontSize = 24.sp)
                Icon(Icons.Outlined.ChevronRight, null)
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically){
                Icon(Icons.Outlined.GppGood, null)
                Text(text = "Security", fontSize = 24.sp)
                Icon(Icons.Outlined.ChevronRight, null)
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically){
                Row() {
                    Icon(Icons.Outlined.Casino, null)
                    Text(text = "Language", fontSize = 24.sp)
                }
                Row(horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "English (US)", fontSize = 24.sp)
                    Icon(Icons.Outlined.ChevronRight, null)
                }
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically){
                Icon(Icons.Outlined.RemoveRedEye, null)
                Text(text = "Dark mode", fontSize = 24.sp)
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Outlined.Logout, null, tint = Color.Red, modifier = Modifier.size(size = 24.dp))
                    Text(text = "Logout", color = Color.Red, fontSize = 24.sp)
            }
        }
    }

}