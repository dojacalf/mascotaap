package com.example.app_2.domain.usecase

import com.example.app_2.domain.model.User
import com.example.app_2.domain.repository.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, pass: String): User {
        return repository.login(email, pass)
    }
}
