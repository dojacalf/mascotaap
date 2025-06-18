package com.example.app_2.Provarjetpack

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.app_2.ui.features.auth.inicio.components.LoginSection
import com.example.app_2.ui.features.auth.inicio.components.LogoSection
import com.example.app_2.ui.features.auth.inicio.components.WelcomeSection

@Composable
fun InicioScreen(navController: NavController) {
    Column(Modifier.fillMaxSize()) {
        LogoSection(Modifier.weight(6f))
        WelcomeSection(navController, Modifier.weight(4f))
        LoginSection(navController, Modifier.weight(3f))
    }
}