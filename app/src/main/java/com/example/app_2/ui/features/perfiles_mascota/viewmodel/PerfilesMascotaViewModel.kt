package com.example.app_2.ui.features.perfiles_mascota.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_2.domain.model.Pet
import com.example.app_2.domain.model.User
import com.example.app_2.domain.repository.PetRepository
import com.example.app_2.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PetPost(
    val pet: Pet,
    val owner: User
)

data class PerfilesMascotaState(
    val posts: List<PetPost> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class PerfilesMascotaViewModel @Inject constructor(
    private val petRepository: PetRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PerfilesMascotaState())
    val uiState: StateFlow<PerfilesMascotaState> = _uiState.asStateFlow()

    init {
        loadPetPosts()
    }

    private fun loadPetPosts() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            petRepository.getAllPets().collect { result ->
                result.onSuccess { pets ->
                    val posts = pets.mapNotNull { pet ->
                        userRepository.getUserProfile(pet.ownerId)?.let { owner ->
                            PetPost(pet = pet, owner = owner)
                        }
                    }
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            posts = posts
                        )
                    }
                }.onFailure { exception ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = exception.message ?: "An unknown error occurred"
                        )
                    }
                }
            }
        }
    }
}