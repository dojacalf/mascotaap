package com.example.app_2.ui.featues.perfil_mascota.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.NavigateBefore
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_2.R
import com.example.app_2.ui.theme.fredoka
import androidx.navigation.NavController

val colorchat = Color(0xFF64ADEF)
val colorcall = Color(0xFFFB2626)
val colorcora = Color(0xFFFB2626)
val caja1 = Color(0xFFE2F5CB)
val caja2 = Color(0xFFFFE9C2)
val caja3 = Color(0xFFC2EBFF)
val caj1 = Color(0xFFCAEDA1)
val caj2 = Color(0xFFFFD68F)
val caj3 = Color(0xFFA3E1FF)
val negro1 = Color(0xFF03063A)
val negro2 = Color(0xFF70717B)


@Composable
fun Frame4(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF3DE)) // Color de fondo beige/crema
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Parte superior con la imagen
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Usa weight para distribución proporcional
            ) {
                // Imagen del gato
                Image(
                    painter = painterResource(id = R.drawable.gato2),
                    contentDescription = "foto del gato",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Botón retroceder
                boton_retroceder(
                    onClick = { navController.navigateUp() },
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
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(top = 40.dp) // Esto crea la superposición
                        .background(
                            Color.White,
                            RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = Color.Transparent,
                            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                        )
                        .height(50.dp) // Altura de la parte superpuesta
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.3f) // Ajusta el peso según necesites
                    .background(Color.White)
                    .border(
                        width = 1.dp,
                        color = Color.Transparent,
                        RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 70.dp)
                    )
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 20.dp) // Espacio inferior para mostrar el fondo beige
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        TarjetaGenero()
                        TarjetaEdad()
                        TarjetaPeso()
                    }

                    // Parte 4 - Información del dueño
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Imagen del dueño
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFFFB74D))
                                .border(2.dp, Color.Gray.copy(alpha = 0.3f), CircleShape)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.dcori),
                                contentDescription = "Dueño",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )
                        }

                        datos_del_dueño(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 12.dp)
                        )

                        Boton_mensaje(
                            onClick = { navController.navigate("chat") },
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

            // Espacio inferior para mostrar el fondo beige
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
        }
    }
}

// Tarjeta de Género - Componente independiente
@Composable
fun TarjetaGenero() {
    Box(
        modifier = Modifier
            .size(width = 90.dp, height = 70.dp)
            .background(
                color = caja1,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.pata1),
            contentDescription = "Fondo pata",
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop,
            alpha = 0.3f,
            colorFilter = ColorFilter.tint(caj1)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Hembra",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = negro1
            )
            Text(
                "Género",
                fontSize = 12.sp,
                color = negro2
            )
        }
    }
}

// Tarjeta de Edad - Componente independiente
@Composable
fun TarjetaEdad() {
    Box(
        modifier = Modifier
            .size(width = 90.dp, height = 70.dp)
            .background(
                color = caja2,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.pata1),
            contentDescription = "Fondo pata",
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop,
            alpha = 0.3f,
            colorFilter = ColorFilter.tint(caj2)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "1 Año",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = negro1
            )
            Text(
                "Edad",
                fontSize = 12.sp,
                color = negro2
            )
        }
    }
}

// Tarjeta de Peso - Componente independiente
@Composable
fun TarjetaPeso() {
    Box(
        modifier = Modifier
            .size(width = 90.dp, height = 70.dp)
            .background(
                color = caja3,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.pata1),
            contentDescription = "Fondo pata",
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop,
            alpha = 0.3f,
            colorFilter = ColorFilter.tint(caj3)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "10 Kg",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = negro1
            )
            Text(
                "Peso",
                fontSize = 12.sp,
                color = negro2
            )
        }
    }
}

@Composable
fun Boton_adoptar(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
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
    modifier: Modifier = Modifier,
) {
    Text(
        "Korayma es una gata que encontró su lugar en mi mundo, siempre buscando estar cerca para brindarme su compañía. Es muy amorosa y le encantan las camas con las personas que no se conforman con lo que tienen, siempre quieren más.",
        modifier = modifier,
        fontSize = 14.sp,
        color = Color.Gray,
        lineHeight = 20.sp
    )
}

@Composable
fun Boton_llamar(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
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
            painter = painterResource(id = R.drawable.llamarsvg),
            contentDescription = "Llamar",
            tint = colorcall,
            modifier = Modifier.size(24.dp)
        )
    }
}


@Composable
fun Boton_mensaje(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
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
            painter = painterResource(id = R.drawable.chat4),
            contentDescription = "Mensaje",
            tint = colorchat,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun datos_del_dueño(
    modifier: Modifier = Modifier,
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
            "Dueño de Korayma",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}


@Composable
fun nombre_de_mascota(
    modifier: Modifier = Modifier,
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
    modifier: Modifier = Modifier,
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
        Image(
            painter = painterResource(id = R.drawable.dosp),
            contentDescription = "Menu",
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun boton_retroceder(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
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
    modifier: Modifier = Modifier,
) {
    var isLiked by remember { mutableStateOf(false) }

    Button(
        onClick = {
            isLiked = !isLiked
            onClick()
        },
        modifier = modifier.size(40.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 4.dp
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.cora),
            contentDescription = "Corazón",
            tint = if (isLiked) colorcora else colorcora,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun Ubicacion(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.aqui),
            contentDescription = "Ubicación",
            tint = Color(0xFF2196F3),
            modifier = Modifier
                .size(14.dp)
                .padding(end = 4.dp)
        )
        Text(
            "Bellavista, Puno (5km)",
            fontSize = 14.sp,
            color = Color(0xFF2196F3),
            fontFamily = fredoka
        )
    }
}

/*
parte
   1 estructura
titulo
* identacion epaciondo justificado otrografia

2 trabjo en equipo
    equipo disuelto trabajar con personas git hub
   git

3 uso de la ia (herramienta)
    gemini

4 libro /canal de youtube /podcast

aistencia 10%
producto 50%
trabajo encargado 40%






*
* */