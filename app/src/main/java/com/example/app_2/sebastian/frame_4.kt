package com.example.app_2.sebastian

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.NavigateBefore
import androidx.compose.material.icons.automirrored.filled.ReadMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_2.R
import com.example.app_2.ui.theme.fredoka

@Preview
@Composable
fun Frame4() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF3DE)) // Color de fondo beige/crema
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Parte 1 - Imagen principal con botones superpuestos
            Box(
                modifier = Modifier
                    .weight(4f)
                    .fillMaxWidth()
            ) {
                // Imagen del gato
                Image(
                    painter = painterResource(id = R.drawable.gato2),
                    contentDescription = "michito 2 el 1 no era jpg",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)),
                    contentScale = ContentScale.Crop
                )

                // Botón retroceder
                boton_retroceder(
                    onClick = { /* Acción cuando se presiona */ },
                    modifier = Modifier
                        .padding(20.dp)
                        .align(Alignment.TopStart)
                )

                // Botón menú
                boton_2_puntos(
                    onClick = { /* Acción cuando se presiona */ },
                    modifier = Modifier
                        .padding(20.dp)
                        .align(Alignment.TopEnd)
                )
            }

            // Contenido inferior con fondo blanco redondeado
            Box(
                modifier = Modifier
                    .weight(6f)
                    .fillMaxWidth()
                    .background(
                        Color.White,
                        RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
                    .padding(20.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Parte 2 - Nombre y ubicación con botón like
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            nombre_de_mascota(
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            Ubicacion()
                        }

                        boton_de_like(
                            onClick = { /* Acción cuando se presiona */ },
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }

                    // Parte 3 - Información en tarjetas
                    parte_3(
                        modifier = Modifier.padding(bottom = 24.dp)
                    )

                    // Parte 4 - Información del dueño
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Imagen del dueño (placeholder circular)
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFFFB74D))
                                .border(2.dp, Color.Gray.copy(alpha = 0.3f), CircleShape)
                        )

                        datos_del_dueño(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 12.dp)
                        )

                        Boton_mensaje(
                            onClick = { /* Acción cuando se presiona */ },
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Boton_llamar(
                            onClick = { /* Acción cuando se presiona */ }
                        )
                    }

                    // Parte 5 - Descripción
                    Parte_5_descripcion(
                        modifier = Modifier
                            .weight(1f)
                            .padding(bottom = 20.dp)
                    )

                    // Parte 6 - Botón adoptar
                    Boton_adoptar(
                        onClick = { /* Acción cuando se presiona */ },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun Boton_adoptar(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(55.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2196F3)
        )
    ) {
        Text(
            "Adoptame",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun Parte_5_descripcion(
    modifier: Modifier = Modifier
) {
    Text(
        "Konynya es una gata que encontró su lugar en mi mundo, siempre buscando estar cerca para brindarme su companía. Es muy amorosa y le encantan las camas con las personas que no se conforman con lo que tienen, siempre quieren más.",
        modifier = modifier,
        fontSize = 14.sp,
        color = Color.Gray,
        lineHeight = 20.sp
    )
}

@Composable
fun Boton_llamar(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(40.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFEBEE)
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.NavigateBefore,
            contentDescription = "Llamar",
            tint = Color(0xFFE91E63),
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun Boton_mensaje(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(40.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFE6F4FF)
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Mensaje",
            tint = Color(0xFF2196F3),
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun datos_del_dueño(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            "Daniel Valencia",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            "Dueño del mascota",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun nombre_de_mascota(
    modifier: Modifier = Modifier
) {
    Text(
        "Kitty",
        modifier = modifier,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = fredoka,
        color = Color.Black
    )
}

@Composable
fun boton_2_puntos(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(45.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White.copy(alpha = 0.9f),
            contentColor = Color.Black
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ReadMore,
            contentDescription = "Menú",
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun boton_retroceder(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(45.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White.copy(alpha = 0.9f),
            contentColor = Color.Black
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.NavigateBefore,
            contentDescription = "Retroceder",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun boton_de_like(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isLiked by remember { mutableStateOf(false) }

    Button(
        onClick = {
            isLiked = !isLiked
            onClick()
        },
        modifier = modifier.size(45.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = if (isLiked) Color.Red else Color.Gray
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            if (isLiked) "❤️" else "🤍",
            fontSize = 20.sp
        )
    }
}

@Composable
fun Ubicacion(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "📍",
            fontSize = 14.sp,
            modifier = Modifier.padding(end = 4.dp)
        )
        Text(
            "Sabanilla, Puno (7km)",
            fontSize = 14.sp,
            color = Color(0xFF2196F3),
            fontFamily = fredoka
        )
    }
}

@Composable
fun parte_3(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        DetailCard(
            title = "Hembra",
            subtitle = "Género",
            backgroundColor = Color(0xFFE8F5E8)
        )
        DetailCard(
            title = "1 Año",
            subtitle = "Edad",
            backgroundColor = Color(0xFFFFF3E0)
        )
        DetailCard(
            title = "10 Kg",
            subtitle = "Peso",
            backgroundColor = Color(0xFFE3F2FD)
        )
    }
}

@Composable
fun DetailCard(
    title: String,
    subtitle: String,
    backgroundColor: Color
) {
    Box(
        modifier = Modifier
            .size(width = 90.dp, height = 70.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                subtitle,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}