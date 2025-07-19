package com.example.app_2.ui.features.carga.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun LoadingTextSection() {
    Column {
        Text(
            text = "Cargando...",
            fontSize = 30.sp,
            style = MaterialTheme.typography.displayLarge // Uses Fredoka
        )
        Text(
            text = "Juntos crearemos familias felices",
            fontSize = 20.sp,
            style = MaterialTheme.typography.bodyLarge // Uses Fredoka
        )
    }
}
