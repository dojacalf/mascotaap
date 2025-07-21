package com.example.app_2.domain.usecase

import com.example.app_2.domain.model.Pet
import com.example.app_2.domain.repository.PetRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchPets @Inject constructor(
    private val petRepository: PetRepository
) {
    operator fun invoke(query: String): Flow<Result<List<Pet>>> {
        return petRepository.searchPets(query)
    }
}
