package com.example.foodly.di

import android.content.ContentValues.TAG
import android.util.Log
import com.example.foodly.data.NotchPayApi
import com.example.foodly.data.models.Paiement
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "https://notchpay.com/api/"

    private val client by lazy {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer ${NotchPayApiKey.API_KEY}")
                    .build()
                chain.proceed(newRequest)
            }
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: NotchPayApi by lazy {
        retrofit.create(NotchPayApi::class.java)
    }
}

fun effectuerPaiement(paiement: Paiement): Boolean {
    val result = try {
        val response = RetrofitBuilder.api.effectuerPaiement(Paiement(paiement.montant, paiement.devise))
        response.isSuccessful
    } catch (e: Exception) {
        false
    }

    if (result) {
        Log.d(TAG, "Effectué paiement avec succès!")
    } else {
        Log.d(TAG, "Impossible de réaliser le paiement.")
    }

    return result
}