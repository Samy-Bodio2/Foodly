package com.example.foodly.screens.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowLeft
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodly.R
import com.example.foodly.navigation.Screen

@Composable
fun FullFavoriteRestaurant(){

}

@Composable
fun EmptyFavoriteRestaurant(){

}


@Composable
fun TopBarFavoriteRestaurants(navController: NavController){
    Row {
        Icon(Icons.Outlined.ArrowLeft, null)
        Text(text = "My Favorite Restaurants", fontSize = 32.sp)
        Icon(Icons.Outlined.Search, contentDescription = null)
    }
}

@Composable
fun FavoriteRestaurantItem(){
    Box(){
        Row{
            Box(
                modifier = Modifier
                    .height(135.dp)
                    .width(50.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(R.drawable.mon_repas_image),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(40.dp))
                )
            }

            Column(){
                Text(text = "The Breakfast club")
                Spacer(modifier = Modifier.height(20.dp))
                Row(){
                    Text(text = "1.4km")
                    Text(text = "|")
                    Text(text = "4.7 (1.7k)")
                }
                Row(){
                    Text(text = "$2.50")
                }
            }
        }
    }
}