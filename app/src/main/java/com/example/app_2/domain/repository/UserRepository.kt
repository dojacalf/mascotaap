package com.example.app_2.domain.repository

import com.example.app_2.domain.model.User

interface UserRepository {
    suspend fun getUserProfile(userId: String): User?
    suspend fun createUserProfile(user: User)
    suspend fun updateUserPhone(userId: String, phone: String)
    suspend fun updateAboutMe(userId: String, aboutMe: String)
    suspend fun updateAddress(userId: String, address: String)
}