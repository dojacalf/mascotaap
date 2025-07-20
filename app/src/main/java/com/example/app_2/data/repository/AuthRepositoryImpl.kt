package com.example.app_2.data.repository

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

    override suspend fun login(email: String, pass: String): FirebaseUser {
        try {
            val result = auth.signInWithEmailAndPassword(email, pass).await()
            return result.user ?: throw Exception("Error en el login: usuario no encontrado.")
        } catch (e: FirebaseAuthInvalidUserException) {
            throw Exception("No existe una cuenta con este correo electrónico.")
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            throw Exception("La contraseña es incorrecta. Por favor, inténtalo de nuevo.")
        } catch (e: Exception) {
            throw Exception("Ocurrió un error inesperado durante el login: ${e.message}")
        }
    }

    override suspend fun register(email: String, pass: String): FirebaseUser {
        try {
            val result = auth.createUserWithEmailAndPassword(email, pass).await()
            return result.user ?: throw Exception("Error en el registro: no se pudo crear el usuario.")
        } catch (e: FirebaseAuthUserCollisionException) {
            throw Exception("Ya existe una cuenta con este correo electrónico.")
        } catch (e: Exception) {
            throw Exception("Ocurrió un error inesperado durante el registro: ${e.message}")
        }
    }

    override fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }
}
