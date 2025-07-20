package com.example.app_2.domain.repository

import android.net.Uri
import com.example.app_2.domain.model.Pet

interface PetRepository {
    suspend fun registerPet(pet: Pet, imageUri: Uri): Result<Unit>
    suspend fun getAllPets(): Result<List<Pet>>
}
