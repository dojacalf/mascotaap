package com.example.app_2.ui.features.perfil_usuario.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_2.R

@Composable
fun PantallaPerfilUsuario(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)), // Fondo gris claro
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Sección superior con imagen de fondo y foto de perfil
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
        ) {
            // Imagen de fondo
            Image(
                painter = painterResource(id = R.drawable.dcori),
                contentDescription = "Imagen de fondo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            // Ícono de mascota en la esquina superior derecha
            IconButton(
                onClick = { /* Acción */ },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.perrologo),
                    contentDescription = "Mascota",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }

            // Imagen de perfil circular
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dcori), // Cambia esto por tu imagen de perfil
                    contentDescription = "Foto de perfil",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(4.dp, Color.White, CircleShape),
                    contentScale = ContentScale.Crop
                )

                // Botón de editar
                IconButton(
                    onClick = { /* Acción editar */ },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE91E63))
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = "Editar",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Nombre del usuario
        Text(
            text = "Alexiña Aguilar",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Tarjeta de información de contacto
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                // Email
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.mail),
                        contentDescription = "Email",
                        modifier = Modifier.size(20.dp),
                        tint = Color(0xFF666666)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "aguilaralexiña@gmail.com",
                        fontSize = 14.sp,

                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Teléfono
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.llamarsvg),
                        contentDescription = "Teléfono",
                        modifier = Modifier.size(20.dp),
                        tint = Color(0xFF666666)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "922191501",
                        fontSize = 14.sp,
                        color = Color(0xFF666666)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Opciones del menú
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            OpcionMenuMejorada(
                icono = R.drawable.ic_perfil,
                texto = "Acerca de mí",
                flechaIcono = R.drawable.ir,
                ruta = "acerca_de_mi", // Ruta específica
                navController = navController
            )

            OpcionMenuMejorada(
                icono = R.drawable.ic_ubi,
                texto = "Mi dirección",
                flechaIcono = R.drawable.ir,
                ruta = "mi_direccion", // Ruta específica
                navController = navController
            )

            OpcionMenuMejorada(
                icono = R.drawable.ic_agre_mas,
                texto = "Agregar Mascota",
                flechaIcono = R.drawable.ir,
                ruta = "registrar_mascota", // Ruta específica
                navController = navController
            )

            OpcionMenuMejorada(
                icono = R.drawable.ic_conf,
                texto = "Configuración",
                flechaIcono = R.drawable.ir,
                ruta = "configuracion", // Ruta específica
                navController = navController
            )
        }
    }
}

@Composable
fun OpcionMenuMejorada(
    icono: Int,
    texto: String,
    flechaIcono: Int,
    ruta: String,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { navController.navigate(ruta) },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = icono),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color(0xFF666666)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = texto,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            Icon(
                painter = painterResource(id = flechaIcono),
                contentDescription = "Ir",
                modifier = Modifier.size(20.dp),
                tint = Color(0xFF999999)
            )
        }
    }
}
/*
@Preview(showBackground = true)
@Composable
fun PreviewPantallaPerfilUsuario() {
    MaterialTheme {
        PantallaPerfilUsuario(navController = navController)
    }
}*/