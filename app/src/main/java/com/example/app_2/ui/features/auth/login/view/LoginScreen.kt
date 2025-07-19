package com.example.app_2.ui.features.auth.login.view

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.app_2.navigation.AppScreens
import com.example.app_2.ui.features.auth.login.components.BackgroundDecorations
import com.example.app_2.ui.features.auth.login.components.Footer
import com.example.app_2.ui.features.auth.login.components.InputSection
import com.example.app_2.ui.features.auth.login.components.LogoSection
import com.example.app_2.ui.features.auth.login.components.SocialSection
import com.example.app_2.ui.features.auth.login.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(key1 = state) {
        if (state.loginSuccess) {
            navController.navigate(AppScreens.PantallaPrincipal.route) {
                popUpTo(AppScreens.InicioScreen.route) { inclusive = true }
            }
            viewModel.onLoginSuccessHandled()
        }
        state.error?.let {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            viewModel.onLoginSuccessHandled() // Also clear error state
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        BackgroundDecorations()

        Column(modifier = Modifier.fillMaxSize()) {
            LogoSection(Modifier.weight(1f))

            InputSection(
                email = viewModel.email,
                onEmailChange = { viewModel.email = it },
                password = viewModel.password,
                onPasswordChange = { viewModel.password = it },
                onForgotPassword = { /* TODO: flujo recuperación */ },
                onLogin = { viewModel.onLoginClicked() },
                modifier = Modifier.weight(2f)
            )

            SocialSection(
                onGoogle = { /* TODO */ },
                onFacebook = { /* TODO */ },
                onApple = { /* TODO */ },
                modifier = Modifier.weight(1.5f)
            )

            Footer(Modifier.weight(0.2f))
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}