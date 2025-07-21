package com.example.app_2.ui.features.chat.viewmodel

import androidx.lifecycle.SavedStateHandle
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

data class ChatState(
    val pet: Pet? = null,
    val owner: User? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val petRepository: PetRepository,
    private val userRepository: UserRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(ChatState())
    val uiState: StateFlow<ChatState> = _uiState.asStateFlow()

    private val petId: String = savedStateHandle.get<String>("petId")!!

    init {
        loadPetAndOwnerDetails()
    }

    private fun loadPetAndOwnerDetails() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val result = petRepository.getPetById(petId)
            result.onSuccess { pet ->
                if (pet != null) {
                    val owner = userRepository.getUserProfile(pet.ownerId)
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            pet = pet,
                            owner = owner
                        )
                    }
                } else {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = "Pet not found"
                        )
                    }
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