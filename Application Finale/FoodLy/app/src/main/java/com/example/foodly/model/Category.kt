package com.example.foodly.model

import androidx.annotation.DrawableRes
import com.example.foodly.R

data class Category(
    val name: String,
    @DrawableRes val image: Int
)

val categories = listOf(
    Category("Hamburger double cheese", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Brochette", R.drawable.brochette),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger),
    Category("Hamburger", R.drawable.burger)
)