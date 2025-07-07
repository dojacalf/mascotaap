package com.example.app_2.ui.features.auth.login.view


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.ui.features.auth.login.components.BackgroundDecorations
import com.example.app_2.ui.features.auth.login.components.Footer
import com.example.app_2.ui.features.auth.login.components.InputSection
import com.example.app_2.ui.features.auth.login.components.LogoSection
import com.example.app_2.ui.features.auth.login.components.SocialSection


@Composable
fun LoginScreen(navController: NavController) {
    var email    by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(modifier =
        Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        BackgroundDecorations()

        Column(modifier = Modifier.fillMaxSize()) {
            LogoSection(Modifier.weight(1f))

            InputSection(
                email            = email,
                onEmailChange    = { email = it },
                password         = password,
                onPasswordChange = { password = it },
                onForgotPassword = { /* TODO: flujo recuperación */ },
                onLogin          = { navController.navigate("principal") },
                modifier = Modifier.weight(2f)
            )

            SocialSection(
                onGoogle   = { /* TODO */ },
                onFacebook = { /* TODO */ },
                onApple    = { /* TODO */ },
                modifier   = Modifier.weight(1.5f)
            )

            Footer(Modifier.weight(0.2f))
        }
    }
}
