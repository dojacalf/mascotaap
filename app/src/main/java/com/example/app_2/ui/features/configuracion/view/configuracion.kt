package com.example.app_2.ui.features.configuracion.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_2.R

@Composable
fun AjustesScreen(navController: NavController) {
    // Estados para los switches
    var modoOscuroActivado by remember { mutableStateOf(false) }
    var accesoUbicacionActivado by remember { mutableStateOf(true) }
    var accesoFotoActivado by remember { mutableStateOf(true) }
    var notificacionesActivadas by remember { mutableStateOf(true) }
    var notificacionesCorreoActivadas by remember { mutableStateOf(true) }

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
            // Cabecera con título y flecha de retroceso
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            navController.navigateUp()
                        }
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Ajustes",
                    modifier = Modifier.padding(20.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            // Sección de Personalización
            Text(
                text = "Personalización",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 12.dp)
            )

            // Elemento Huso horario
            SettingsItem(
                iconRes = R.drawable.p1,
                title = "Uso horario",
                subtitle = "Elige tu zona horaria",
                hasSwitch = false
            )

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            // Elemento Idioma
            SettingsItem(
                iconRes = R.drawable.p2,
                title = "Idioma",
                subtitle = "Establece tu idioma",
                hasSwitch = false
            )

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            // Elemento Modo oscuro
            SettingsItem(
                iconRes = R.drawable.p3,
                title = "Modo oscuro",
                subtitle = "Elige el modo de visualización",
                hasSwitch = true,
                switchState = modoOscuroActivado,
                onSwitchChanged = { modoOscuroActivado = it }
            )

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            // Sección de Acceso
            Text(
                text = "Acceso",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 20.dp, bottom = 12.dp)
            )

            // Elemento Acceso a ubicación
            SettingsItem(
                iconRes = R.drawable.p4,
                title = "Acceso a la ubicación",
                subtitle = "Acceso a tu ubicación",
                hasSwitch = true,
                switchState = accesoUbicacionActivado,
                onSwitchChanged = { accesoUbicacionActivado = it }
            )

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            // Elemento Acceso a fotos
            SettingsItem(
                iconRes = R.drawable.p5,
                title = "Acceso a la foto",
                subtitle = "Acceso a tus medios",
                hasSwitch = true,
                switchState = accesoFotoActivado,
                onSwitchChanged = { accesoFotoActivado = it }
            )

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            // Sección de Notificaciones
            Text(
                text = "Notificaciones",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 20.dp, bottom = 12.dp)
            )

            // Elemento Notificaciones
            SettingsItem(
                iconRes = R.drawable.p6,
                title = "Notificaciones",
                subtitle = "Recibe notificaciones automáticas",
                hasSwitch = true,
                switchState = notificacionesActivadas,
                onSwitchChanged = { notificacionesActivadas = it }
            )

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            // Elemento Notificaciones por correo
            SettingsItem(
                iconRes = R.drawable.p7,
                title = "Notificaciones por correo electrónico",
                subtitle = "Recibe actualizaciones periódicas",
                hasSwitch = true,
                switchState = notificacionesCorreoActivadas,
                onSwitchChanged = { notificacionesCorreoActivadas = it }
            )
        }
    }
}

@Composable
private fun SettingsItem(
    iconRes: Int,
    title: String,
    subtitle: String,
    hasSwitch: Boolean,
    switchState: Boolean = false,
    onSwitchChanged: (Boolean) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = subtitle,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodySmall
            )
        }

        if (hasSwitch) {
            Switch(
                checked = switchState,
                onCheckedChange = onSwitchChanged,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colorScheme.onPrimary,
                    checkedTrackColor = MaterialTheme.colorScheme.primary,
                    uncheckedThumbColor = MaterialTheme.colorScheme.outline,
                    uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant
                )
            )
        } else {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Ir a detalle",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}