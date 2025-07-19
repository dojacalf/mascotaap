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
fun AccessSection(
    accesoUbicacionActivado: Boolean,
    onAccesoUbicacionChanged: (Boolean) -> Unit,
    accesoFotoActivado: Boolean,
    onAccesoFotoChanged: (Boolean) -> Unit
) {
    Text(
        text = "Acceso",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(top = 20.dp, bottom = 12.dp)
    )

    // Elemento Acceso a ubicaci��n
    SettingsItem(
        iconRes = R.drawable.p4,
        title = "Acceso a la ubicación",
        subtitle = "Acceso a tu ubicación",
        hasSwitch = true,
        switchState = accesoUbicacionActivado,
        onSwitchChanged = onAccesoUbicacionChanged
    )

    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

    // Elemento Acceso a fotos
    SettingsItem(
        iconRes = R.drawable.p5,
        title = "Acceso a la foto",
        subtitle = "Acceso a tus medios",
        hasSwitch = true,
        switchState = accesoFotoActivado,
        onSwitchChanged = onAccesoFotoChanged
    )

    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
}