package com.example.foodly.commander

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.foodly.R
import androidx.navigation.NavHostController

fun getFoods(category: String): List<String> {
    return when (category) {
        "Pizza" -> listOf("Margherita", "Pepperoni", "Hawaïenne")
        "Hamburger" -> listOf("Cheeseburger", "Végétarien", "Double")
        "Salade" -> listOf("César", "Nicoise", "Grecque")
        else -> emptyList()
    }
}
@Composable
fun FoodOrderScreen(navController : NavHostController) {
    // Déclaration des variables pour les éléments de l'interface utilisateur

//    var selectedIndex by remember { mutableStateOf(0) }
    var selectedFood by remember { mutableStateOf("") }
    var elem by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf(0) }
    var expanded by remember { mutableStateOf(false) }
    var expanded1 by remember { mutableStateOf(false) }
    var list = listOf("Pizza", "Hamburger", "Salade")
    var selectedFood1 : List<String> = listOf("")
    var enabled by remember { mutableStateOf(false) }
    // var selectedCategory by remember { mutableStateOf(list) }
    var selectedItem by remember { mutableStateOf("")}
    var textFiledSize by remember { mutableStateOf(Size.Zero)}
    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    val icon2 = if (expanded1){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    Column(modifier = Modifier.padding(20.dp)) {

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
        OutlinedTextField(value = selectedItem, onValueChange = {selectedItem = it},
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->//
                    textFiledSize = coordinates.size.toSize()
                },
            label = {Text(text = "selected item")},//
            trailingIcon = {
                Icon(icon,"",Modifier.clickable{expanded = !expanded})
            })

        DropdownMenu(expanded = expanded,
            onDismissRequest = { expanded = false },//
            modifier = Modifier
                .width(with(LocalDensity.current){textFiledSize.width.toDp()})//
        ) {
            list.forEach { label ->
                DropdownMenuItem(onClick = { selectedItem = label
                    selectedFood1 = getFoods(selectedItem)
                    selectedFood = selectedFood1[0];
                    expanded = false
                    enabled = true
                }) {
                    Text(text = label)
                }
            }
        }


        // Sélection de la nourriture
        Text(
            text = "Sélectionnez une nourriture :",
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
        )
        OutlinedTextField(value = selectedFood, onValueChange = {selectedFood = it},
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->//
                    textFiledSize = coordinates.size.toSize()
                },
            label = {Text(text = "selected food")},//
            trailingIcon = {
                Icon(icon2,"",Modifier.clickable(enabled = enabled){expanded1 = !expanded1}
                )
            })
        DropdownMenu(
            expanded = expanded1,
            onDismissRequest = { expanded = false},
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            val foods = getFoods(selectedItem)
            foods.forEach { food ->
                DropdownMenuItem(onClick = { selectedFood = food
                    expanded1 = false}) {
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
            IconButton(onClick = { if (quantity > 0) quantity-- }) {
                Icon(Icons.Default.Delete, contentDescription = "Ajouter")
            }
            Text(text = quantity.toString(), fontSize = 16.sp, modifier = Modifier.width(32.dp))
            IconButton(onClick = { quantity++ }) {
                Icon(Icons.Default.Add, contentDescription = "Ajouter")
            }
        }


        // Bouton pour passer la commande
        Button(
            onClick = { placeOrder(selectedItem, selectedFood, quantity) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Commander")
        }
    }
}
// Fonction qui renvoie les aliments pour une catégorie donnée

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
            .height(38.dp)//////////
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