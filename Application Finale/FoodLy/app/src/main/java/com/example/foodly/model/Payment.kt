package com.example.foodly.model

class Payment(
    val amount: Double,
    val currency: String,
    val intent: String,
    val description: String,
    val invoiceNumber: String
)