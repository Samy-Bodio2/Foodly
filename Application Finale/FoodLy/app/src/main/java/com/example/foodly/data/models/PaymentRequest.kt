package com.example.foodly.data.models
data class PaymentRequest(
    val currency: String,
    val amount: Long,
    val description: String,
    val email: String
)


