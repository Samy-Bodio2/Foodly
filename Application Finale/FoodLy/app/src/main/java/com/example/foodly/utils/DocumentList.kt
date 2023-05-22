package com.example.foodly.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodly.navigation.Screen
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun DocumentList(navController: NavController) {
    val db = Firebase.firestore
    var documentList by remember { mutableStateOf(listOf<DocumentItem>()) }

    // Récupère la liste de documents Firebase et la convertit en liste d'éléments DocumentItem
    LaunchedEffect(Unit) {
        db.collection("Menu")
            .get()
            .addOnSuccessListener { documents ->
                val items = mutableListOf<DocumentItem>()
                for (document in documents) {
                    val id = document.id
                    val data = document.data.toString()
                    val item = DocumentItem(id, data)
                    items.add(item)
                }
                documentList = items
            }
    }

    // Affiche la liste d'éléments DocumentItem sous forme de LazyColumn avec un écouteur de clic
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(documentList) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = {
                        // Utilise NavController pour naviguer vers une autre page et passer l'ID du document en tant qu'argument
                        navController.navigate("details/${item.id}")
                    }),
                elevation = 8.dp
            ) {
                Text(
                    text = item.data,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}