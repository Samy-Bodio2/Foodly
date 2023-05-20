package com.example.foodly.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.foodly.model.Meal

class PanierViewModel : ViewModel(){
    var cartList: MutableList<Meal> by mutableStateOf(mutableListOf())
}