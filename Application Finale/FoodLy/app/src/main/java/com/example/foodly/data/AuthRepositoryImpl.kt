package com.example.foodly.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.tasks.await
import java.util.*
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {

    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(email: String, password: String): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }
    }

    override suspend fun signup(first_name: String, lastname: String, email: String, name: String, phone_number: String, address: String, gender: String, start_Date: Long, password: String): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            result.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(first_name).build())?.await()
            result.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(lastname).build())?.await()
            result.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(name).build())?.await()
            result.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(phone_number).build())?.await()
            result.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(address).build())?.await()
            result.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(gender).build())?.await()
            result.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(start_Date.toString()).build())?.await()
            return Resource.Success(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }
    }

    override fun logout() {
        firebaseAuth.signOut()
    }

}