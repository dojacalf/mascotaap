package com.example.app_2.data.responce

data class UserResponse(
    val userId: String,
    val userName: String,
    val userEmail: String,
    val userType: Int
)

fun UserResponse.toDomain(): UserEntity {
    val userMode: UserMode = when (userType) {
        STUDENT_USER.userType -> STUDENT_USER
        TEACHER_USER.userType -> TEACHER_USER
        CORDINADOR_USER.userType -> CORDINADOR_USER
        ADMIN_USER.userType -> ADMIN_USER
        else -> STUDENT_USER
    }

    return UserEntity(
        userId = userId,
        userName = userName,
        userEmail = userEmail,
        userType = userMode
    )
}