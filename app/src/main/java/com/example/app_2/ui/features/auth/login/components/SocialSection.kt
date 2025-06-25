package com.example.app_2.ui.features.auth.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
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
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        SocialButton(R.drawable.google,   "Google",   onGoogle)
        Spacer(Modifier.height(12.dp))
        SocialButton(R.drawable.facebook, "Facebook", onFacebook)
        Spacer(Modifier.height(12.dp))
        SocialButton(R.drawable.apple,    "Apple",    onApple)
    }
}
