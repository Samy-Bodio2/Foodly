package com.example.foodly.model

import androidx.annotation.DrawableRes
import com.example.foodly.R

data class Meal (
        val nom :String,
        val description: String,
        val prix: Int,
        val note : Int,
        val restaurant: Restaurant,
        @DrawableRes val image: Int
        )

val resto = Restaurant(nom = "tchop tchop", "Vos meilleures plats traditionels")

var menu1 = Meal(
        nom = "Pommes pilés",
        description = "Bon plat traditionel Bamileke",
        prix = 3000,
        note = 8,
        restaurant = resto,
        image = R.drawable.pommes
)
