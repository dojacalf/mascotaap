package com.example.app_2.ui.features.auth.inicio.components


import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.app_2.ui.theme.Amarillo
import com.example.app_2.ui.theme.AppShapes

@Composable
fun StartButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick  = onClick,
        modifier = modifier,
        colors   = ButtonDefaults.buttonColors(containerColor = Amarillo),
        shape    = AppShapes.large
    ) {
        Text(
            text  = "EMPEZAR",
            style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.onPrimary)
        )
    }
}