package com.example.szapana.core.navigation


import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
data class Home(val name: String)

@Serializable
object Details