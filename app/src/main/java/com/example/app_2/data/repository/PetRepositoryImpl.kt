package com.example.app_2.data.repository

import android.net.Uri
import com.example.app_2.domain.model.Pet
import com.example.app_2.domain.repository.PetRepository
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.util.UUID
import javax.inject.Inject

class PetRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val storage: FirebaseStorage
) : PetRepository {

    override suspend fun registerPet(pet: Pet): Result<Unit> {
        return try {
            val petDocument = firestore.collection("pets").document()
            // Add a server-side timestamp
            val petWithIdAndTimestamp = pet.copy(id = petDocument.id)
            val petMap = petWithIdAndTimestamp.toMap().plus("timestamp" to FieldValue.serverTimestamp())

            petDocument.set(petMap).await()
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

    override suspend fun uploadPetImage(imageUri: Uri): Result<String> {
        return try {
            val storageRef = storage.reference.child("pet_images/${UUID.randomUUID()}")
            val uploadTask = storageRef.putFile(imageUri).await()
            val downloadUrl = uploadTask.storage.downloadUrl.await().toString()
            Result.success(downloadUrl)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun searchPets(query: String): Flow<Result<List<Pet>>> = callbackFlow {
        val nameQuery = firestore.collection("pets")
            .orderBy("name")
            .startAt(query)
            .endAt(query + '\uf8ff')

        val typeQuery = firestore.collection("pets")
            .orderBy("type")
            .startAt(query)
            .endAt(query + '\uf8ff')

        val nameListener = nameQuery.addSnapshotListener { nameSnapshot, error ->
            if (error != null) {
                trySend(Result.failure(error))
                return@addSnapshotListener
            }

            typeQuery.get().addOnSuccessListener { typeSnapshot ->
                val nameResults = nameSnapshot?.toObjects(Pet::class.java) ?: emptyList()
                val typeResults = typeSnapshot?.toObjects(Pet::class.java) ?: emptyList()
                val combinedResults = (nameResults + typeResults).distinctBy { it.id }
                trySend(Result.success(combinedResults))
            }.addOnFailureListener {
                trySend(Result.failure(it))
            }
        }

        awaitClose { nameListener.remove() }
    }
}



