package com.example.app_2.domain.usecase

import com.example.app_2.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class Register @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, pass: String): FirebaseUser {
        return repository.register(email, pass)
    }
}
