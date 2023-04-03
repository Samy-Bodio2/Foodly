package com.example.foodly.data

import com.google.firebase.auth.FirebaseUser
import java.util.*

interface AuthRepository {
    val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): Resource<FirebaseUser>
    suspend fun signup(
        first_name: String,
        lastname: String,
        email: String,
        name: String,
        phone_number: String,
        address: String,
        gender: String,
        start_Date: Long,
        password: String
    ): Resource<FirebaseUser>
    fun logout()
}
