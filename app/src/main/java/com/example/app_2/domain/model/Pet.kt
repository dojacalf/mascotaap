package com.example.app_2.domain.model

import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class Pet(
    val id: String = "",
    val name: String = "",
    val age: String = "",
    val type: String = "",
    val sex: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val ownerId: String = "",
    val ownerName: String = "",
    @ServerTimestamp
    val timestamp: Date? = null
)
