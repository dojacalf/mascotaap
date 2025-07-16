package com.example.app_2.ui.features.auth.login.view

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.*
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
import com.example.app_2.ui.features.auth.register.viewmodel.AuthState

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val authState by viewModel.authState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(authState) {
        when (authState) {
            is AuthState.Success -> {
                navController.navigate(AppScreens.PantallaPrincipal.route) {
                    popUpTo(AppScreens.InicioScreen.route) { inclusive = true }
                }
            }
            is AuthState.Error -> {
                Toast.makeText(context, (authState as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            }
            else -> Unit
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
                email = email,
                onEmailChange = { email = it },
                password = password,
                onPasswordChange = { password = it },
                onForgotPassword = { /* TODO: flujo recuperación */ },
                onLogin = { viewModel.signIn(email, password) },
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
    }
}
