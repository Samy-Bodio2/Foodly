package com.example.foodly.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class PopularData(
    @DrawableRes val resId: Int,
    val title: String,
    val price: Double,
    val rate: Double,
    val info: String,
    val description: String


): Parcelable
