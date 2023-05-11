package com.example.foodly.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.foodly.R
import com.example.foodly.model.Meal
import com.example.foodly.model.menu1
import com.example.foodly.model.resto

@Composable
fun MealList(meals: List<Meal>) {
    LazyColumn {
        items(meals) { meal ->
            MealCard(meal = meal)
        }
    }
}

@Composable
fun MealCard(meal: Meal) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pommes),
                contentDescription = meal.nom,
                modifier = Modifier
                    .size(128.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = meal.nom, style = MaterialTheme.typography.h5)
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
//                    Text(text = meal.restaurant, style = MaterialTheme.typography.caption)
                }
                Text(text = "${meal.prix}f CFA", style = MaterialTheme.typography.subtitle1)
                Text(text = meal.description, style = MaterialTheme.typography.body1)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun Preview1(){
    //DetailsMenu(menu1, resto)
    MealCard(meal = menu1)

}