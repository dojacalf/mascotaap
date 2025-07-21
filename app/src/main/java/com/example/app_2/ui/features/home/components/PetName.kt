package com.example.app_2.ui.features.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PetName(nombre: String) {
    Text(
        nombre,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(
            start = 12.dp,
            end = 12.dp,
            top = 8.dp,
            bottom = 12.dp
        )
    )
}