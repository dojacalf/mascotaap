package com.example.app_2.ui.features.perfil_mascota.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.app_2.navigation.AppScreens
import com.example.app_2.ui.features.perfil_mascota.components.Boton_adoptar
import com.example.app_2.ui.features.perfil_mascota.components.Boton_mensaje
import com.example.app_2.ui.features.perfil_mascota.components.Parte_5_descripcion
import com.example.app_2.ui.features.perfil_mascota.components.PetOwnerInfo
import com.example.app_2.ui.features.perfil_mascota.components.TarjetaEdad
import com.example.app_2.ui.features.perfil_mascota.components.TarjetaGenero
import com.example.app_2.ui.features.perfil_mascota.components.TarjetaPeso
import com.example.app_2.ui.features.perfil_mascota.components.Ubicacion
import com.example.app_2.ui.features.perfil_mascota.components.boton_2_puntos
import com.example.app_2.ui.features.perfil_mascota.components.boton_de_like
import com.example.app_2.ui.features.perfil_mascota.components.boton_retroceder
import com.example.app_2.ui.features.perfil_mascota.components.nombre_de_mascota
import com.example.app_2.ui.features.perfil_mascota.viewmodel.PerfilMascotaViewModel
import com.example.app_2.ui.theme.AppTheme

@Composable
fun PetPerfilScreen(
    navController: NavController,
    viewModel: PerfilMascotaViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val pet = state.pet
    val owner = state.owner

    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            if (state.isLoading && pet == null) { // Show loading only on initial load
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else if (state.error != null) {
                Text(
                    text = "Error: ${state.error}",
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.error
                )
            } else if (pet != null) {
                Column(modifier = Modifier.fillMaxSize()) {
                    // Image section
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        if (pet.imageUrl.isNotBlank()) {
                            Image(
                                painter = rememberAsyncImagePainter(model = pet.imageUrl),
                                contentDescription = pet.name,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        } else {
                            // Placeholder if there is no image URL
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(MaterialTheme.colorScheme.surfaceVariant),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Pets,
                                    contentDescription = pet.name,
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                        }

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
                        Column(modifier = Modifier.fillMaxSize()) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    nombre_de_mascota(name = pet.name, modifier = Modifier.padding(bottom = 8.dp))
                                    Ubicacion(location = "Bellavista, Puno (5km)") // Hardcoded for now
                                }
                                boton_de_like(onClick = { /* ... */ }, modifier = Modifier.padding(start = 16.dp))
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 24.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                TarjetaGenero(gender = pet.sex)
                                TarjetaEdad(age = pet.age)
                                TarjetaPeso(weight = "N/A") // No weight data in model
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                PetOwnerInfo(
                                    owner = owner,
                                    petName = pet.name,
                                    onOwnerClick = {
                                        // This will navigate to the current user's profile, not the owner's.
                                        // A proper implementation would pass the owner's ID.
                                        navController.navigate(AppScreens.PerfilUsuarioScreen.route)
                                    },
                                    modifier = Modifier.weight(1f)
                                )
                                Boton_mensaje(
                                    onClick = { navController.navigate(AppScreens.ChatScreen.createRoute(pet.id)) },
                                    modifier = Modifier.padding(end = 8.dp)
                                )
                            }

                            Parte_5_descripcion(description = pet.description, modifier = Modifier.weight(1f).padding(bottom = 20.dp))
                            Boton_adoptar(
                                onClick = { navController.navigate(AppScreens.ChatScreen.createRoute(pet.id)) },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
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
}
