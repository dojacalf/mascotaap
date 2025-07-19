package com.example.app_2.ui.features.Maps.components

import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

@Composable
fun MapContent(
    cameraPositionState: CameraPositionState,
    locations: List<PetLocation>
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            properties = MapProperties(
                mapType = MapType.NORMAL,
                isBuildingEnabled = true
            ),
            uiSettings = MapUiSettings(
                zoomControlsEnabled = true,
                compassEnabled = true
            )
        ) {
            locations.forEach { mascota ->
                Marker(
                    state = MarkerState(position = mascota.coordenadas),
                    title = mascota.nombre,
                    snippet = mascota.ubicacion,
                    icon = createCircularMarkerIcon(
                        context,
                        mascota.imagen,
                        if (mascota.tipo == "Gato") MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.tertiary
                    )
                )
            }
        }
    }
}