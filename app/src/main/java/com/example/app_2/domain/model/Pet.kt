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
    val ownerId: String = "",
    val ownerName: String = "",
    val imageUrl: String = ""
){
    fun toMap(): Map<String, Any> {
        return mapOf(
            "id" to id,
            "name" to name,
            "age" to age,
            "type" to type,
            "sex" to sex,
            "description" to description,
            "ownerId" to ownerId,
            "ownerName" to ownerName,
            "imageUrl" to imageUrl
        )
    }
}
