package com.example.foodly.model

import java.util.*

data class Customer(
    val first_name: String,
    val last_name: String,
    val username: String,
    val gender: String,
    val email: String,
    val phone_number: String,
    val address: String,
    val password: String,
    val start_date: Date
)

