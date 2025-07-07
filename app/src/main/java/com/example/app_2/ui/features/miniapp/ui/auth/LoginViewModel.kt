package com.example.app_2.ui.features.miniapp.ui.auth

import com.example.app_2.ui.features.miniapp.data.AuthRepository
import androidx.compose.runtime.*


class LoginViewModel(private val authRepository: AuthRepository) {
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var error by mutableStateOf("")
    var isLoading by mutableStateOf(false)
    
    
}