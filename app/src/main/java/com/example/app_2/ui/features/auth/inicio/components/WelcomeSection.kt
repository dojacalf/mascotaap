package com.example.app_2.ui.features.auth.inicio.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun WelcomeSection(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hey! ¡Bienvenido! 😊",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(vertical = 15.dp)
        )

        Text(
            text = buildAnnotatedString {
                append("Aquí Cada Huellita Cuenta y\n")
                append("Cada Historia Merece Un Final\n")
                append("Feliz 💗")
            },
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 30.dp)
        )

        Spacer(Modifier.height(40.dp))

        StartButton(onClick = { navController.navigate("pet_screen") })
    }
}
