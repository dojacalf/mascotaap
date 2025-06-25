package com.example.app_2.ui.features.auth.inicio.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginSection(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val colorScheme = MaterialTheme.colorScheme

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Crea una cuenta",
            style = MaterialTheme.typography.titleMedium,
            color = colorScheme.onSurfaceVariant,
            modifier = Modifier
                .clickable { navController.navigate("register_screen") }
                .padding(vertical = 8.dp, horizontal = 16.dp)
        )

        Text(
            text = "Iniciar Sesión",
            style = MaterialTheme.typography.titleLarge,
            color = colorScheme.primaryContainer,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .clickable { navController.navigate("login_screen") }
                .padding(vertical = 8.dp, horizontal = 16.dp)
        )
    }
}
