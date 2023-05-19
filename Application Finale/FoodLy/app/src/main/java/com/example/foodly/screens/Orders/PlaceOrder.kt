package com.example.foodly.screens.Orders

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodly.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun PlaceOrderScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Commander") },
                navigationIcon = {
                    IconButton(onClick = { /* action lorsque l'utilisateur clique sur le bouton retour */ }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Retour")
                    }
                },
                actions = {
                    IconButton(onClick = { /* action lorsque l'utilisateur clique sur le bouton suivant */ }) {
                        Icon(Icons.Filled.ArrowForward, contentDescription = "Suivant")
                    }
                }
            )
        }) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(R.drawable.food),
                contentDescription = "Nom du produit"
            )
            Text(
                text = "Titre du produit",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "Description du produit",
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(Modifier.align(Alignment.CenterHorizontally)) {
                Button(onClick = { /* action lorsque l'utilisateur clique sur le bouton moins */ }) {
                    Text("-")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Quantité")
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { /* action lorsque l'utilisateur clique sur le bouton plus */ }) {
                    Text("+")
                }
            }
            TextField(
                value = "",
                onValueChange = { /* action lorsque la valeur du champ de texte change */ },
                label = { Text("Note pour le restaurant") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            Button(
                onClick = { /* action lorsque l'utilisateur clique sur le bouton passer la commande */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Passer la commande")
            }
        }
    }
}

@Preview
@Composable
fun PreviewPlaceOrderScreen(){
    PlaceOrderScreen()
}