package com.example.app_2.domain.repository

import android.net.Uri
import com.example.app_2.domain.model.Pet
import kotlinx.coroutines.flow.Flow

interface PetRepository {
    suspend fun registerPet(pet: Pet): Result<Unit>
    fun getAllPets(): Flow<Result<List<Pet>>>
    suspend fun getPetById(petId: String): Result<Pet?>
    suspend fun uploadPetImage(imageUri: Uri): Result<String>
    fun searchPets(query: String): Flow<Result<List<Pet>>>
}
