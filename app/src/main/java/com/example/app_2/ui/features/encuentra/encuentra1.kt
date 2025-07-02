package com.example.app_2.ui.features.encuentra

import android.os.Bundle
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Font
import androidx.navigation.NavController
import com.example.app_2.R
import kotlinx.coroutines.delay

@Composable
fun FindScreen(navController: NavController) {
    var startAnimation by remember { mutableStateOf(false) }

    // Iniciar animación después de que la pantalla cargue
    LaunchedEffect(Unit) {
        delay(500)
        startAnimation = true
    }

    // Animación de posición de la imagen
    val offsetY by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else 100.dp,
        animationSpec = tween(800)
    )

    // Animación de escala del botón (efecto pulso)
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

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.sky),
            contentDescription = "Fondo decorativo",
            modifier = Modifier
                .fillMaxWidth()
                .height(165.dp)
                .align(Alignment.TopStart),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

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
                    painter = painterResource(id = R.drawable.f_cat),
                    contentDescription = "Mascota soñada",
                    modifier = Modifier
                        .size(350.dp)
                        .align(Alignment.BottomCenter)
                        .offset(y = offsetY)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            val Fredoka = FontFamily(Font(R.font.fredoka_semibold))
            Text(
                text = "Encuentra aquí a tu\n mascota soñada",
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                lineHeight = 34.sp,
                color = Color(0xFF03063A),
                fontFamily = Fredoka,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            val Fredoka1 = FontFamily(Font(R.font.fredoka_regular))
            Column(
                modifier = Modifier.padding(vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Únete a nosotros y \n descubre la mejor \n mascota en tu ubicación",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF70717B),
                    fontFamily = Fredoka1
                )

                Spacer(modifier = Modifier.height(48.dp))

                Box(modifier = Modifier.scale(buttonScale)) {
                    Button(
                        onClick = {
                            navController.navigate("principal")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF64ADEF),
                            contentColor = Color.White
                        ),
                        modifier = Modifier.width(200.dp)
                    ) {
                        Text("Continuar", fontSize = 21.sp)
                    }
                }
            }
        }
    }
}