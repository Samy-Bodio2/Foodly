package com.example.foodly.screens.e_wallet

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.foodly.model.PopularRestaurant
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.foodly.R
import com.example.foodly.ui.theme.LightGreen2
import java.text.SimpleDateFormat
import java.util.*

val currentTime = SimpleDateFormat("MMM d,yyyy | HH:mm a", Locale.getDefault()).format(Date())

val testList = listOf(
    PopularRestaurant(
        name = "Big Garden Salad",
        date = currentTime,
        argent = "$21,20",
        order = "Orders",
        coverImage = R.drawable.ekwang
    ),
    PopularRestaurant(
        name = "Top Up E-Wallet",
        date = currentTime,
        argent = "$41,23",
        order = "Top Up",
        coverImage = R.drawable.ekwang

    ),
    PopularRestaurant(
        name = "Vegetable Salad",
        date = currentTime,
        argent = "$28,00",
        order = "Orders",
        coverImage = R.drawable.ekwang
    ),
    PopularRestaurant(
        name = "Vegetable Salad",
        date = currentTime,
        argent = "$28,00",
        order = "Orders",
        coverImage = R.drawable.ekwang
    ),
    PopularRestaurant(
        name = "Top Up E-Wallet",
        date = currentTime,
        argent = "$41,23",
        order = "Top Up",
        coverImage = R.drawable.ekwang

    ),
)


@Suppress("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EWalletScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.width(16.dp))
                        Icon(
                            painterResource(id = R.drawable.heavy_dollar_sign_48px),
                            contentDescription = "E-Wallet Icon",
                            modifier = Modifier.size(32.dp),
                            tint = Green
                        )
                        Text(
                            text = "E-Wallet",
                            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                            color = Black,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                },
                backgroundColor = Color.White,
                navigationIcon = null,
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { /* Do Something */ }) {
                            Icon(Icons.Filled.Search, contentDescription = "Search")
                        }
                        IconButton(onClick = { /* Do Something */ }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    }
                },
                elevation = 0.dp
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(
                        color = LightGreen2,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row{
                        Column() {
                            Text(
                                text = "Andrew Ainsley",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "**** **** **** 3629",
                                fontSize = 15.sp,
                                color = Color.Gray
                            )
                        }
                        Spacer(modifier = Modifier.width(110.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier.width(3000.dp).height(80.dp)) {
                                Image(
                                    painter = painterResource(id = R.drawable.visa),
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                        }

                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Your balance",
                            fontSize = 10.sp,
                            color = Color.Gray
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "$9,379",
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(60.dp))
                        Button(
                            onClick = { /* TODO */ },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                Color.White,
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .height(40.dp)
                                .padding(start = 16.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.shop),
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier.size(10.dp)
                            )
                            Text(
                                text = "Top Up",
                                modifier = Modifier.padding(start = 8.dp),
                                color = Color.Black
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = "Transaction History",
                    color = Black,
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.width(110.dp))
                TextButton(
                    onClick = {
                        navController.navigate("TransactionHistoryScreen") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                ) {
                    Text(
                        text = "See All",
                        color = LightGreen2
                    )
                    Icon(
                        imageVector = Icons.Outlined.KeyboardArrowRight,
                        contentDescription = "Localized description",
                        modifier = Modifier.padding(end = 8.dp),
                        tint = LightGreen2
                    )
                }
            }
            PopularRestaurantList(testList)
        }
    }
}


@Composable
fun PopularRestaurantList(testList: List<PopularRestaurant>) {
    LazyColumn {
        items(testList) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Image(
                    painter = painterResource(item.coverImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Row(){
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                    ) {
                        Text(text = item.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(text = item.date, color = Color.Gray, fontSize = 12.sp)
                    }
                    //Spacer(modifier = Modifier.width(80.dp))
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .align(Alignment.CenterVertically)
                    ) {

                        Column( modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .align(Alignment.Center)) {

                            Text(text = item.argent, color = Black, fontSize = 20.sp,fontWeight = FontWeight.Bold,modifier = Modifier.offset(x=25.dp))
                            Spacer(modifier = Modifier.height(5.dp))
                            Row() {
                                Spacer(modifier = Modifier.width(1.dp))
                                Text(
                                    text = item.order,
                                    style = MaterialTheme.typography.subtitle1,
                                    modifier = Modifier.padding(start = 28.dp)
                                )

                                Image(
                                    painter = painterResource(if (item.order == "Orders") R.drawable.upe else R.drawable.down),
                                    contentDescription = null,
                                    modifier = Modifier.size(15.dp)
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}

