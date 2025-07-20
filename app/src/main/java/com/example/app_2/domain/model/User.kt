package com.example.app_2.domain.model

data class User(
    val userId: String = "",
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val profilePictureUrl: String = "",
    val backgroundImageUrl: String = "",
    val aboutMe: String = "",
    val address: String = ""
)
