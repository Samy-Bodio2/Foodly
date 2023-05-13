package com.example.foodly.model

import java.util.*

data class Customer(
    val username: String,
    val email: String,
    val phone_number: String,
    val password: String,
    val start_date: Date
)

