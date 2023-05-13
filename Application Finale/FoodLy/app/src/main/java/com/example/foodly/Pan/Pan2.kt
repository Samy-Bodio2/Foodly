package com.example.foodly.Pan

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.foodly.navbar.CustomBottomNavigation
import com.example.foodly.navbar.TopBar
/*
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Pan2() {
    var produit by remember { mutableStateOf("") }
    var prix by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ajouter au panier") },
                navigationIcon = {
                    IconButton(onClick = { /* Retour en arrière */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Retour")
                    }
                }
            )
        }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            OutlinedTextField(
                value = produit,
                onValueChange = { produit = it },
                label = { Text("Produit") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = prix,
                onValueChange = { prix = it },
                label = { Text("Prix") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(
                    onClick = {
                        val montant = prix.toIntOrNull()
                        if (montant != null && produit.isNotBlank()) {
                            // Ajouter produit au panier
                            // Code pour enregistrer le produit dans la liste du panier ou dans la base de données
                            // Afficher un message de confirmation à l'utilisateur
                        } else {
                            // Afficher un message d'erreur à l'utilisateur
                        }
                    }
                ) {
                    Icon(Icons.Default.AddShoppingCart, contentDescription = "Ajouter au panier")
                }
            }
        }
    }
}

@Composable
@Preview
fun compil() {


    Pan2()

}*/