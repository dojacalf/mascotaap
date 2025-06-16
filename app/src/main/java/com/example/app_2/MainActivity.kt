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
import com.example.app_2.Provarjetpack.carga
import com.example.app_2.ui.featues.configuracion.view.AjustesScreen
import com.example.app_2.ui.featues.chat.view.ChatSimpleScreen
import com.example.app_2.ui.featues.perfil_mascota.view.Frame4
import com.example.app_2.ui.featues.notifications.view.NotificationsScreen
import com.example.app_2.ui.featues.perfil_usuario.view.PantallaPerfilUsuario
import com.example.app_2.ui.featues.home.view.PantallaPrincipal
import com.example.app_2.ui.featues.encuentra.PetScreen
import com.example.app_2.ui.featues.Registrar_mascota.view.RegistroMascota
import com.example.app_2.ui.featues.buscar.view.SearchScreen
import perfilpets


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationApp()
            //Frame4()
        }
    }
}

@Composable
fun NavigationApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "carga"
    ) {
        composable("carga") {
            carga(navController = navController)
        }
        composable("inicio_screen") {
            InicioScreen(navController = navController)
        }
        composable("login_screen") {
            LoginScreen(navController = navController)
        }
        composable("registro") {
            Registro(navController = navController)
        }
        composable("encuentra1") {
            PetScreen(navController = navController)
        }
        composable("principal") {
            PantallaPrincipal(navController = navController)
        }
        composable("registrar_mascota") {
            RegistroMascota(onSubmit = { navController.navigate("principal") })
        }
        composable("perfil usuario") {
            PantallaPerfilUsuario(navController = navController)
        }
        composable("busqueda") {
            SearchScreen(navController= navController)
        }
        composable("notificaciones") {
            NotificationsScreen()
        }
        composable("mascota") {
            Frame4(navController = navController)
        }
        composable("chat") {
            ChatSimpleScreen(navController= navController)
        }
        composable("configuracion") {
            AjustesScreen(navController= navController)
        }

        composable("ver_todo") {
            perfilpets()
        }
    }
}
