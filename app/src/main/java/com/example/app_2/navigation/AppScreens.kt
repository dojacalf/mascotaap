package com.example.app_2.navigation

sealed class AppScreens(val route: String) {
    object InicioScreen : AppScreens("inicio_screen")
    object LoginScreen : AppScreens("login_screen")
    object RegisterScreen : AppScreens("register_screen")
    object PetScreen: AppScreens("pet_screen")
    object BuscarScreen: AppScreens("buscar_screen")
    object CargaScreen: AppScreens("carga_screen")
    object ConfiguracionScreen: AppScreens("configuracion_screen")
    object PerfilMascotaScreen: AppScreens("perfil_mascota_screen")
    object Encuentra1Screen: AppScreens("encuentra_screen")
    object PrincipalScreen: AppScreens("principal_screen")
    object PerfilUsuarioScreen: AppScreens("perfil_usuario_screen")
    object RegistrarMascotaScreen: AppScreens("registrar_mascota_screen")
    object MapaScreen: AppScreens("mapa_screen")
    object ChatScreen: AppScreens("chat_screen")
    object Encuentra2Screen: AppScreens("encuentra_2_screen")
    object Encuentra3Screen: AppScreens("encuentra_3_screen")
    object NotificationsScreen: AppScreens("notifications_screen")
    object PerfilesMascotaScreen: AppScreens("perfiles_mascota_screen")
}