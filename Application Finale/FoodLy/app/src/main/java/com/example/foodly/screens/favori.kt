package com.example.foodly.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodly.R
import com.example.foodly.model.Meal
import com.example.foodly.model.menu1
import com.example.foodly.model.resto

@Composable
fun FavoritesScreen(meals: List<Meal>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Favoris")
                }
            )
        },
    ) {it
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(meals) { meal ->
                FavoriteItem(meal = meal)
            }
        }
    }
}

@Composable
fun FavoriteItem(meal: Meal) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.surface,
        shape = MaterialTheme.shapes.small,
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Afficher l'image du produit
            Image(
                painter = painterResource(R.drawable.brochette),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
            )
            // Afficher le nom et la description du produit
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = meal.nom,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = meal.description,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }

            Row() {
                // Afficher le prix du produit
                Text(text = "${meal.prix}f CFA",
                    style = MaterialTheme.typography.subtitle1)
            }
        }
    }
}

@Preview
@Composable
fun PreviewFavorite(){
    FavoriteItem(meal = menu1)
}