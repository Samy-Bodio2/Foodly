package com.example.foodly.utils

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import kotlin.random.Random

@Composable
fun RestaurantMenuCard(restaurant: DocumentSnapshot, menu: QuerySnapshot) {
    Card(
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = rememberImagePainter(menu.documents.first().getString("image")),
                contentDescription = null,
                modifier = Modifier.aspectRatio(1.5f)
            )
            Text(
                text = restaurant.getString("name") ?: "",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 0.dp)
            )
            LazyColumn(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(menu.documents) { menuItem ->
                    MenuItemCard(menuItem)
                }
            }
        }
    }
}

@Composable
fun MenuItemCard(menuItem: DocumentSnapshot) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = rememberImagePainter(menuItem.getString("image")),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
            Column(
                modifier = Modifier.weight(1f).padding(start = 16.dp)
            ) {
                Text(
                    text = menuItem.getString("name") ?: "",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "€" + menuItem.getDouble("price").toString(),
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = menuItem.getString("description") ?: "",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun RestaurantMenuList() {
    val firestore = FirebaseFirestore.getInstance()
    val restaurantsCollection = firestore.collection("Restaurants")
    val menusCollection = firestore.collection("Menus")

    var restaurantsState by remember { mutableStateOf(emptyList<DocumentSnapshot>()) }

    LaunchedEffect(restaurantsCollection) {
        val snapshot = restaurantsCollection.get().await()
        snapshot.documents.forEach { restaurant ->
            val menuSnapshot =
                menusCollection.whereEqualTo("restaurantId", restaurant.id).get().await()
            if (menuSnapshot.documents.isNotEmpty()) {
                // Only show restaurants with menus
                restaurantsState += restaurant
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRestaurantMenuList() {
    RestaurantMenuList()
}
