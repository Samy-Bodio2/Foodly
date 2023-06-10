package com.example.foodly.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.foodly.data.models.Paiement
import com.example.foodly.di.effectuerPaiement

@Composable
fun FormulairePaiement(onPaiementEffectué: () -> Unit) {
    var montant by remember { mutableStateOf("") }
    var devise by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = montant,
            onValueChange = { montant = it },
            label = { Text("Montant") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        TextField(
            value = devise,
            onValueChange = { devise = it },
            label = { Text("Devise") }
        )

        Button(
            onClick = {
                val paiement = Paiement(montant.toDouble(), devise)
                val paiementEffectué = effectuerPaiement(paiement)
                if (paiementEffectué) {
                    onPaiementEffectué()
                }
            },
            Modifier.padding(vertical = 16.dp)
        ) {
            Text("Effectuer le paiement")
        }
    }
}