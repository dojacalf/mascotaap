package com.example.app_2.ui.features.Registrar_mascota.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_2.domain.model.Pet
import com.example.app_2.domain.repository.AuthRepository
import com.example.app_2.domain.repository.PetRepository
import com.example.app_2.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RegistrarMascotaState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class RegistrarMascotaViewModel @Inject constructor(
    private val petRepository: PetRepository,
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    var nombre by mutableStateOf("")
    var edad by mutableStateOf("")
    var tipo by mutableStateOf("Perro")
    var sexo by mutableStateOf("Macho")
    var descripcion by mutableStateOf("")

    var state by mutableStateOf(RegistrarMascotaState())
        private set

    fun registerPet() {
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)

            val currentFirebaseUser = authRepository.getCurrentUser()
            if (currentFirebaseUser == null) {
                state = state.copy(isLoading = false, error = "Usuario no autenticado.")
                return@launch
            }

            // Get user profile to fetch owner's name
            val userProfile = userRepository.getUserProfile(currentFirebaseUser.uid)
            if (userProfile == null) {
                state = state.copy(isLoading = false, error = "No se pudo obtener el perfil del usuario.")
                return@launch
            }

            val pet = Pet(
                name = nombre,
                age = edad,
                type = tipo,
                sex = sexo,
                description = descripcion,
                ownerId = currentFirebaseUser.uid,
                ownerName = userProfile.name
            )

            val result = petRepository.registerPet(pet)

            result.onSuccess {
                state = state.copy(isLoading = false, isSuccess = true)
            }.onFailure {
                state = state.copy(isLoading = false, error = it.message ?: "Error desconocido")
            }
        }
    }
}
