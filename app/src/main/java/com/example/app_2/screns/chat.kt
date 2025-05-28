package com.example.app_2.screns

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigator

// Colores personalizados para el chat
val LightGreen = Color(0xFFE2F7D2)
val BackgroundGreen = Color(0xFFECF9E0)
val LightBlue = Color(0xFFDCF8FF)
val SendButtonBlue = Color(0xFF267DFF)


@Composable
fun ChatSimpleScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundGreen)
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver",
                        tint = Color.Black,
                        modifier = Modifier.padding(8.dp).clickable {
                            navController.navigateUp()
                        }

                    )

                    // Avatar del contacto
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFFFCC80))
                    ) {
                        // Aquí iría la imagen del avatar
                        // (en este caso usamos un color para simplificar)
                    }

                    // Nombre del contacto
                    Text(
                        text = "Daniel Gusman",
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 12.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )

                    // Botón de llamada
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Llamar",
                        tint = Color(0xFFFF3D00),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }

            // Área de mensajes
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {

                }
            }

            // Barra inferior de entrada de texto
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .background(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Botón de añadir contenido
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Añadir",
                        tint = Color.Gray,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(24.dp)
                    )

                    // Campo de texto (simulado)
                    Box(

                        modifier = Modifier
                            .weight(1f)
                            .height(40.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .padding(start = 16.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    // Botón de enviar
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(SendButtonBlue),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = "Enviar",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            // Barra navegación inferior
            Divider(
                color = Color.Transparent,
                thickness = 20.dp
            )
        }
    }
}

