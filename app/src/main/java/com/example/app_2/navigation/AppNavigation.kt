package com.example.app_2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.app_2.ui.features.auth.inicio.view.InicioScreen
import com.example.app_2.ui.features.carga.view.CargaScreen
import com.example.app_2.ui.features.Maps.view.MapaScreen
import com.example.app_2.ui.features.Registrar_mascota.view.RegistrarMascotaScreen
import com.example.app_2.ui.features.auth.login.view.LoginScreen
import com.example.app_2.ui.features.auth.register.view.RegisterScreen
import com.example.app_2.ui.features.buscar.view.BuscarScreen
import com.example.app_2.ui.features.chat.view.ChatScreen
import com.example.app_2.ui.features.configuracion.view.ConfiguracionScreen
import com.example.app_2.ui.features.encuentra.view.FindScreen
import com.example.app_2.ui.features.encuentra.view.FindScreen2
import com.example.app_2.ui.features.encuentra.view.FindScreen3
import com.example.app_2.ui.features.home.view.PrincipalScreen
import com.example.app_2.ui.features.notifications.view.NotificationsScreen
import com.example.app_2.ui.features.perfil_mascota.view.PetPerfilScreen
import com.example.app_2.ui.features.perfil_usuario.view.PantallaPerfilUsuario
import com.example.app_2.ui.features.perfiles_mascota.view.PerfilesMascotaScreen
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var startDestination by remember { mutableStateOf<String?>(null) }

    // Determina el destino inicial de forma asíncrona
    LaunchedEffect(Unit) {
        delay(2000)
        val currentUser = FirebaseAuth.getInstance().currentUser
        startDestination = if (currentUser != null) {
            AppScreens.PrincipalScreen.route
        } else {
            AppScreens.InicioScreen.route
        }
    }

    // Muestra un composable de carga mientras se determina el destino
    if (startDestination == null) {
        CargaScreen() // O un composable de carga genérico
        return
    }

    NavHost(
        navController = navController,
        startDestination = startDestination!!
    ) {
        composable(route = AppScreens.PrincipalScreen.route) {
            PrincipalScreen(navController = navController)
        }
        composable(route = AppScreens.InicioScreen.route) {
            InicioScreen(navController = navController)
        }
        composable(route = AppScreens.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(route = AppScreens.BuscarScreen.route) {
            BuscarScreen(navController = navController)
        }
        composable(route = AppScreens.ConfiguracionScreen.route){
            ConfiguracionScreen(navController = navController)
        }
        composable(
            route = AppScreens.PerfilMascotaScreen.route + "/{petId}",
            arguments = listOf(navArgument("petId") { type = NavType.StringType })
        ) {
            PetPerfilScreen(navController = navController)
        }
        composable(route = AppScreens.Encuentra1Screen.route){
            FindScreen(navController = navController)
        }
        composable(route = AppScreens.PerfilUsuarioScreen.route) {
            PantallaPerfilUsuario(navController = navController)
        }
        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = AppScreens.RegistrarMascotaScreen.route) {
            RegistrarMascotaScreen(navController = navController)
        }
        composable(route = AppScreens.MapaScreen.route) {
            MapaScreen(onBackClick = { navController.popBackStack() })
        }
        composable(
            route = AppScreens.ChatScreen.route + "/{petId}",
            arguments = listOf(navArgument("petId") { type = NavType.StringType})
        ){
            ChatScreen(navController = navController)
        }
        composable(route = AppScreens.Encuentra2Screen.route) {
            FindScreen2(navController = navController)
        }
        composable(route = AppScreens.Encuentra3Screen.route) {
            FindScreen3(navController = navController)
        }
        composable(route = AppScreens.NotificationsScreen.route) {
            NotificationsScreen()
        }
        composable(route = AppScreens.PerfilesMascotaScreen.route) {
            PerfilesMascotaScreen(navController = navController)
        }
    }
}
