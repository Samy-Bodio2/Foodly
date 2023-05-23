package com.example.foodly.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import com.example.foodly.screens.Home_ActionMenu.MenuItem
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

fun read():MutableList<MenuItem?>{ val list = mutableStateListOf<MenuItem?>()

    //   LaunchedEffect(Unit) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    db.collection("Menu").get()
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
    //  }
    return list
}

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