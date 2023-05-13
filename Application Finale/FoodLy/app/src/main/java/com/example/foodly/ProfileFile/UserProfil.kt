package com.example.foodly.ProfileFile

import java.util.*

data class User(val id: String = "",
                      val name: String = "",
                      val email: String = "",
                      val joinedDate: Date? = null)
