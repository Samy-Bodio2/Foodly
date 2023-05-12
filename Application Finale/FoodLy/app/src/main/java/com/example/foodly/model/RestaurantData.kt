package com.example.foodly.model
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize

data class RestaurantData(
    @DrawableRes val resId: Int,
    val title: String,
    val location: String,
    val rate: Double,
    val description: String
): Parcelable

