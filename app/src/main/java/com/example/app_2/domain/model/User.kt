package com.example.app_2.domain.model

data class User(
    val id: String,
    val name: String,
    val email: String,
    val userType: UserMode,
    val profileImageUrl: String? = null
)

sealed class UserMode(val userType: Int) {
    data object STUDENT_USER : UserMode(userType = 0)
    data object TEACHER_USER : UserMode(userType = 1)
    data object COORDINADOR_USER : UserMode(userType = 2)
    data object ADMIN_USER : UserMode(userType = 3)
}
