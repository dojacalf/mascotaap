package com.example.app_2.ui.features.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_2.domain.model.Pet
import com.example.app_2.domain.repository.PetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeState(
    val isLoading: Boolean = true,
    val pets: List<Pet> = emptyList(),
    val error: String? = null
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val petRepository: PetRepository
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init {
        loadPets()
    }

    private fun loadPets() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            petRepository.getAllPets()
                .onSuccess { pets ->
                    state = state.copy(isLoading = false, pets = pets)
                }
                .onFailure {
                    state = state.copy(isLoading = false, error = it.message)
                }
        }
    }
}