package com.example.app_2.navigation

sealed class AppScreens(val route: String) {
    object InicioScreen : AppScreens("inicio_screen")
    object LoginScreen : AppScreens("login_screen")
    object RegisterScreen : AppScreens("register_screen")
    object PetScreen: AppScreens("pet_screen")
    object SearchScreen: AppScreens("buscar_screen")
    object LoadingScreen: AppScreens("carga_screen")
    object ConfiguracionScreen: AppScreens("configuracion_screen")
    object PetPerfilScreen: AppScreens("perfil_mascota_screen")
    object FindScreen1: AppScreens("encuentra_screen")
}