package com.example.app_2.data.repository

import android.net.Uri
import com.example.app_2.domain.model.Pet
import com.example.app_2.domain.repository.PetRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import java.util.UUID
import javax.inject.Inject


class PetRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val storage: FirebaseStorage
) : PetRepository {

    override suspend fun registerPet(pet: Pet, imageUri: Uri): Result<Unit> {
        return try {
            val imageFileName = "pet_images/${UUID.randomUUID()}"
            val uploadTask = storage.reference.child(imageFileName).putFile(imageUri).await()
            val imageUrl = uploadTask.storage.downloadUrl.await().toString()

            val petDocument = firestore.collection("pets").document()
            val petWithIdAndImage = pet.copy(
                id = petDocument.id,
                imageUrl = imageUrl
            )

            petDocument.set(petWithIdAndImage).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getAllPets(): Result<List<Pet>> {
        return try {
            val snapshot = firestore.collection("pets")
                .orderBy("timestamp", Query.Direction.DESCENDING)
                .get()
                .await()

            val pets = snapshot.toObjects(Pet::class.java)
            Result.success(pets)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
