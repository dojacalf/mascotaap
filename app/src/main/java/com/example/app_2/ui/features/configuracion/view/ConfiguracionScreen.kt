package com.example.app_2.ui.features.configuracion.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.ui.features.configuracion.components.AccessSection
import com.example.app_2.ui.features.configuracion.components.NotificationsSection
import com.example.app_2.ui.features.configuracion.components.PersonalizationSection
import com.example.app_2.ui.features.configuracion.components.SettingsHeader
import com.example.app_2.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfiguracionScreen(navController: NavController) {
    // Estados para los switches
    var modoOscuroActivado by remember { mutableStateOf(false) }
    var accesoUbicacionActivado by remember { mutableStateOf(true) }
    var accesoFotoActivado by remember { mutableStateOf(true) }
    var notificacionesActivadas by remember { mutableStateOf(true) }
    var notificacionesCorreoActivadas by remember { mutableStateOf(true) }

    AppTheme {
        Scaffold(
            topBar = { SettingsHeader(navController = navController) },
            containerColor = Color.Transparent
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(padding)
            ) {
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