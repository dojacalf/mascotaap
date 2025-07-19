package com.example.app_2.domain.repository

import com.example.app_2.domain.model.User

interface AuthRepository {
    suspend fun login(email: String, pass: String): User
    suspend fun register(email: String, pass: String): User
    val currentUser: User?
}
