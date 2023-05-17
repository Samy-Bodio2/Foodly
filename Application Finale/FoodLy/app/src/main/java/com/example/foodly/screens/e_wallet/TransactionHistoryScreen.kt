package com.example.foodly.screens.e_wallet


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.foodly.R
import java.text.SimpleDateFormat
import com.example.foodly.model.PopularRestaurant
import java.util.*

val currentTime2 = SimpleDateFormat("MMM d,yyyy | HH:mm a", Locale.getDefault()).format(Date())

val testList2 = listOf(
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
    PopularRestaurant(
        name = "Vegetable Salad",
        date = currentTime,
        argent = "$28,00",
        order = "Orders",
        coverImage = R.drawable.ekwang
    ),
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
fun TransactionHistoryScreen(navController : NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("EWalletScreen") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Retour"
                        )
                    }
                },
                title = {
                    Text(
                        text = "Transaction History",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    IconButton(onClick = { /* Lancer la recherche */ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Recherche"
                        )
                    }
                }
            )
        }
    ){
        Column {
            PopularRestaurant2(testList2)
        }

    }
}
@Composable
fun PopularRestaurant2(testList2: List<PopularRestaurant>) {
    LazyColumn {
        items(testList2) { item ->
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
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                ) {
                    Text(text = item.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text(text = item.date, color = Color.Gray, fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.width(100.dp))
                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Column( modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .align(Alignment.Center)) {
                        Text(text = item.argent, color = Color.Black, fontSize = 20.sp,fontWeight = FontWeight.Bold,modifier = Modifier.offset(x=25.dp))
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