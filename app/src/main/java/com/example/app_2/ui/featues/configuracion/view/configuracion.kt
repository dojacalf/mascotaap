package com.example.app_2.ui.featues.configuracion.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_2.R

// Colores personalizados
val BackgroundColor = Color(0xFFF8F8F8)
val SwitchActiveColor = Color(0xFF007AFF)
val DividerColor = Color(0xFFEEEEEE)
val TextPrimaryColor = Color(0xFF000000)
val TextSecondaryColor = Color(0xFF8A8A8E)

//@Preview(showBackground = true)
@Composable
fun AjustesScreen(navController: NavController) {
    // Estados para los switches
    var modoOscuroActivado by remember { mutableStateOf(false) }
    var accesoUbicacionActivado by remember { mutableStateOf(true) }
    var accesoFotoActivado by remember { mutableStateOf(true) }
    var notificacionesActivadas by remember { mutableStateOf(true) }
    var notificacionesCorreoActivadas by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(16.dp)
    ) {
        // Contenido de la pantalla de ajustes
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(30.dp))
                .background(Color.White)
                .padding(horizontal = 20.dp)
        ) {
            // Cabecera con título y flecha de retroceso
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            navController.navigateUp()
                        }
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Ajustes",
                    modifier = Modifier.padding(20.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimaryColor
                )
            }

            // Sección de Personalización
            Text(
                text = "Personalización",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimaryColor,
                modifier = Modifier.padding(vertical = 12.dp)
            )

            // Elemento Huso horario
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFFE8E0FF)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.p1),
                        contentDescription = "Añadir",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Uso horario",
                        fontSize = 16.sp,
                        color = TextPrimaryColor
                    )
                    Text(
                        text = "Elige tu zona horaria",
                        fontSize = 12.sp,
                        color = TextSecondaryColor
                    )
                }

                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Ir a detalle",
                    tint = Color.Gray
                )
            }

            Divider(color = DividerColor)

            // Elemento Idioma
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFFE8E0FF)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.p2),
                        contentDescription = "Añadir",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Idioma",
                        fontSize = 16.sp,
                        color = TextPrimaryColor
                    )
                    Text(
                        text = "Establece tu idioma",
                        fontSize = 12.sp,
                        color = TextSecondaryColor
                    )
                }

                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Ir a detalle",
                    tint = Color.Gray
                )
            }

            Divider(color = DividerColor)

            // Elemento Modo oscuro
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFFE8E0FF)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.p3),
                        contentDescription = "Añadir",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Modo oscuro",
                        fontSize = 16.sp,
                        color = TextPrimaryColor
                    )
                    Text(
                        text = "Elige el modo de visualización",
                        fontSize = 12.sp,
                        color = TextSecondaryColor
                    )
                }

                Switch(
                    checked = modoOscuroActivado,
                    onCheckedChange = { modoOscuroActivado = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = SwitchActiveColor,
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = Color.LightGray
                    )
                )
            }

            Divider(color = DividerColor)

            // Sección de Acceso
            Text(
                text = "Acceso",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimaryColor,
                modifier = Modifier.padding(top = 20.dp, bottom = 12.dp)
            )

            // Elemento Acceso a ubicación
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFFE8E0FF)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.p4),
                        contentDescription = "Añadir",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Acceso a la ubicación",
                        fontSize = 16.sp,
                        color = TextPrimaryColor
                    )
                    Text(
                        text = "Acceso a tu ubicación",
                        fontSize = 12.sp,
                        color = TextSecondaryColor
                    )
                }

                Switch(
                    checked = accesoUbicacionActivado,
                    onCheckedChange = { accesoUbicacionActivado = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = SwitchActiveColor,
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = Color.LightGray
                    )
                )
            }

            Divider(color = DividerColor)

            // Elemento Acceso a fotos
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFFE8E0FF)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.p5),
                        contentDescription = "Añadir",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Acceso a la foto",
                        fontSize = 16.sp,
                        color = TextPrimaryColor
                    )
                    Text(
                        text = "Acceso a tus medios",
                        fontSize = 12.sp,
                        color = TextSecondaryColor
                    )
                }

                Switch(
                    checked = accesoFotoActivado,
                    onCheckedChange = { accesoFotoActivado = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = SwitchActiveColor,
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = Color.LightGray
                    )
                )
            }

            Divider(color = DividerColor)

            // Sección de Notificaciones
            Text(
                text = "Notificaciones",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimaryColor,
                modifier = Modifier.padding(top = 20.dp, bottom = 12.dp)
            )

            // Elemento Notificaciones
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFFE8E0FF)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.p6),
                        contentDescription = "Añadir",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Notificaciones",
                        fontSize = 16.sp,
                        color = TextPrimaryColor
                    )
                    Text(
                        text = "Recibe notificaciones automáticas",
                        fontSize = 12.sp,
                        color = TextSecondaryColor
                    )
                }

                Switch(
                    checked = notificacionesActivadas,
                    onCheckedChange = { notificacionesActivadas = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = SwitchActiveColor,
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = Color.LightGray
                    )
                )
            }

            Divider(color = DividerColor)

            // Elemento Notificaciones por correo
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFFE8E0FF)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.p7),
                        contentDescription = "Añadir",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Notificaciones por correo electrónico",
                        fontSize = 16.sp,
                        color = TextPrimaryColor
                    )
                    Text(
                        text = "Recibe actualizaciones periódicas",
                        fontSize = 12.sp,
                        color = TextSecondaryColor
                    )
                }

                Switch(
                    checked = notificacionesCorreoActivadas,
                    onCheckedChange = { notificacionesCorreoActivadas = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = SwitchActiveColor,
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = Color.LightGray
                    )
                )
            }
        }
    }
}
