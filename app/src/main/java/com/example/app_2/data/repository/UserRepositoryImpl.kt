package com.example.app_2.data.repository

import android.net.Uri
import com.example.app_2.domain.model.User
import com.example.app_2.domain.repository.UserRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val storage: FirebaseStorage
) : UserRepository {

    override suspend fun getUserProfile(userId: String): User? {
        return try {
            val document = firestore.collection("users").document(userId).get().await()
            document.toObject(User::class.java)
        } catch (e: Exception) {
            // Log exception or handle error
            null
        }
    }

    override suspend fun createUserProfile(user: User) {
        try {
            firestore.collection("users").document(user.userId).set(user).await()
        } catch (e: Exception) {
            // Log exception or handle error
        }
    }

    override suspend fun updateUserPhone(userId: String, phone: String) {
        try {
            firestore.collection("users").document(userId).update("phone", phone).await()
        } catch (e: Exception) {
            // Log exception or handle error
        }
    }

    override suspend fun updateAboutMe(userId: String, aboutMe: String) {
        try {
            firestore.collection("users").document(userId).update("aboutMe", aboutMe).await()
        } catch (e: Exception) {
            // Log exception or handle error
        }
    }

    override suspend fun updateAddress(userId: String, address: String) {
        try {
            firestore.collection("users").document(userId).update("address", address).await()
        } catch (e: Exception) {
            // Log exception or handle error
        }
    }

    override suspend fun updateProfilePicture(userId: String, imageUri: Uri): String {
        return try {
            val storageRef = storage.reference.child("profile_pictures/${userId}")
            storageRef.putFile(imageUri).await()
            val downloadUrl = storageRef.downloadUrl.await().toString()
            firestore.collection("users").document(userId).update("profilePictureUrl", downloadUrl).await()
            downloadUrl
        } catch (e: Exception) {
            // Log exception or handle error
            ""
        }
    }

    override suspend fun updateBackgroundImage(userId: String, imageUri: Uri): String {
        return try {
            val storageRef = storage.reference.child("background_pictures/${userId}")
            storageRef.putFile(imageUri).await()
            val downloadUrl = storageRef.downloadUrl.await().toString()
            firestore.collection("users").document(userId).update("backgroundImageUrl", downloadUrl).await()
            downloadUrl
        } catch (e: Exception) {
            // Log exception or handle error
            ""
        }
    }
}
