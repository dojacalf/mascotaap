package com.example.app_2.ui.features.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_2.domain.model.Pet
import com.example.app_2.domain.model.User
import com.example.app_2.domain.repository.AuthRepository
import com.example.app_2.domain.repository.PetRepository
import com.example.app_2.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeState(
    val isLoading: Boolean = true,
    val pets: List<Pet> = emptyList(),
    val error: String? = null,
    val user: User? = null
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val petRepository: PetRepository,
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init {
        loadData()
    }

    private fun loadData() {
        loadPets()
        loadUserProfile()
    }

    private fun loadPets() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            petRepository.getAllPets().collect { result ->
                result.onSuccess { pets ->
                    state = state.copy(isLoading = false, pets = pets, error = null)
                }.onFailure {
                    state = state.copy(isLoading = false, error = it.message)
                }
            }
        }
    }

    private fun loadUserProfile() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            try {
                val currentUser = authRepository.getCurrentUser()
                if (currentUser != null) {
                    var userProfile = userRepository.getUserProfile(currentUser.uid)
                    if (userProfile == null) {
                        val newUser = User(
                            userId = currentUser.uid,
                            name = currentUser.displayName ?: "Usuario",
                            email = currentUser.email ?: "Sin email"
                        )
                        userRepository.createUserProfile(newUser)
                        userProfile = newUser
                    }
                    state = state.copy(user = userProfile, isLoading = false)
                } else {
                    state = state.copy(error = "No se pudo obtener el usuario actual", isLoading = false)
                }
            } catch (e: Exception) {
                state = state.copy(error = e.message, isLoading = false)
            }
        }
    }
}
