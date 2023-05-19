package com.example.foodly.screens.Orders

import androidx.annotation.DrawableRes
import com.example.foodly.R


data class Meal (
    val nom :String,
    val description: String,
    val note: String,
    val prix : Float,
    @DrawableRes val image: Int
)

var mealLists = listOf(
    Meal("Zero Zero Noodles",
        "",
        "4 items | 2.7 km" ,
        22.00f,
        R.drawable.image3
    ),
)
var mealListsT3 = listOf(
    Meal("Eats Meets West",
        "",
        "2 items | 1.9km",
        20.50f,
        R.drawable.salade1
    ),

)
var mealLists3 = listOf(
    Meal("Gardenica Salad",
        "",
        "3 item | 2.2 km",
        27.00f,
        R.drawable.salad
    ),
)
