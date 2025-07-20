package com.example.app_2.data.repository

import com.example.app_2.domain.model.Pet
import com.example.app_2.domain.repository.PetRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class PetRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : PetRepository {

    override suspend fun registerPet(pet: Pet): Result<Unit> {
        return try {
            val petDocument = firestore.collection("pets").document()
            val petWithId = pet.copy(id = petDocument.id)
            petDocument.set(petWithId).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getAllPets(): Flow<Result<List<Pet>>> = callbackFlow {
        val petsCollection = firestore.collection("pets")
            .orderBy("timestamp", Query.Direction.DESCENDING)

        val listener = petsCollection.addSnapshotListener { snapshot, error ->
            if (error != null) {
                trySend(Result.failure(error))
                return@addSnapshotListener
            }
            if (snapshot != null) {
                val pets = snapshot.toObjects(Pet::class.java)
                trySend(Result.success(pets))
            }
        }
        awaitClose { listener.remove() }
    }

    override suspend fun getPetById(petId: String): Result<Pet?> {
        return try {
            val document = firestore.collection("pets").document(petId).get().await()
            val pet = document.toObject(Pet::class.java)
            Result.success(pet)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}



