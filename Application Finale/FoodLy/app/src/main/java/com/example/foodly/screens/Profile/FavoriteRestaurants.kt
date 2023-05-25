package com.example.foodly.screens.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodly.R
import com.example.foodly.navigation.Screen
import com.example.foodly.ui.theme.Yellow500
import com.example.foodly.ui.theme.white

@Composable
fun FavoriteRestaurants(navController: NavController) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Gray)) {
        item {
            TopAppBar(
                title = { Text("My Favorite Restaurant") },
                actions = {
                    IconButton(onClick = {  }) {
                        Icon(Icons.Rounded.Search, contentDescription = null)
                    }
                },
                navigationIcon = {IconButton(onClick = { navController.navigate(Screen.ProfileScreen.route) }) {
                    Icon(Icons.Rounded.ArrowBack, contentDescription = null)
                }},
                backgroundColor = White
            )
        }
        item{
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(200.dp)
                    .background(White, shape = RoundedCornerShape(30.dp)),
            ) {
                Image(
                    painter = painterResource(R.drawable.food),
                    contentDescription = "The Breakfast Club",
                    Modifier
                        .align(Alignment.CenterStart)
                        .size(150.dp)
                        .clip(CircleShape)
                )
                Column(
                    Modifier
                        .padding(start = 160.dp, top = 16.dp)
                ) {
                    Text("The Breakfast Club", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row() {
                        Text("1.4 km | ", fontSize = 20.sp)
                        Icon(Icons.Filled.Star, contentDescription = null, tint = Yellow500)
                        Text(" 4.7 (1.7k)" ,fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Favorite, contentDescription = "Favorite", tint = Color.Green)
                        Text("2000 FCFA",fontSize = 20.sp)
                    }
                }
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    Modifier
                        .padding(bottom = 32.dp)
                        .size(30.dp)
                        .clickable { /* Do something */ },
                    tint = Red
                )
            }
        }

        item{
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(200.dp)
                    .background(White, shape = RoundedCornerShape(30.dp)),
            ) {
                Image(
                    painter = painterResource(R.drawable.food),
                    contentDescription = "The Breakfast Club",
                    Modifier
                        .align(Alignment.CenterStart)
                        .size(150.dp)
                        .clip(CircleShape)
                )
                Column(
                    Modifier
                        .padding(start = 160.dp, top = 16.dp)
                ) {
                    Text("The Breakfast Club", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row() {
                        Text("1.4 km | ", fontSize = 20.sp)
                        Icon(Icons.Filled.Star, contentDescription = null, tint = Yellow500)
                        Text(" 4.7 (1.7k)" ,fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Favorite, contentDescription = "Favorite", tint = Color.Green)
                        Text("2000 FCFA",fontSize = 20.sp)
                    }
                }
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    Modifier
                        .padding(bottom = 32.dp)
                        .size(30.dp)
                        .clickable { /* Do something */ },
                    tint = Red
                )
            }
        }

        item{
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(200.dp)
                    .background(White, shape = RoundedCornerShape(30.dp)),
            ) {
                Image(
                    painter = painterResource(R.drawable.food),
                    contentDescription = "The Breakfast Club",
                    Modifier
                        .align(Alignment.CenterStart)
                        .size(150.dp)
                        .clip(CircleShape)
                )
                Column(
                    Modifier
                        .padding(start = 160.dp, top = 16.dp)
                ) {
                    Text("The Breakfast Club", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row() {
                        Text("1.4 km | ", fontSize = 20.sp)
                        Icon(Icons.Filled.Star, contentDescription = null, tint = Yellow500)
                        Text(" 4.7 (1.7k)" ,fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Favorite, contentDescription = "Favorite", tint = Color.Green)
                        Text("2000 FCFA",fontSize = 20.sp)
                    }
                }
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    Modifier
                        .padding(bottom = 32.dp)
                        .size(30.dp)
                        .clickable { /* Do something */ },
                    tint = Red
                )
            }
        }

        item{
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(200.dp)
                    .background(White, shape = RoundedCornerShape(30.dp)),
            ) {
                Image(
                    painter = painterResource(R.drawable.food),
                    contentDescription = "The Breakfast Club",
                    Modifier
                        .align(Alignment.CenterStart)
                        .size(150.dp)
                        .clip(CircleShape)
                )
                Column(
                    Modifier
                        .padding(start = 160.dp, top = 16.dp)
                ) {
                    Text("The Breakfast Club", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row() {
                        Text("1.4 km | ", fontSize = 20.sp)
                        Icon(Icons.Filled.Star, contentDescription = null, tint = Yellow500)
                        Text(" 4.7 (1.7k)" ,fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Favorite, contentDescription = "Favorite", tint = Color.Green)
                        Text("2000 FCFA",fontSize = 20.sp)
                    }
                }
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    Modifier
                        .padding(bottom = 32.dp)
                        .size(30.dp)
                        .clickable { /* Do something */ },
                    tint = Red
                )
            }
        }

        item{
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(200.dp)
                    .background(White, shape = RoundedCornerShape(30.dp)),
            ) {
                Image(
                    painter = painterResource(R.drawable.food),
                    contentDescription = "The Breakfast Club",
                    Modifier
                        .align(Alignment.CenterStart)
                        .size(150.dp)
                        .clip(CircleShape)
                )
                Column(
                    Modifier
                        .padding(start = 160.dp, top = 16.dp)
                ) {
                    Text("The Breakfast Club", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row() {
                        Text("1.4 km | ", fontSize = 20.sp)
                        Icon(Icons.Filled.Star, contentDescription = null, tint = Yellow500)
                        Text(" 4.7 (1.7k)" ,fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Favorite, contentDescription = "Favorite", tint = Color.Green)
                        Text("2000 FCFA",fontSize = 20.sp)
                    }
                }
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    Modifier
                        .padding(bottom = 32.dp)
                        .size(30.dp)
                        .clickable { /* Do something */ },
                    tint = Red
                )
            }
        }

        item{
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(200.dp)
                    .background(White, shape = RoundedCornerShape(30.dp)),
            ) {
                Image(
                    painter = painterResource(R.drawable.food),
                    contentDescription = "The Breakfast Club",
                    Modifier
                        .align(Alignment.CenterStart)
                        .size(150.dp)
                        .clip(CircleShape)
                )
                Column(
                    Modifier
                        .padding(start = 160.dp, top = 16.dp)
                ) {
                    Text("The Breakfast Club", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row() {
                        Text("1.4 km | ", fontSize = 20.sp)
                        Icon(Icons.Filled.Star, contentDescription = null, tint = Yellow500)
                        Text(" 4.7 (1.7k)" ,fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Favorite, contentDescription = "Favorite", tint = Color.Green)
                        Text("2000 FCFA",fontSize = 20.sp)
                    }
                }
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    Modifier
                        .padding(bottom = 32.dp)
                        .size(30.dp)
                        .clickable { /* Do something */ },
                    tint = Red
                )
            }
        }
    }
}