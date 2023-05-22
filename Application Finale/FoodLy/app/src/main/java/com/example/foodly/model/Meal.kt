package com.example.foodly.model

import androidx.annotation.DrawableRes
import com.example.foodly.R

data class Meal (
    val nom :String,
    val description: String,
    val note: Int,
    val quantite: Int,
    val prix : Float,
    @DrawableRes val image: Int
)




var mealList = listOf(
    Meal("Cheese Burger",
        "",
        3500,
        0,
        4.6f ,
        R.drawable.burger2 ,

    ),
    Meal("Cheese Burger",
        "",
        3500,
        0,
        4.6f ,
        R.drawable.burger2 ,

    ),
    Meal("Cheese Burger",
        "",
        3000,
        0,
        4.6f,
        R.drawable.burger2,

    ),
    Meal("Cheese Burger",
        "",
        3000,
        0,
        4.6f,
        R.drawable.burger2,

    ),
    Meal("Cheese Burger",
        "",
        3500,
        2,
        4.6f ,
        R.drawable.burger2,
    ),
    Meal("Cheese Burger",
        "",
        3500,
        3,
        4.6f,
        R.drawable.burger2
    ),
    Meal("Cheese Burger",
        "",
         2,
        3500,
        4.6f,
        R.drawable.burger2
    ),
    Meal("Cheese Burger",
        "",
1,
        3500,
        4.6f,
        R.drawable.burger2
    )
)


var cartList = listOf(
    Meal("Hamburger",
        "",
        3500,
        1,
        4.6f ,

        R.drawable.hamburger_48px
    ),
    Meal("creme glace",
        "",
        3500,
        1,
        4.6f,
        R.drawable.icecream
    ),
    Meal("Okok",
        "",
        3500,
        1,
        4.6f,
        R.drawable.okok
    ),
    Meal("Salade",
        "",
        3500,
        1 ,
        4.6f,
        R.drawable.salad
    ),
    Meal("pizza",
        "",
        3500,
        2,
        4.6f,
        R.drawable.pizza
    ),
    Meal("pile pomme",
        "",
        3500,
        1,
        4.6f,
        R.drawable.pile
    ),
    Meal("burger",
        "",
        3500,
        2,
        4.6f,
        R.drawable.hamburger_48px
    ),
    Meal("Brochette de porc",
        "",
        3500,
        1,
        4.6f,
        R.drawable.brochette
    ),
)


