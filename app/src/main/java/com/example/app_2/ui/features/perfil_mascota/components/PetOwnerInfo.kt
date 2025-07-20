package com.example.app_2.ui.features.perfil_mascota.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun datos_del_dueño(
    ownerName: String,
    petName: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Text(
            text = ownerName,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = "Dueño de $petName",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
