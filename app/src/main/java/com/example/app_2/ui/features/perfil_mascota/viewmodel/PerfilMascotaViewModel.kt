package com.example.app_2.ui.features.perfil_mascota.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_2.domain.model.Pet
import com.example.app_2.domain.repository.PetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PerfilMascotaState(
    val isLoading: Boolean = true,
    val pet: Pet? = null,
    val error: String? = null
)

@HiltViewModel
class PerfilMascotaViewModel @Inject constructor(
    private val petRepository: PetRepository,
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
                state = state.copy(isLoading = false, pet = pet, error = null)
            }.onFailure {
                state = state.copy(isLoading = false, error = it.message)
            }
        }
    }
}
