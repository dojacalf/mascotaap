package com.example.app_2.ui.features.perfil_mascota.view

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
import androidx.compose.material3.MaterialTheme
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
fun PetPerfilScreen(navController: NavController) {
    MaterialTheme { // Apply MaterialTheme here
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // Image section
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gato2),
                        contentDescription = "foto del gato",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                    boton_retroceder(
                        onClick = { navController.navigateUp() },
                        modifier = Modifier
                            .padding(20.dp)
                            .align(Alignment.TopStart)
                    )

                    boton_2_puntos(
                        onClick = { /* ... */ },
                        modifier = Modifier
                            .padding(20.dp)
                            .align(Alignment.TopEnd)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .padding(top = 40.dp)
                            .background(
                                MaterialTheme.colorScheme.surface,
                                RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = Color.Transparent,
                                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                            )
                            .height(50.dp)
                    )
                }

                // Content section
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1.3f)
                        .background(MaterialTheme.colorScheme.surface)
                        .border(
                            width = 1.dp,
                            color = Color.Transparent,
                            RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 70.dp)
                        )
                        .padding(horizontal = 20.dp)
                        .padding(bottom = 20.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // Pet name and location
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
                                onClick = { /* ... */ },
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }

                        // Info cards
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

                        // Owner info
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.secondaryContainer)
                                    .border(2.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f), CircleShape)
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
                                onClick = { /* ... */ }
                            )
                        }

                        // Description
                        Parte_5_descripcion(
                            modifier = Modifier
                                .weight(1f)
                                .padding(bottom = 20.dp)
                        )

                        // Adopt button
                        Boton_adoptar(
                            onClick = { /* ... */ },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                // Bottom spacer
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .background(MaterialTheme.colorScheme.background)
                )
            }
        }
    }
}

// Updated components to use MaterialTheme:

@Composable
fun TarjetaGenero() {
    Box(
        modifier = Modifier
            .size(width = 90.dp, height = 70.dp)
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
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
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Hembra",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                "Género",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

// Similarly update TarjetaEdad and TarjetaPeso with:
// background = MaterialTheme.colorScheme.secondaryContainer
// colorFilter.tint = MaterialTheme.colorScheme.secondary
// text colors = MaterialTheme.colorScheme.onSecondaryContainer

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
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text(
            "Adoptame",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun Parte_5_descripcion(
    modifier: Modifier = Modifier,
) {
    Text(
        "Korayma es una gata que encontró su lugar en mi mundo...",
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
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
            containerColor = MaterialTheme.colorScheme.errorContainer
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.llamarsvg),
            contentDescription = "Llamar",
            tint = MaterialTheme.colorScheme.onErrorContainer,
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
            containerColor = MaterialTheme.colorScheme.tertiaryContainer
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.chat4),
            contentDescription = "Mensaje",
            tint = MaterialTheme.colorScheme.onTertiaryContainer,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun datos_del_dueño(
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Text(
            "Daniel Valencia",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            "Dueño de Korayma",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
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
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.onSurface
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
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f),
            contentColor = MaterialTheme.colorScheme.onSurface
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
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f),
            contentColor = MaterialTheme.colorScheme.onSurface
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
            containerColor = MaterialTheme.colorScheme.surface
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
            tint = MaterialTheme.colorScheme.primary,
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
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .size(14.dp)
                .padding(end = 4.dp)
        )
        Text(
            "Bellavista, Puno (5km)",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun TarjetaEdad() {
    Box(
        modifier = Modifier
            .size(width = 90.dp, height = 70.dp)
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
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
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "1 Año",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Text(
                "Edad",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun TarjetaPeso() {
    Box(
        modifier = Modifier
            .size(width = 90.dp, height = 70.dp)
            .background(
                color = MaterialTheme.colorScheme.tertiaryContainer,
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
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.tertiary)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "10 Kg",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )
            Text(
                "Peso",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}