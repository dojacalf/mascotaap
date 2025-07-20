package com.example.app_2.ui.features.Registrar_mascota.viewmodel

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
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
    var imageUri by mutableStateOf<Uri?>(null)

    var state by mutableStateOf(RegistrarMascotaState())
        private set

    fun registerPet() {
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)

            if (imageUri == null) {
                state = state.copy(isLoading = false, error = "Por favor, selecciona una imagen para la mascota.")
                return@launch
            }

            val currentFirebaseUser = authRepository.getCurrentUser()
            if (currentFirebaseUser == null) {
                state = state.copy(isLoading = false, error = "Usuario no autenticado.")
                return@launch
            }

            val userProfile = userRepository.getUserProfile(currentFirebaseUser.uid)
            if (userProfile == null) {
                state = state.copy(isLoading = false, error = "No se pudo obtener el perfil del usuario.")
                return@launch
            }

            // 1. Upload image
            val uploadResult = petRepository.uploadPetImage(imageUri!!)
            uploadResult.onSuccess { imageUrl ->
                // 2. Create Pet object with the new image URL
                val pet = Pet(
                    name = nombre,
                    age = edad,
                    type = tipo,
                    sex = sexo,
                    description = descripcion,
                    ownerId = currentFirebaseUser.uid,
                    ownerName = userProfile.name,
                    imageUrl = imageUrl
                )

                // 3. Register pet in Firestore
                val registerResult = petRepository.registerPet(pet)
                registerResult.onSuccess {
                    state = state.copy(isLoading = false, isSuccess = true)
                }.onFailure {
                    state = state.copy(isLoading = false, error = it.message ?: "Error al registrar la mascota.")
                }

            }.onFailure {
                state = state.copy(isLoading = false, error = it.message ?: "Error al subir la imagen.")
            }
        }
    }
}
