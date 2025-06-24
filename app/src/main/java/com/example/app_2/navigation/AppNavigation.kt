package com.example.app_2.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app_2.Provarjetpack.InicioScreen
import com.example.app_2.Provarjetpack.LoadingScreen
import com.example.app_2.ui.features.auth.login.view.LoginScreen
import com.example.app_2.ui.features.auth.register.view.Registro
import com.example.app_2.ui.features.buscar.view.SearchScreen
import com.example.app_2.ui.features.encuentra.PetScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    var isAppReady by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.Main.immediate) {
            yield()
            isAppReady = true
        }
    }

    val startDestination = when {
        !isAppReady -> AppScreens.LoadingScreen.route
        else -> AppScreens.InicioScreen.route
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
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
        composable(route = AppScreens.LoadingScreen.route) {
            LoadingScreen(navController = navController)
        }
    }
}