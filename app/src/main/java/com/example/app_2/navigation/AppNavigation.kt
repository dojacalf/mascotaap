package com.example.app_2.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app_2.Provarjetpack.InicioScreen
import com.example.app_2.ui.features.auth.login.view.LoginScreen
import com.example.app_2.ui.features.auth.register.view.Registro

@Composable
fun AppNavigation() {
    // 1. Crea una instancia del NavController
    val navController = rememberNavController()

    // 2. Define el NavHost, que es el contenedor de tus pantallas
    NavHost(
        navController = navController,
        startDestination = AppScreens.LoginScreen.route // La pantalla inicial
    ) {
        // 3. Define cada pantalla (destino) del grafo
        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(route = AppScreens.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }

        composable(route = AppScreens.InicioScreen.route) {
            InicioScreen(navController = navController)
        }
    }
}