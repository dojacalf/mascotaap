package com.example.app_2.navigation

sealed class AppScreens(val route: String) {
    object LoginScreen : AppScreens("login_screen")
    object RegisterScreen : AppScreens("register_screen")
    object InicioScreen : AppScreens("inicio_screen")
    object PetScreen: AppScreens("pet_screen")
    object SearchScreen: AppScreens("buscar_screen")
}