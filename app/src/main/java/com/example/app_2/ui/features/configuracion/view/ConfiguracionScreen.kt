package com.example.app_2.ui.features.configuracion.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.ui.features.configuracion.components.AccessSection
import com.example.app_2.ui.features.configuracion.components.NotificationsSection
import com.example.app_2.ui.features.configuracion.components.PersonalizationSection
import com.example.app_2.ui.features.configuracion.components.SettingsHeader
import com.example.app_2.ui.theme.AppTheme

@Composable
fun ConfiguracionScreen(navController: NavController) {
    // Estados para los switches
    var modoOscuroActivado by remember { mutableStateOf(false) }
    var accesoUbicacionActivado by remember { mutableStateOf(true) }
    var accesoFotoActivado by remember { mutableStateOf(true) }
    var notificacionesActivadas by remember { mutableStateOf(true) }
    var notificacionesCorreoActivadas by remember { mutableStateOf(true) }

    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            // Contenido de la pantalla de ajustes
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(30.dp))
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(horizontal = 20.dp)
            ) {
                SettingsHeader(navController = navController)

                PersonalizationSection(
                    modoOscuroActivado = modoOscuroActivado,
                    onModoOscuroChanged = { modoOscuroActivado = it }
                )

                AccessSection(
                    accesoUbicacionActivado = accesoUbicacionActivado,
                    onAccesoUbicacionChanged = { accesoUbicacionActivado = it },
                    accesoFotoActivado = accesoFotoActivado,
                    onAccesoFotoChanged = { accesoFotoActivado = it }
                )

                NotificationsSection(
                    notificacionesActivadas = notificacionesActivadas,
                    onNotificacionesChanged = { notificacionesActivadas = it },
                    notificacionesCorreoActivadas = notificacionesCorreoActivadas,
                    onNotificacionesCorreoChanged = { notificacionesCorreoActivadas = it }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConfiguracionScreenPreview() {
    ConfiguracionScreen(navController = rememberNavController())
}