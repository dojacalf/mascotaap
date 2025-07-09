package com.example.app_2.prueva_fire.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app_2.prueva_fire.data.AuthRepository
import com.example.app_2.prueva_fire.ui.features.auth.login.LoginScreen
import com.example.app_2.prueva_fire.ui.features.auth.register.RegisterScreen
import com.example.app_2.prueva_fire.ui.features.hola.HolaScreen

object Routes {
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val HOLA = "hola"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val authRepository = remember { AuthRepository() }

    NavHost(navController = navController, startDestination = Routes.LOGIN) {
        composable(Routes.LOGIN) {
            LoginScreen(
                authRepository = authRepository,
                onLoginSuccess = {
                    navController.navigate(Routes.HOLA) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                },
                onRegisterClick = { navController.navigate(Routes.REGISTER) }
            )
        }
        composable(Routes.REGISTER) {
            RegisterScreen(
                authRepository = authRepository,
                onRegisterSuccess = {
                    navController.navigate(Routes.HOLA) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                },
                onLoginClick = { navController.popBackStack() }
            )
        }
        composable(Routes.HOLA) {
            HolaScreen(
                authRepository = authRepository,
                onLogout = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.HOLA) { inclusive = true }
                    }
                }
            )
        }
    }
}
