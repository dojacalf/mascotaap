package com.example.app_2.ui.features.encuentra.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ContinueButtonSection(
    navController: NavController,
    buttonText: String,
    startAnimation: Boolean
) {
    val buttonScale by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0.95f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1200
                0.95f at 0
                1f at 400
                0.97f at 800
                1f at 1200
            },
            repeatMode = RepeatMode.Restart
        )
    )

    Spacer(modifier = Modifier.height(48.dp))

    Box(modifier = Modifier.scale(buttonScale)) {
        Button(
            onClick = {
                navController.navigate("principal")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier.width(200.dp)
        ) {
            Text(buttonText, fontSize = 21.sp)
        }
    }
}