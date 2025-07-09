package com.example.app_2.domain.entity

data class UserEntity(
    val userId: String,
    val userName: String,
    val userEmail: String,
    val userType: UserMode
)
sealed class UserMode(val userType: Int) {
    data object STUDENT_USER : UserMode(userType = 0)
    data object TEACHER_USER : UserMode(userType = 1)
    data object COORDINADOR_USER : UserMode(userType = 2)
    data object ADMIN_USER : UserMode(userType = 3)
}

