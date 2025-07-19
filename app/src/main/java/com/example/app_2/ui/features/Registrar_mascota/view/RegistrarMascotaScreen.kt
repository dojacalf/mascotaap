package com.example.app_2.ui.features.Registrar_mascota.view

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app_2.ui.features.Registrar_mascota.components.ImageSelection
import com.example.app_2.ui.features.Registrar_mascota.components.PetForm
import com.example.app_2.ui.features.Registrar_mascota.components.SubmitButton
import com.example.app_2.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrarMascotaScreen(onSubmit: () -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("Macho") }
    var descripcion by remember { mutableStateOf("") }
    var imagenUri by remember { mutableStateOf<Uri?>(null) }

    AppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Registro de mi mascota") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = onSubmit,
                    containerColor = MaterialTheme.colorScheme.secondary
                ) {
                    Icon(Icons.Default.Check, contentDescription = "Registrar", tint = MaterialTheme.colorScheme.onSecondary)
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                ImageSelection(imagenUri = imagenUri, onImageUriChanged = { imagenUri = it })
                PetForm(
                    nombre = nombre,
                    onNombreChanged = { nombre = it },
                    edad = edad,
                    onEdadChanged = { edad = it },
                    tipo = tipo,
                    onTipoChanged = { tipo = it },
                    sexo = sexo,
                    onSexoChanged = { sexo = it },
                    descripcion = descripcion,
                    onDescripcionChanged = { descripcion = it }
                )
                SubmitButton(onSubmit = onSubmit)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistroMascotaPreview() {
    RegistrarMascotaScreen(onSubmit = {})
}