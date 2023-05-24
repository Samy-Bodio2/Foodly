package com.example.foodly.utils

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.foodly.navigation.Screen
import com.example.foodly.viewmodels.PaymentViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

@Composable
fun PaymentScreen(viewModel: PaymentViewModel ) {
    var currency by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf(0L) }
    var description by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = currency,
            onValueChange = { currency = it },
            label = { Text("Currency") }
        )
        OutlinedTextField(
            value = amount.toString(),
            onValueChange = { amount = it.toLongOrNull() ?: 0 },
            label = { Text("Amount") }
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") }
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )
        Button(onClick = {
            viewModel.viewModelScope.launch {
                val paymentResponse = viewModel.initializePayment(currency, amount, description, email)
                // Do something with the payment response
            }
        }) {
            Text("Pay")
        }
    }
}