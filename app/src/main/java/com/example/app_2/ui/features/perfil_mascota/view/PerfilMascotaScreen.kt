package com.example.app_2.ui.features.perfil_mascota.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.app_2.R
import com.example.app_2.ui.features.perfil_mascota.components.Boton_adoptar
import com.example.app_2.ui.features.perfil_mascota.components.Boton_llamar
import com.example.app_2.ui.features.perfil_mascota.components.Boton_mensaje
import com.example.app_2.ui.features.perfil_mascota.components.Parte_5_descripcion
import com.example.app_2.ui.features.perfil_mascota.components.TarjetaEdad
import com.example.app_2.ui.features.perfil_mascota.components.TarjetaGenero
import com.example.app_2.ui.features.perfil_mascota.components.TarjetaPeso
import com.example.app_2.ui.features.perfil_mascota.components.Ubicacion
import com.example.app_2.ui.features.perfil_mascota.components.boton_2_puntos
import com.example.app_2.ui.features.perfil_mascota.components.boton_de_like
import com.example.app_2.ui.features.perfil_mascota.components.boton_retroceder
import com.example.app_2.ui.features.perfil_mascota.components.datos_del_dueño
import com.example.app_2.ui.features.perfil_mascota.components.nombre_de_mascota
import com.example.app_2.ui.theme.AppTheme

@Composable
fun PetPerfilScreen(navController: NavController) {
    AppTheme { // Apply AppTheme here
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