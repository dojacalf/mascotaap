package com.example.app_2.Provarjetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_2.R
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("inicio_screen") {
            popUpTo("carga_screen") { inclusive = true }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column() {
            Box(
                modifier = Modifier
                    .weight(4f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.perrologo),
                    contentDescription = "Logo de perro"
                )
            }
            Box(
                modifier = Modifier
                    .weight(4f)
                    .background(Color.Cyan)
            )
            Box(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text(
                        text = "Cargando...",
                        fontSize = 30.sp,
                        style = MaterialTheme.typography.displayLarge // Uses Fredoka
                    )
                    Text(
                        text = "Juntos crearemos fimilas felises",
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.bodyLarge // Uses Fredoka
                    )
                }
            }
        }
    }
}
