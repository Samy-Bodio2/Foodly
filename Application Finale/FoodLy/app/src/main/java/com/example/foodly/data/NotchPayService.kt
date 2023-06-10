package com.example.foodly.data

import com.example.foodly.data.models.Paiement
import com.example.foodly.data.models.PaiementResultat
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NotchPayApi {
    @POST("paiements")
    fun effectuerPaiement(@Body paiement: Paiement): Response<PaiementResultat>
}