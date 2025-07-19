package com.example.app_2.ui.features.encuentra.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.R
import com.example.app_2.ui.features.encuentra.components.ContinueButtonSection
import com.example.app_2.ui.features.encuentra.components.PetImageSection
import com.example.app_2.ui.features.encuentra.components.WelcomeTextSection
import com.example.app_2.ui.theme.AppTheme
import kotlinx.coroutines.delay

@Composable
fun FindScreen(navController: NavController) {
    var startAnimation by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(500)
        startAnimation = true
    }

    AppTheme {
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
                PetImageSection(
                    imageRes = R.drawable.f_cat,
                    startAnimation = startAnimation
                )

                Spacer(modifier = Modifier.height(32.dp))

                WelcomeTextSection(
                    title = "Encuentra aquí a tu\n mascota soñada",
                    subtitle = "Únete a nosotros y \n descubre la mejor \n mascota en tu ubicación"
                )

                ContinueButtonSection(
                    navController = navController,
                    buttonText = "Continuar",
                    startAnimation = startAnimation
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FindScreenPreview() {
    FindScreen(navController = rememberNavController())
}