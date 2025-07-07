package com.example.app_2.ui.features.miniapp.data

class AuthRepository {
    private val users = mutableListOf<User>()

    suspend fun login(email: String, password: String): User? {
        return users.find { it.email == email && it.password == password }
    }

    suspend fun register(user: User): Boolean {
        if (users.any { it.email == user.email }) {
            return false
        } else {
            users.add(user)
            return true
        }
    }
}