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
fun PersonalizationSection(
    modoOscuroActivado: Boolean,
    onModoOscuroChanged: (Boolean) -> Unit
) {
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
        onSwitchChanged = onModoOscuroChanged
    )

    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
}