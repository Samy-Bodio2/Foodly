package com.example.foodly.commander

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodly.R
import androidx.navigation.NavHostController

@Composable
fun FoodOrderScreen(navController : NavHostController) {
    // Déclaration des variables pour les éléments de l'interface utilisateur
    var selectedCategory by remember { mutableStateOf("Pizza") }
    var selectedFood by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf(1) }



    Column(modifier = Modifier.fillMaxSize()) {
        // Affichage du titre
        Text(
            text = "Commander votre repas",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        // Sélection de la catégorie
        Text(
            text = "Sélectionnez une catégorie :",
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
        )

        DropdownMenu(
            expanded = false,
            onDismissRequest = { },
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            listOf("Pizza", "Hamburger", "Salade").forEach { category ->
                DropdownMenuItem(onClick = { selectedCategory = category }) {
                    Text(text = category)
                }
            }
        }

        // Sélection de la nourriture
        Text(
            text = "Sélectionnez une nourriture :",
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
        )

        DropdownMenu(
            expanded = false,
            onDismissRequest = { },
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            val foods = getFoods(selectedCategory)
            foods.forEach { food ->
                DropdownMenuItem(onClick = { selectedFood = food }) {
                    Text(text = food)
                }
            }
        }

        // Sélection de la quantité
        Text(
            text = "Sélectionnez la quantité :",
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
        )

        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            IconButton(onClick = { if (quantity > 1) quantity-- }) {
                Icon(R.drawable.subtract_32px)
            }
            Text(text = quantity.toString(), fontSize = 16.sp, modifier = Modifier.width(32.dp))
            IconButton(onClick = { quantity++ }) {
                Icon(Icons.Default.Add, contentDescription = "Ajouter")
            }
        }


        // Bouton pour passer la commande
        Button(
            onClick = { placeOrder(selectedCategory, selectedFood, quantity) },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text(text = "Commander")
        }
    }
}
// Fonction qui renvoie les aliments pour une catégorie donnée
fun getFoods(category: String): List<String> {
    return when (category) {
        "Pizza" -> listOf("Margherita", "Pepperoni", "Hawaïenne")
        "Hamburger" -> listOf("Cheeseburger", "Végétarien", "Double")
        "Salade" -> listOf("César", "Nicoise", "Grecque")
        else -> emptyList()
    }
}
@Composable
fun Icon(
    @DrawableRes iconResouce: Int,
    color: Color = White,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(),
//        shape = Shapes.small,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red, contentColor = color),
        elevation = elevation,
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
    ) {
        Icon(painterResource(id = iconResouce), null)
    }
}

// Fonction pour passer une commande
fun placeOrder(category: String, food: String, quantity: Int) {
    // Code pour passer une commande
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewPasswordTextFields() {
//    FoodOrderScreen()
//}