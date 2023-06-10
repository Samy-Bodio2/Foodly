package com.example.foodly.screens.Chat

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodly.R
import com.example.foodly.screens.Orders.ActiveOrders
import com.example.foodly.screens.Orders.CancelledOrders
import com.example.foodly.screens.Orders.CompletedOrders
import com.example.foodly.ui.theme.LightGreen
import kotlinx.coroutines.delay
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChatScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Messages") },
            actions = {
                IconButton(onClick = { /* Action de recherche */ }) {
                    Icon(Icons.Filled.Search, contentDescription = "Rechercher")
                }
                IconButton(onClick = { /* Action moreHorizontal */ }) {
                    Icon(Icons.Default.MoreHoriz, contentDescription = "More Horizontal")
                }
            },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Message, contentDescription = null )
                }
            },
            backgroundColor = Color.White
        )
        CategoryTab(navController)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun getCurrentTime(): String {
    val currentTime = LocalTime.now()
    return "${currentTime.hour}:${currentTime.minute}"
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DiscussionItem(profil: Int, name: String, message: String, ) {
    val currentTime = getCurrentTime()
    Column() {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable(onClick = { /* Action pour ouvrir la discussion */ })) {
            Image(painter = painterResource(id = profil),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape))
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp)
                Text(text = message,
                    color = Color.Gray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis)
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(modifier = Modifier
                .padding(horizontal = 8.dp)
                .align(Alignment.CenterVertically)) {
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(LightGreen)) {
                    Text(text = "2", color = Color.White, fontSize = 14.sp)
                }
                Text(text = "$currentTime", color = Color.Gray, fontSize = 12.sp)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CategoryTab(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }
    val categories = listOf("Chats", "Calls")
    val colors = listOf(
        LightGreen,
        LightGreen
    )

    TabRow(selectedTabIndex = selectedIndex, backgroundColor = Color.White) {
        categories.forEachIndexed { index, category ->
            Tab(
                text = { Text(text = category, color = if (index == selectedIndex) colors[index] else Color.Gray) },
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                selectedContentColor = LightGreen,
                unselectedContentColor = LightGreen,

                )
        }
    }

    when (selectedIndex) {
        0 -> Chats()
        1 -> Calls()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Chats() {
    Column() {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item{
                DiscussionItem(R.drawable.jason,"Jason Kamsu", "Salut Toi ")
                DiscussionItem(R.drawable.joyce,"Joyce Steffie", "Rejoins moi a Cold Stone ")
                DiscussionItem(R.drawable.leila,"Leila Tanko", "Salut Jay")
                DiscussionItem(R.drawable.crispin,"Tatsinkou Crispin", "Yo poto ")
                DiscussionItem(R.drawable.dylan,"Dylan Kamsu", "Yo bro ")
                DiscussionItem(R.drawable.roussel,"Roussel Elliette", "Salut Jason ")
                DiscussionItem(R.drawable.angele,"Angele Nguiakam", "Salut Jordan")
            }
        }
    }

}

@Composable
fun Calls() {
    Column() {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(10) { index -> CallsItem(index) }
        }
    }
}

@Composable
fun CallsItem(index: Int ) {
    Column() {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable(onClick = { /* Action pour ouvrir la discussion */ })
        ) {
            Image(
                painter = painterResource(id = R.drawable.profil),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = "Jason Kamsu",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "Manqué",
                    color = Color.Gray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Row() {
                    Text(text = "Hier", color = Color.Gray, fontSize = 12.sp)
                    Column() {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                        ) {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icons.Filled.Help
                            }
                        }
                    }

                }
            }
        }
    }
}

