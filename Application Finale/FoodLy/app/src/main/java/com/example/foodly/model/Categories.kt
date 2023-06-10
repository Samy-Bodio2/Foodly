package com.example.foodly.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.foodly.R
import com.example.foodly.utils.*

data class Categories(val name: String, val image: Int, val restaurantName: String)
/*{
    constructor() : this("","","")
}



val drinks : MutableState<MutableList<Categories?>> = mutableStateOf(readDrinks())
val alcohol : MutableState<MutableList<Categories?>> =  mutableStateOf(readAlcohol())
val tacos : MutableState<MutableList<Categories?>> = mutableStateOf(readDrinks())
val meat : MutableState<MutableList<Categories?>> =  mutableStateOf(readMeat())
val chicken : MutableState<MutableList<Categories?>> =  mutableStateOf(readChicken())
val traditional : MutableState<MutableList<Categories?>> =  mutableStateOf(readTraditionnal())
val pizza : MutableState<MutableList<Categories?>> =  mutableStateOf(readPizza())
val fish : MutableState<MutableList<Categories?>> =  mutableStateOf(readFish())
val vegetarian : MutableState<MutableList<Categories?>> =  mutableStateOf(readVegetarian())

 */

val drinks = listOf(
    Categories("Blue Lagoon Mockail", R.drawable.bluelagoon, "Friend Food"),
    Categories("Mango Pineapple Punch", R.drawable.mangopineapple, "Le Cedre"),
    Categories("Dulce De Leche Milkshake", R.drawable.milkshake, "Subway")
)

val alcohol = listOf(
    Categories("32 Whiskey Cocktails", R.drawable.whyskey, "RoofTop"),
    Categories("Jack Daniel", R.drawable.jackdaniel, "La Cave"),
    Categories("Hennessy Black", R.drawable.hennessy, "La Marquise")
)
val vegetarian = listOf(
    Categories("Grilled Asporagus", R.drawable.grilled, "Burger King"),
    Categories("Green Vegan Salad", R.drawable.grilled2, "Tim Hortons"),
    Categories("Ratatouille", R.drawable.ratatouille, "Panera Bread")
)
val pizza = listOf(
    Categories("17 Weird Pizza Crusts", R.drawable.pizzacrust, "Pizza Hut"),
    Categories("Cheese Pizza", R.drawable.cheesepizza, "Domino's"),
    Categories("Pepperoni and Buratta", R.drawable.peperoni, "Pizza Doree")
)
val chicken = listOf(
    Categories("Grilled Tandoori Chicken", R.drawable.tandori, "Friend Food"),
    Categories("Garlic Butter Chicken", R.drawable.butter, "Chick-fil-A"),
    Categories("Poulet roti", R.drawable.pouletroti, "4 Fourchette")
)
val meat = listOf(
    Categories("CowBoy Steak", R.drawable.steak, "Outback Steakhouse"),
    Categories("Beef Sirloin", R.drawable.beef, "Texas Roadhouse"),
    Categories("Pernil", R.drawable.pernil, "House Steak")
)
val traditional = listOf(
    Categories("Okok", R.drawable.okoks, "Fouquet"),
    Categories("Ndole", R.drawable.ndole, "Chez Meme"),
    Categories("Sauce Gombo", R.drawable.gombo, "Chez Margarite")
)
val tacos = listOf(
    Categories("Tacos Vegan Meat", R.drawable.tacosve, "Tacos Bell"),
    Categories("Ground Beef Tacos", R.drawable.beeftacos, "Friend Food"),
    Categories("Quinao Meat Taco", R.drawable.meattacos, "Cracker Barrel")
)
