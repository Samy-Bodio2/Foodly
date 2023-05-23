package com.example.foodly.viewmodels

import androidx.lifecycle.ViewModel
import com.example.foodly.data.PayementApi
import com.example.foodly.data.models.PaymentRequest
import com.example.foodly.data.models.PaymentResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val paymentApi: PayementApi
) : ViewModel() {

    suspend fun initializePayment(currency: String, amount: Long, description: String, email: String): PaymentResponse {
        val paymentRequest = PaymentRequest(currency, amount, description, email)
        return paymentApi.initializePayment(paymentRequest)
    }
}