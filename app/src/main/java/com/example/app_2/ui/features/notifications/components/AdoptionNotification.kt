package com.example.app_2.ui.features.notifications.components

data class AdoptionNotification(
    val id: Int,
    val user: String,
    val userImage: Int,
    val petImage: Int,
    val message: String,
    val time: String,
    val accepted: Boolean
)