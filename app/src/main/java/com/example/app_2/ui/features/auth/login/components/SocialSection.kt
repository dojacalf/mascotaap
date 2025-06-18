package com.example.app_2.ui.features.auth.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_2.R

@Composable
fun SocialSection(
    onGoogle: () -> Unit,
    onFacebook: () -> Unit,
    onApple: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(24.dp))

        Text(
            "O conéctate con",
            fontSize = 16.sp,
            color = CaptionGrey,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        SocialButton(R.drawable.google,   "Iniciar Sesión Con Google",   onGoogle)
        Spacer(Modifier.height(12.dp))
        SocialButton(R.drawable.facebook, "Iniciar Sesión Con Facebook", onFacebook)
        Spacer(Modifier.height(12.dp))
        SocialButton(R.drawable.apple,    "Iniciar Sesión Con Apple",    onApple)
    }
}
