package com.example.app_2.ui.features.auth.login.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_2.domain.usecase.Login
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// State class to represent the UI state of the Login screen
data class LoginState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val loginSuccess: Boolean = false
)

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: Login
) : ViewModel() {

    // UI-bindable properties for email and password
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    // The private mutable state flow
    private val _state = MutableStateFlow(LoginState())
    // The public immutable state flow for the UI to observe
    val state = _state.asStateFlow()

    fun onLoginClicked() {
        viewModelScope.launch {
            _state.value = LoginState(isLoading = true)
            try {
                // The use case now returns a FirebaseUser, but we don't need to store it here.
                // We just need to know that the login was successful.
                loginUseCase(email, password)
                _state.value = LoginState(loginSuccess = true, isLoading = false)
            } catch (e: Exception) {
                _state.value = LoginState(error = e.message ?: "Error desconocido", isLoading = false)
            }
        }
    }

    // Function to be called by the UI after the navigation event has been handled
    fun onLoginSuccessHandled() {
        _state.value = _state.value.copy(loginSuccess = false, error = null)
    }
}
