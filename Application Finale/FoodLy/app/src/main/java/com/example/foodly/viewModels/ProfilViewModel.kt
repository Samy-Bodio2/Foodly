package com.example.foodly.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodly.model.User
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

 class ProfilViewModel : ViewModel() {
//
// // Récupérer l'utilisateur actuel connecté
// private val authInstance = Firebase.auth
// private val currentUser = authInstance.currentUser
//
// // Récupérer la référence de l'utilisateur actuel
// private val databaseInstance = Firebase.database.reference
// private val userRef = databaseInstance.child("users").child(currentUser?.uid ?: "")
//
// // Etablir une liaison de données Observer pour les futures modifications de données utilisateur
// val userLiveData: MutableLiveData<User> = MutableLiveData()
//
// init {
// // Écouter les modifications des données de l'utilisateur Firebase
// userRef.addValueEventListener(object : ValueEventListener {
// override fun onDataChange(snapshot: DataSnapshot) {
// //Convertir le snapshot en objet modele User
// val user = snapshot.getValue(User::class.java)
// //Mettre à jour  le LiveData
// userLiveData.value = user
// }
//
// override fun onCancelled(error: DatabaseError) {
// Log.e("ProfileViewModel", "Erreur : $error")
// }
// })
// }
 }