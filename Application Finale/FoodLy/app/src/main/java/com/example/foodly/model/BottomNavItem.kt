package com.example.foodly.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val route: String,
    val icon: ImageVector? = null,
    val contentDescription: String? = null,
    val alertCount: Int? = null,
)
data class TextNavItem(
    val route: String,
    val text:String,
    val contentDescription: String? = null,
    val alertCount: Int? = null,

)
