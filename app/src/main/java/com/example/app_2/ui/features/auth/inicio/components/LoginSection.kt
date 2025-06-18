package com.example.app_2.ui.features.auth.inicio.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.app_2.ui.theme.Amarillo

@Composable
fun LoginSection(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Crea una cuenta",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .clickable { navController.navigate("registro") }
        )

        Text(
            text = "Iniciar Sesión",
            style = MaterialTheme.typography.headlineMedium.copy(color = Amarillo),
            modifier = Modifier.clickable { navController.navigate("login_screen") }
        )
    }
}
