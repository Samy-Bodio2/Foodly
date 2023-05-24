package com.example.foodly.utils


import androidx.compose.runtime.mutableStateListOf
import com.google.firebase.firestore.FirebaseFirestore
import com.example.foodly.screens.Home_ActionMenu.MenuItem

fun readConfirmedMenus(): MutableList<MenuItem?> {
    val list = mutableStateListOf<MenuItem?>()
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    db.collection("Menu")
        .whereEqualTo("Confirmed", true)
        .get()
        .addOnSuccessListener { queryDocumentSnapshots ->
            if (!queryDocumentSnapshots.isEmpty) {
                val documents = queryDocumentSnapshots.documents
                val menuItems = documents.mapNotNull { it.toObject(MenuItem::class.java) }
                list.addAll(menuItems)
            }
        }
        .addOnFailureListener {
            // Gérer les erreurs ici
        }

    return list
}