package com.example.app_2.ui.features.encuentra.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.app_2.R

@Composable
fun PetImageSection(
    imageRes: Int,
    startAnimation: Boolean
) {
    val offsetY by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else 100.dp,
        animationSpec = tween(800)
    )

    Box(
        modifier = Modifier
            .size(420.dp)
            .padding(12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.rectangleyellow),
            contentDescription = "Fondo decorativo",
            modifier = Modifier.fillMaxSize()
        )
        Image(
            painter = painterResource(id = R.drawable.patita),
            contentDescription = "Fondo patita",
            modifier = Modifier.fillMaxSize()
        )
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Mascota soñada",
            modifier = Modifier
                .size(350.dp)
                .align(Alignment.BottomCenter)
                .offset(y = offsetY)
        )
    }
}