package com.example.app_2.prueva_fire.data

import com.google.firebase.auth.FirebaseUser

sealed class UserState {
    object Loading : UserState()
    data class Authenticated(val user: FirebaseUser) : UserState()
    object Unauthenticated : UserState()
    data class Error(val message: String) : UserState()
}
