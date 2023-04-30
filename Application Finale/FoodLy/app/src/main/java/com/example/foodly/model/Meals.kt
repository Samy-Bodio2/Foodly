package com.example.foodly.model

data class Meals(val name: String, val price: Double, var quantity: Int)

val meals = listOf(
    Meals("Hamburger", 5.99, 2),
    Meals("Pizza", 8.99, 1),
    Meals("Sushi", 12.99, 3)
)
