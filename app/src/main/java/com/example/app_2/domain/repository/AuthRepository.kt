package com.example.app_2.domain.repository

import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    suspend fun login(email: String, pass: String): FirebaseUser
    suspend fun register(email: String, pass: String): FirebaseUser
    fun getCurrentUser(): FirebaseUser?
}
