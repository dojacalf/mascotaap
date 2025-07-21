package com.example.app_2.ui.features.perfil_mascota.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_2.domain.model.Pet
import com.example.app_2.domain.model.User
import com.example.app_2.domain.repository.PetRepository
import com.example.app_2.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PerfilMascotaState(
    val isLoading: Boolean = true,
    val pet: Pet? = null,
    val owner: User? = null,
    val error: String? = null
)

@HiltViewModel
class PerfilMascotaViewModel @Inject constructor(
    private val petRepository: PetRepository,
    private val userRepository: UserRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(PerfilMascotaState())
        private set

    init {
        savedStateHandle.get<String>("petId")?.let { petId ->
            loadPetDetails(petId)
        }
    }

    private fun loadPetDetails(petId: String) {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = petRepository.getPetById(petId)
            result.onSuccess { pet ->
                state = state.copy(pet = pet)
                if (pet != null) {
                    loadOwnerDetails(pet.ownerId)
                } else {
                    state = state.copy(isLoading = false, error = "Pet not found")
                }
            }.onFailure {
                state = state.copy(isLoading = false, error = it.message)
            }
        }
    }

    private fun loadOwnerDetails(ownerId: String) {
        viewModelScope.launch {
            val owner = userRepository.getUserProfile(ownerId)
            state = state.copy(isLoading = false, owner = owner, error = if (owner == null) "Owner not found" else null)
        }
    }
}
