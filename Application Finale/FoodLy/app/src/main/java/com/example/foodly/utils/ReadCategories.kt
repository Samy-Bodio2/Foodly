package com.example.foodly.utils

import androidx.compose.runtime.mutableStateListOf
import com.example.foodly.model.Categories
import com.google.firebase.firestore.FirebaseFirestore

fun readDrinks():MutableList<Categories?>{ val list = mutableStateListOf<Categories?>()

    //   LaunchedEffect(Unit) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    db.collection("Drinks").get()
        .addOnSuccessListener { queryDocumentSnapshots ->
            if (!queryDocumentSnapshots.isEmpty) {
                val documents = queryDocumentSnapshots.documents
                val menuItems = documents.mapNotNull { it.toObject(Categories::class.java) }
                list.addAll(menuItems)
            }
        }
        .addOnFailureListener {
            // Gérer les erreurs ici
        }
    //  }
    return list
}

fun readAlcohol():MutableList<Categories?>{ val list = mutableStateListOf<Categories?>()

    //   LaunchedEffect(Unit) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    db.collection("Alcohol").get()
        .addOnSuccessListener { queryDocumentSnapshots ->
            if (!queryDocumentSnapshots.isEmpty) {
                val documents = queryDocumentSnapshots.documents
                val menuItems = documents.mapNotNull { it.toObject(Categories::class.java) }
                list.addAll(menuItems)
            }
        }
        .addOnFailureListener {
            // Gérer les erreurs ici
        }
    //  }
    return list
}

fun readVegetarian():MutableList<Categories?>{ val list = mutableStateListOf<Categories?>()

    //   LaunchedEffect(Unit) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    db.collection("Vegetarian").get()
        .addOnSuccessListener { queryDocumentSnapshots ->
            if (!queryDocumentSnapshots.isEmpty) {
                val documents = queryDocumentSnapshots.documents
                val menuItems = documents.mapNotNull { it.toObject(Categories::class.java) }
                list.addAll(menuItems)
            }
        }
        .addOnFailureListener {
            // Gérer les erreurs ici
        }
    //  }
    return list
}

fun readPizza():MutableList<Categories?>{ val list = mutableStateListOf<Categories?>()

    //   LaunchedEffect(Unit) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    db.collection("Pizza").get()
        .addOnSuccessListener { queryDocumentSnapshots ->
            if (!queryDocumentSnapshots.isEmpty) {
                val documents = queryDocumentSnapshots.documents
                val menuItems = documents.mapNotNull { it.toObject(Categories::class.java) }
                list.addAll(menuItems)
            }
        }
        .addOnFailureListener {
            // Gérer les erreurs ici
        }
    //  }
    return list
}

fun readChicken():MutableList<Categories?>{ val list = mutableStateListOf<Categories?>()

    //   LaunchedEffect(Unit) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    db.collection("Chicken").get()
        .addOnSuccessListener { queryDocumentSnapshots ->
            if (!queryDocumentSnapshots.isEmpty) {
                val documents = queryDocumentSnapshots.documents
                val menuItems = documents.mapNotNull { it.toObject(Categories::class.java) }
                list.addAll(menuItems)
            }
        }
        .addOnFailureListener {
            // Gérer les erreurs ici
        }
    //  }
    return list
}

fun readMeat():MutableList<Categories?>{ val list = mutableStateListOf<Categories?>()

    //   LaunchedEffect(Unit) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    db.collection("Meat").get()
        .addOnSuccessListener { queryDocumentSnapshots ->
            if (!queryDocumentSnapshots.isEmpty) {
                val documents = queryDocumentSnapshots.documents
                val menuItems = documents.mapNotNull { it.toObject(Categories::class.java) }
                list.addAll(menuItems)
            }
        }
        .addOnFailureListener {
            // Gérer les erreurs ici
        }
    //  }
    return list
}

fun readTraditionnal():MutableList<Categories?>{ val list = mutableStateListOf<Categories?>()

    //   LaunchedEffect(Unit) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    db.collection("Traditionnal").get()
        .addOnSuccessListener { queryDocumentSnapshots ->
            if (!queryDocumentSnapshots.isEmpty) {
                val documents = queryDocumentSnapshots.documents
                val menuItems = documents.mapNotNull { it.toObject(Categories::class.java) }
                list.addAll(menuItems)
            }
        }
        .addOnFailureListener {
            // Gérer les erreurs ici
        }
    //  }
    return list
}

fun readTacos():MutableList<Categories?>{ val list = mutableStateListOf<Categories?>()

    //   LaunchedEffect(Unit) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    db.collection("Tacos").get()
        .addOnSuccessListener { queryDocumentSnapshots ->
            if (!queryDocumentSnapshots.isEmpty) {
                val documents = queryDocumentSnapshots.documents
                val menuItems = documents.mapNotNull { it.toObject(Categories::class.java) }
                list.addAll(menuItems)
            }
        }
        .addOnFailureListener {
            // Gérer les erreurs ici
        }
    //  }
    return list
}

fun readFish():MutableList<Categories?>{ val list = mutableStateListOf<Categories?>()

    //   LaunchedEffect(Unit) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    db.collection("Fish").get()
        .addOnSuccessListener { queryDocumentSnapshots ->
            if (!queryDocumentSnapshots.isEmpty) {
                val documents = queryDocumentSnapshots.documents
                val menuItems = documents.mapNotNull { it.toObject(Categories::class.java) }
                list.addAll(menuItems)
            }
        }
        .addOnFailureListener {
            // Gérer les erreurs ici
        }
    //  }
    return list
}

