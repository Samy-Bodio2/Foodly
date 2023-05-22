package com.example.foodly.screens.RestaurantDetail_Order

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
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun ModifConfirm(){

    val db = Firebase.firestore
    val docRef = db.collection("Menu").document("9uxTdagZh81Hex3d4WQ9")
    docRef.get()
        .addOnSuccessListener {
                document ->
            val confirm = document.getBoolean("Confirmed")
            if(!confirm!!){
                val CollectionUpdate = mapOf("Confirmed" to !confirm)
                docRef.update(CollectionUpdate)

            }
        }
}

// Définit une classe pour représenter chaque élément de la liste des documents
data class DocumentItem(val id: String, val data: String)

// Cette fonction charge et affiche la liste de documents à partir de Firebase
@Composable
fun DocumentList(navController: NavController) {
    val db = Firebase.firestore
    var documentList by remember { mutableStateOf(listOf<DocumentItem>()) }

    // Récupère la liste de documents Firebase et la convertit en liste d'éléments DocumentItem
    LaunchedEffect(Unit) {
        db.collection("nom_collection")
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
                        navController.navigate("détails_document/${item.id}")
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

// Cette fonction récupère le ID du document Firebase à partir de l'argument de navigation dans la page de détails
@Composable
fun DocumentDetails(navController: NavController,) {
    val db = Firebase.firestore
    val documentId = navController.previousBackStackEntry
        ?.arguments?.getString("documentId") ?: ""
    var documentData by remember { mutableStateOf("") }

    // Charge les données du document Firebase correspondant à l'ID spécifié dans l'argument de navigation
    LaunchedEffect(documentId) {
        db.collection("nom_collection").document(documentId)
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    documentData = document.data.toString()
                }
            }
    }

    // Affiche les détails du document Firebase
    Text(
        text = documentData,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    )
}