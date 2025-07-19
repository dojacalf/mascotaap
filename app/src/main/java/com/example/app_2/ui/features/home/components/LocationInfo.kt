package com.example.app_2.ui.features.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun LocationInfo() {
    Column {
        Text(
            text = "Ubicación",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = "Salcedo, Puno",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}