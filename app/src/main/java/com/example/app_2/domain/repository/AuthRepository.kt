package com.example.app_2.domain.repository

import com.example.app_2.domain.entity.UserEntity


interface AuthRepository1 {
    fun doLogin(username:String, password:String): UserEntity
}