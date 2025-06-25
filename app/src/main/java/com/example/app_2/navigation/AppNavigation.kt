package com.example.app_2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app_2.Provarjetpack.InicioScreen
import com.example.app_2.navigation.AppScreens.ConfiguracionScreen
import com.example.app_2.ui.features.auth.login.view.LoginScreen
import com.example.app_2.ui.features.auth.register.view.Registro
import com.example.app_2.ui.features.buscar.view.SearchScreen
import com.example.app_2.ui.features.configuracion.view.AjustesScreen
import com.example.app_2.ui.features.encuentra.PetScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.ConfiguracionScreen.route
    ) {
        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = AppScreens.InicioScreen.route) {
            InicioScreen(navController = navController)
        }
        composable(route = AppScreens.RegisterScreen.route) {
            Registro(navController = navController)
        }
        composable(route = AppScreens.PetScreen.route) {
            PetScreen(navController = navController)
        }
        composable(route = AppScreens.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
        composable(route = AppScreens.ConfiguracionScreen.route){
            AjustesScreen(navController = navController)
        }
    }
}
