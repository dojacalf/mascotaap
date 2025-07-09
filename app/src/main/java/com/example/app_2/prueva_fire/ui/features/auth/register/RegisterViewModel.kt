package com.example.app_2.prueva_fire.ui.features.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.app_2.prueva_fire.data.AuthRepository
import com.example.app_2.prueva_fire.data.UserState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class RegisterViewModel(private val authRepository: AuthRepository) : ViewModel() {
    private val _state = MutableStateFlow<UserState>(UserState.Unauthenticated)
    val state: StateFlow<UserState> = _state

    fun register(email: String, password: String) {
        viewModelScope.launch {
            _state.value = UserState.Loading
            authRepository.register(email, password)
                .onSuccess { user ->
                    _state.value = UserState.Authenticated(user)
                }
                .onFailure { exception ->
                    _state.value = UserState.Error(exception.message ?: "Error en el registro")
                }
        }
    }
}

class RegisterViewModelFactory(private val authRepository: AuthRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RegisterViewModel(authRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
