package com.example.foodly.data.models

data class PaymentResponse(
    val transactionReference: String,
    val authorizationUrl: String
)