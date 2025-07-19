package com.example.app_2.ui.features.auth.register.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.navigation.AppScreens
import com.example.app_2.ui.features.auth.register.components.FooterSection
import com.example.app_2.ui.features.auth.register.components.FormSection
import com.example.app_2.ui.features.auth.register.components.HeaderSection
import com.example.app_2.ui.features.auth.register.components.SocialLoginSection
import com.example.app_2.ui.features.auth.register.viewmodel.AuthState
import com.example.app_2.ui.features.auth.register.viewmodel.RegisterViewModel
import com.example.app_2.ui.theme.AppTheme

@Composable
fun Registro(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val authState by viewModel.authState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(authState) {
        when (authState) {
            is AuthState.Success -> {
                navController.navigate(AppScreens.PrincipalScreen.route) {
                    popUpTo(AppScreens.InicioScreen.route) { inclusive = true }
                }
            }
            is AuthState.Error -> {
                Toast.makeText(context, (authState as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            }
            else -> Unit
        }
    }

    AppTheme {
        Box(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeaderSection()
                FormSection(
                    email = email,
                    onEmailChange = { email = it },
                    password = password,
                    onPasswordChange = { password = it },
                    onRegisterClick = { viewModel.createAccount(email, password) },
                    authState = authState
                )
                SocialLoginSection()
                FooterSection()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistroPreview() {
    Registro(navController = rememberNavController())
}