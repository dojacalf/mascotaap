package com.example.app_2.prueva_fire.ui.features.hola

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app_2.prueva_fire.data.AuthRepository

@Composable
fun HolaScreen(
    authRepository: AuthRepository,
    onLogout: () -> Unit
) {
    val viewModel: HolaViewModel = viewModel(factory = HolaViewModelFactory(authRepository))
    val user = viewModel.currentUser

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (user != null) {
            Text("¡Hola, ${user.email?.split("@")?.firstOrNull()}!", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {
                viewModel.logout()
                onLogout()
            }) {
                Text("Cerrar sesión")
            }
        } else {
            // This part should ideally not be reached if the navigation is correct
            Text("No se pudo cargar la información del usuario.")
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onLogout) {
                Text("Volver al inicio")
            }
        }
    }
}
