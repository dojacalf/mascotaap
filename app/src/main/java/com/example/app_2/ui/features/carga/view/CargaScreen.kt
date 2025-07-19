package com.example.app_2.ui.features.carga.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.ui.features.carga.components.LoadingTextSection
import com.example.app_2.ui.features.carga.components.LogoSection
import com.example.app_2.ui.theme.AppTheme
import kotlinx.coroutines.delay

@Composable
fun CargaScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("inicio_screen") {
            popUpTo("carga_screen") { inclusive = true }
        }
    }

    AppTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                LogoSection(
                    modifier = Modifier
                        .weight(4f)
                )
                Box(
                    modifier = Modifier
                        .weight(4f)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                )
                Box(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    LoadingTextSection()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    CargaScreen(navController = rememberNavController())
}
