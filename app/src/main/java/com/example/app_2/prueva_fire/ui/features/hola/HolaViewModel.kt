package com.example.app_2.prueva_fire.ui.features.hola

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app_2.prueva_fire.data.AuthRepository
import com.google.firebase.auth.FirebaseUser

class HolaViewModel(private val authRepository: AuthRepository) : ViewModel() {
    val currentUser: FirebaseUser?
        get() = authRepository.currentUser

    fun logout() {
        authRepository.logout()
    }
}

class HolaViewModelFactory(private val authRepository: AuthRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HolaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HolaViewModel(authRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
