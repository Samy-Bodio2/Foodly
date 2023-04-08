package com.example.foodly.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodly.model.*

@Composable
fun DetailsMenu(
    meal: Meal,
    restaurant: Restaurant
//    onRestaurantSelected: (Restaurant) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(meal.image),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = meal.nom,
            style = MaterialTheme.typography.h6
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Restaurant : ${restaurant.nom}",
            style = MaterialTheme.typography.body1
//            modifier = Modifier.clickable { onRestaurantSelected(restaurant) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = meal.description,
            style = MaterialTheme.typography.body1
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Prix : ${meal.prix} f CFA",
            style = MaterialTheme.typography.body1
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Note : ${meal.note}/5",
            style = MaterialTheme.typography.body1
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Description du restaurant :",
            style = MaterialTheme.typography.subtitle1
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = restaurant.description,
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview
@Composable
fun Preview(){
    DetailsMenu(menu1, resto)
}