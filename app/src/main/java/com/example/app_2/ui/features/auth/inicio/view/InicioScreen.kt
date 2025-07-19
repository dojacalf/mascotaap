package com.example.app_2.ui.features.auth.inicio.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.ui.features.auth.inicio.components.LoginSection
import com.example.app_2.ui.features.auth.inicio.components.LogoSection
import com.example.app_2.ui.features.auth.inicio.components.WelcomeSection
import com.example.app_2.ui.theme.AppTheme

@Composable
fun InicioScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(Modifier.height(0.dp))

            LogoSection(Modifier.weight(2f))

            WelcomeSection(navController, Modifier.weight(1f))

            LoginSection(navController, Modifier.weight(0.8f))

            Spacer(Modifier.height(32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InicioScreenPreview() {
    InicioScreen(navController = rememberNavController())
}