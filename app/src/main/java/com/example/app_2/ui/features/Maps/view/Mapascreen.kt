package com.example.app_2.ui.features.Maps.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_2.R
import com.example.app_2.ui.features.Maps.components.MapContent
import com.example.app_2.ui.features.Maps.components.MapTopAppBar
import com.example.app_2.ui.features.Maps.components.PetLocation
import com.example.app_2.ui.features.Maps.components.PetLocationList
import com.example.app_2.ui.theme.AppTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapaScreen(onBackClick: () -> Unit) {
    val ubicaciones = listOf(
        PetLocation(
            id = 1,
            nombre = "Alexis",
            ubicacion = "Mercado Bellavista",
            tipo = "Perro",
            coordenadas = LatLng(44.4355, 26.1025),
            imagen = R.drawable.mascot3
        ),
        PetLocation(
            id = 2,
            nombre = "Castillo",
            ubicacion = "Colegio San Carlos",
            tipo = "Perro",
            coordenadas = LatLng(44.4672, 26.0786),
            imagen = R.drawable.mascot5
        )
    )

    val cameraPosition = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(44.4375, 26.0975), 13f)
    }

    AppTheme {
        Scaffold(
            topBar = { MapTopAppBar(onBackClick = onBackClick) },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = onBackClick,
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Regresar"
                    )
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                MapContent(
                    cameraPositionState = cameraPosition,
                    locations = ubicaciones
                )
                PetLocationList(locations = ubicaciones)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MascotasMapaPreview() {
    AppTheme {
        MapaScreen(onBackClick = {})
    }
}