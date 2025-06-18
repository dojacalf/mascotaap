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
import com.example.app_2.Provarjetpack.Registro
import com.example.app_2.Provarjetpack.carga
import com.example.app_2.ui.features.configuracion.view.AjustesScreen
import com.example.app_2.ui.features.chat.view.ChatSimpleScreen
import com.example.app_2.ui.features.perfil_mascota.view.Frame4
import com.example.app_2.ui.features.notifications.view.NotificationsScreen
import com.example.app_2.ui.features.perfil_usuario.view.PantallaPerfilUsuario
import com.example.app_2.ui.features.home.view.PantallaPrincipal
import com.example.app_2.ui.features.encuentra.PetScreen
import com.example.app_2.ui.features.Registrar_mascota.view.RegistroMascota
import com.example.app_2.ui.features.buscar.view.SearchScreen
//import com.example.app_2.ui.featues.encuentra.MyAnimation
import perfilpets


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
  //          MyAnimation()
        }
    }
}

