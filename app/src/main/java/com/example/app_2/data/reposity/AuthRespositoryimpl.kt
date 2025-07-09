package com.example.app_2.data.reposity

import com.example.app_2.domain.entity.UserEntity
import com.example.app_2.domain.repository.AuthRepository

class AuthRepositoryImpl(): AuthRepository {
    override fun dologin(user: String, password: String): UserEntity {
        val userResponse: UserResponse = UserResponse(
            userId = "",
            userName = "",
            userEmail = "",
            userType = 0
        )
        return userResponse.toDomain()
    }
}