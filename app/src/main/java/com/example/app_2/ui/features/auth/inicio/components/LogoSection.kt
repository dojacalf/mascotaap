package com.example.app_2.ui.features.auth.inicio.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.app_2.R

@Composable
fun LogoSection(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.perro2),
            contentDescription = "Logo de la aplicación",
            modifier = Modifier.fillMaxWidth(0.5f),
            contentScale = ContentScale.Crop
        )
    }
}
