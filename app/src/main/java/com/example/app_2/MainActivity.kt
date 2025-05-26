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
import com.example.app_2.sebastian.PetScreen
import com.example.app_2.sebastian.PreviewPantallaRegistroMascota


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Es buena práctica envolver tu navegación en tu tema de la App si tienes uno
            // TuAppTheme {
            PreviewPantallaRegistroMascota()
            // }
        }
    }
}

@Composable
fun NavigationApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio_screen"// Iniciar en InicioScreen
    ) {
        composable("inicio_screen") {
            // Pasa el navController a InicioScreen
            InicioScreen(navController = navController)
        }
        composable("login_screen") {
            LoginScreen() // Asumo que LoginScreen no necesita el navController directamente para su contenido inicial
            // o que lo gestiona internamente si tiene más navegación.
        }
        composable("registro") {
            Registro()// Asumo que LoginScreen no necesita el navController directamente para su contenido inicial
            // o que lo gestiona internamente si tiene más navegación.
        }
        composable("encuentra1") {
            PetScreen()// Asumo que LoginScreen no necesita el navController directamente para su contenido inicial
            // o que lo gestiona internamente si tiene más navegación.
        }

    }
}
