package com.example.app_2.ui.features.configuracion.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_2.R

@Composable
fun NotificationsSection(
    notificacionesActivadas: Boolean,
    onNotificacionesChanged: (Boolean) -> Unit,
    notificacionesCorreoActivadas: Boolean,
    onNotificacionesCorreoChanged: (Boolean) -> Unit
) {
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
        onSwitchChanged = onNotificacionesChanged
    )

    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

    // Elemento Notificaciones por correo
    SettingsItem(
        iconRes = R.drawable.p7,
        title = "Notificaciones por correo electrónico",
        subtitle = "Recibe actualizaciones periódicas",
        hasSwitch = true,
        switchState = notificacionesCorreoActivadas,
        onSwitchChanged = onNotificacionesCorreoChanged
    )
}