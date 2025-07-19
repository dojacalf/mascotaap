package com.example.app_2.data.repository

import com.example.app_2.domain.model.User
import com.example.app_2.domain.model.UserMode
import com.example.app_2.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {

    override suspend fun login(email: String, pass: String): User {
        try {
            val firebaseUser = auth.signInWithEmailAndPassword(email, pass).await().user
            return firebaseUser?.toDomainUser() ?: throw Exception("Error en el login: usuario no encontrado.")
        } catch (e: FirebaseAuthInvalidUserException) {
            throw Exception("No existe una cuenta con este correo electrónico.")
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            throw Exception("La contraseña es incorrecta. Por favor, inténtalo de nuevo.")
        } catch (e: Exception) {
            throw Exception("Ocurrió un error inesperado durante el login.")
        }
    }

    override suspend fun register(email: String, pass: String): User {
        try {
            val firebaseUser = auth.createUserWithEmailAndPassword(email, pass).await().user
            // Aquí iría la lógica para guardar datos adicionales en Firestore
            return firebaseUser?.toDomainUser() ?: throw Exception("Error en el registro: no se pudo crear el usuario.")
        } catch (e: FirebaseAuthUserCollisionException) {
            throw Exception("Ya existe una cuenta con este correo electrónico.")
        } catch (e: Exception) {
            throw Exception("Ocurrió un error inesperado durante el registro.")
        }
    }

    override val currentUser: User?
        get() = auth.currentUser?.toDomainUser()

    private fun FirebaseUser.toDomainUser(): User {
        return User(
            id = this.uid,
            name = this.displayName ?: "Sin Nombre",
            email = this.email ?: "",
            // Asumimos un tipo de usuario por defecto. Esto debería ser manejado
            // según la lógica de negocio (ej: guardando el rol en Firestore).
            userType = UserMode.STUDENT_USER, 
            profileImageUrl = this.photoUrl?.toString()
        )
    }
}
