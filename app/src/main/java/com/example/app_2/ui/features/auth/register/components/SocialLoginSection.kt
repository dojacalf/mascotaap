package com.example.app_2.ui.features.auth.register.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.app_2.R

@Composable
fun SocialLoginSection() {
    Spacer(Modifier.height(24.dp))

    SocialLoginSeparator()

    Spacer(Modifier.height(20.dp))

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        SocialButton(R.drawable.facebook)
        Spacer(Modifier.width(24.dp))
        SocialButton(R.drawable.google, hasBorder = true)
        Spacer(Modifier.width(24.dp))
        SocialButton(R.drawable.apple)
    }
}