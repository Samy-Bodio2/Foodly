package com.example.foodly.model

import androidx.annotation.DrawableRes
import com.example.foodly.R

data class Meal (
    val nom :String,
    val description: String,
    val prix: Int,
    val note : Float,
    @DrawableRes val image: Int
)


var mealList = listOf(
    Meal("Cheese Burger",
        "",
        3500,
        4.6f,
        R.drawable.burger2
    ),
    Meal("Cheese Burger",
        "",
        3500,
        4.6f,
        R.drawable.burger2
    ),
    Meal("Cheese Burger",
        "",
        3500,
        4.6f,
        R.drawable.burger2
    ),
    Meal("Cheese Burger",
        "",
        3500,
        4.6f,
        R.drawable.burger2
    ),
    Meal("Cheese Burger",
        "",
        3500,
        4.6f,
        R.drawable.burger2
    ),
    Meal("Cheese Burger",
        "",
        3500,
        4.6f,
        R.drawable.burger2
    ),
    Meal("Cheese Burger",
        "",
        3500,
        4.6f,
        R.drawable.burger2
    ),
    Meal("Cheese Burger",
        "",
        3500,
        4.6f,
        R.drawable.burger2
    )
)
