package com.example.app_2.ui.features.perfil_usuario.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.R
import com.example.app_2.ui.features.perfil_usuario.components.ContactInfo
import com.example.app_2.ui.features.perfil_usuario.components.OpcionMenuMejorada
import com.example.app_2.ui.features.perfil_usuario.components.ProfileHeader
import com.example.app_2.ui.theme.AppTheme

@Composable
fun PantallaPerfilUsuario(navController: NavController) {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background), // Fondo gris claro
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ProfileHeader()

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre del usuario
            Text(
                text = "Alexiña Aguilar",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(24.dp))

            ContactInfo()

            Spacer(modifier = Modifier.height(24.dp))

            // Opciones del menú
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                OpcionMenuMejorada(
                    icono = R.drawable.ic_perfil,
                    texto = "Acerca de mí",
                    flechaIcono = R.drawable.ir,
                    ruta = "acerca_de_mi", // Ruta específica
                    navController = navController
                )

                OpcionMenuMejorada(
                    icono = R.drawable.ic_ubi,
                    texto = "Mi dirección",
                    flechaIcono = R.drawable.ir,
                    ruta = "mi_direccion", // Ruta específica
                    navController = navController
                )

                OpcionMenuMejorada(
                    icono = R.drawable.ic_agre_mas,
                    texto = "Agregar Mascota",
                    flechaIcono = R.drawable.ir,
                    ruta = "registrar_mascota", // Ruta específica
                    navController = navController
                )

                OpcionMenuMejorada(
                    icono = R.drawable.ic_conf,
                    texto = "Configuración",
                    flechaIcono = R.drawable.ir,
                    ruta = "configuracion", // Ruta específica
                    navController = navController
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPerfilUsuarioPreview() {
    PantallaPerfilUsuario(navController = rememberNavController())
}