package com.example.foodly.data

import com.example.foodly.data.models.PaymentRequest
import com.example.foodly.data.models.PaymentResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface PayementApi {
    @POST("payments/initialize")
    suspend fun initializePayment(@Body paymentRequest: PaymentRequest): PaymentResponse
}