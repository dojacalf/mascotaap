package com.example.app_2.domain.usercase

import com.example.app_2.prueva_fire.data.AuthRepository
import com.example.app_2.data.reposity.AuthRepositoryImpl


class LoginUseCase(private val authRepository: AuthRepository) {
    operator fun invoke(user: String, password: String) {
        if (user.contains("@hotmail.com")) {
            return
        }
        val response = authRepository.doLogin(user, password)
    }
}