// MainActivity.kt
package com.example.app_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app_2.Provarjetpack.InicioScreen
import com.example.app_2.Provarjetpack.LoginScreen
import com.example.app_2.Provarjetpack.Registro
import com.example.app_2.sebastian.PantallaPerfilUsuario
import com.example.app_2.sebastian.PantallaPrincipal
import com.example.app_2.sebastian.PantallaRegistroMascota
import com.example.app_2.sebastian.PetScreen
import com.example.app_2.sebastian.PreviewPantallaRegistroMascota


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Es buena práctica envolver tu navegación en tu tema de la App si tienes uno
            // TuAppTheme {
            NavigationApp()
            // }
        }
    }
}

@Composable
fun NavigationApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio_screen"
    ) {
        composable("inicio_screen") {
            InicioScreen(navController = navController)
        }
        composable("login_screen") {
            LoginScreen()
        }
        composable("registro") {
            Registro()
        }
        composable("encuentra1") {
            PetScreen()
        }
        composable("principal") {
            PantallaPrincipal()
        }
        composable("registrar_mascota") {
            PantallaRegistroMascota()
        }
        composable("perfil usuario") {
            PantallaPerfilUsuario()
        }

    }
}
