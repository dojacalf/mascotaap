package com.example.app_2.ui.features.auth.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.app_2.R

@Composable
fun BackgroundDecorations() {
    Image(
        painter = painterResource(id = R.drawable.buenperro),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier.fillMaxSize()
    )

    // Círculos decorativos
    Box(
        Modifier
            .offset(x = 250.dp, y = (-120).dp)
            .size(200.dp)
            .clip(CircleShape)
            .background(AmarilloPrincipal)
    )

    Box(
        Modifier
            .offset(x = 350.dp, y = (-10).dp)
            .size(170.dp)
            .clip(CircleShape)
            .background(AmarilloPrincipal)
    )
}
