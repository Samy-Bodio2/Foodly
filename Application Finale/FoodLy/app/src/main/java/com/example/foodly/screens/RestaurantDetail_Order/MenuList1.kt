package com.example.foodly.screens.RestaurantDetail_Order

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.foodly.R
import com.example.foodly.navigation.Screen
import com.example.foodly.screens.Home_ActionMenu.AppBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MenuList1() {
    val navController = rememberNavController()
    LazyColumn(
    ){

        stickyHeader {
            AppBar(navController)
        }

        item {
            MenuItem(
                imagePainter = painterResource(id = R.drawable.eru),
                title = "Water Fufu and Eru",
                subtitle = "1.7 km | 4.6 (1.3k)",
                price = "$2.50",
                backgroundColor = Color.White,
                onButtonClick = { navController.navigate(Screen.RestaurantScreen.route) }
            )
        }

        item {
            MenuItem(
                imagePainter = painterResource(id = R.drawable.eru),
                title = "Water Fufu and Eru",
                subtitle = "1.7 km | 4.6 (1.3k)",
                price = "$2.50",
                backgroundColor = Color.White,
                onButtonClick = { navController.navigate(Screen.RestaurantScreen.route) }
            )
        }
    }

}

@Composable
fun MenuItem(title: String,
             subtitle: String,
             price: String,
             backgroundColor: Color,
             imagePainter: Painter,
             onButtonClick: () -> Unit
){
    val navController = rememberNavController()
    Card(
        Modifier
            .width(200.dp)
            .clickable(onClick = onButtonClick),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp,
    ){
        Row{
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clip(RoundedCornerShape(20.dp)),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = title,  color = Color.Black)
                Text(text = subtitle,  color = Color.Black, fontWeight = FontWeight.Bold)
                Text(text = price, color = Color.Black)
            }

        }
    }

}


@Composable
fun MenuItems(title: String,
              subtitle: String,
              price: String,
              backgroundColor: Color,
              imagePainter: Painter
){
    val navController = rememberNavController()
    Card(
        Modifier
            .width(200.dp),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp,
    ){
        Row{
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clip(RoundedCornerShape(20.dp)),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = title,  color = Color.Black)
                Text(text = subtitle,  color = Color.Black, fontWeight = FontWeight.Bold)
                Text(text = price, color = Color.Black)
            }

        }
    }

}