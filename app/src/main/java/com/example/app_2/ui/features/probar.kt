package com.example.app_2.ui.features


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

import androidx.compose.runtime.collectAsState

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import androidx.lifecycle.viewmodel.compose.viewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.*

data class User(
    val name: String,
    val age: Int
)

object apiService {
    suspend fun getUser(): User {
        delay(1000)
        return User("John", 30)
    }
}
suspend fun fetchUserData(): User {
    return apiService.getUser()
}

fun main(){
    GlobalScope.launch(Dispatchers.IO) {
        println("Obteniendo datos del usuario...")
        val user = fetchUserData()
        println("Usuario obtenido: ${user.name}")
    }

    println("Esta línea se ejecuta inmediatamente sin esperar a fetchUserData.")
    Thread.sleep(2000)
}