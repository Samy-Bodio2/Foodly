package com.example.foodly.utils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun DocumentDetails(navController: NavController,) {
    val db = Firebase.firestore
    val documentId = navController.previousBackStackEntry
        ?.arguments?.getString("9uxTdagZh81Hex3d4WQ9") ?: ""
    var documentData by remember { mutableStateOf("") }

    // Charge les données du document Firebase correspondant à l'ID spécifié dans l'argument de navigation
    LaunchedEffect(documentId) {
        db.collection("Menu").document(documentId)
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
