package com.example.app_2.ui.features.perfil_usuario.view

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.R
import com.example.app_2.navigation.AppScreens
import com.example.app_2.ui.features.perfil_usuario.components.ContactInfo
import com.example.app_2.ui.features.perfil_usuario.components.InfoCard
import com.example.app_2.ui.features.perfil_usuario.components.OpcionMenuMejorada
import com.example.app_2.ui.features.perfil_usuario.components.ProfileHeader
import com.example.app_2.ui.features.perfil_usuario.components.UpdatePhoneDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import com.example.app_2.ui.features.perfil_usuario.components.UpdateTextDialog
import com.example.app_2.ui.features.perfil_usuario.viewmodel.PerfilUsuarioViewModel
import com.example.app_2.ui.theme.AppTheme

@Composable
fun PantallaPerfilUsuario(
    navController: NavController,
    viewModel: PerfilUsuarioViewModel = hiltViewModel()
) {
    val state by viewModel.state

    val profileImagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            viewModel.updateProfilePicture(it)
        }
    }

    val backgroundImagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            viewModel.updateBackgroundImage(it)
        }
    }

    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else if (state.error != null) {
                Text(
                    text = "Error: ${state.error}",
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.error
                )
            } else if (state.user != null) {
                val user = state.user!!

                // --- Dialogs ---
                if (viewModel.showUpdatePhoneDialog) {
                    UpdatePhoneDialog(
                        currentPhone = user.phone,
                        onDismiss = { viewModel.onDismissUpdatePhoneDialog() },
                        onConfirm = { viewModel.updatePhoneNumber(it) }
                    )
                }
                if (viewModel.showUpdateAboutMeDialog) {
                    UpdateTextDialog(
                        title = "Acerca de mí",
                        label = "Escribe algo sobre ti",
                        currentValue = user.aboutMe,
                        onDismiss = { viewModel.onDismissUpdateAboutMeDialog() },
                        onConfirm = { viewModel.updateAboutMe(it) }
                    )
                }
                if (viewModel.showUpdateAddressDialog) {
                    UpdateTextDialog(
                        title = "Mi dirección",
                        label = "Ingresa tu dirección",
                        currentValue = user.address,
                        onDismiss = { viewModel.onDismissUpdateAddressDialog() },
                        onConfirm = { viewModel.updateAddress(it) }
                    )
                }
                if (viewModel.showUpdateNameDialog) {
                    UpdateTextDialog(
                        title = "Actualizar nombre",
                        label = "Ingresa tu nuevo nombre",
                        currentValue = user.name,
                        onDismiss = { viewModel.onDismissUpdateNameDialog() },
                        onConfirm = { viewModel.updateName(it) }
                    )
                }

                // --- Screen Content ---
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    ProfileHeader(
                        profilePictureUrl = user.profilePictureUrl,
                        backgroundImageUrl = user.backgroundImageUrl,
                        onEditProfileClick = {
                            profileImagePickerLauncher.launch("image/*")
                        },
                        onEditBackgroundClick = {
                            backgroundImagePickerLauncher.launch("image/*")
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = user.name,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        IconButton(onClick = { viewModel.onShowUpdateNameDialog() }) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Editar nombre",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }


                    Spacer(modifier = Modifier.height(24.dp))

                    // Contact Info Card
                    ContactInfo(
                        email = user.email,
                        phone = user.phone,
                        onEditPhoneClicked = { viewModel.onShowUpdatePhoneDialog() }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // About Me Card
                    InfoCard(
                        title = "Acerca de mí",
                        content = user.aboutMe,
                        icon = painterResource(id = R.drawable.ic_perfil),
                        onEditClicked = { viewModel.onShowUpdateAboutMeDialog() }
                    )

                    // Address Card
                    InfoCard(
                        title = "Mi dirección",
                        content = user.address,
                        icon = painterResource(id = R.drawable.ic_ubi),
                        onEditClicked = { viewModel.onShowUpdateAddressDialog() }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Add Pet Option
                    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                        OpcionMenuMejorada(
                            icono = R.drawable.ic_agre_mas,
                            texto = "Agregar Mascota",
                            flechaIcono = R.drawable.ir,
                            ruta = AppScreens.RegistrarMascotaScreen.route,
                            navController = navController
                        )
                        OpcionMenuMejorada(
                            icono = R.drawable.p1,
                            texto = "Configuracion",
                            flechaIcono = R.drawable.ir,
                            ruta = AppScreens.ConfiguracionScreen.route,
                            navController = navController
                        )
                    }


                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPerfilUsuarioPreview() {
    PantallaPerfilUsuario(navController = rememberNavController())
}