package com.example.app_2.domain.repository

import com.example.app_2.domain.entity.UserEntity

interface AuthRepository {
    fun doLogin(user:String, password:String): UserEntity
}