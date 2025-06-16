package com.example.app_2.ui.featues.Maps.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.toArgb
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import kotlin.apply
import kotlin.collections.forEach
import kotlin.let
import com.example.app_2.R

@OptIn(ExperimentalMaterial3Api::class, MapsComposeExperimentalApi::class)
@Composable
fun MascotasMapa(onBackClick: () -> Unit) {
    val ubicaciones = listOf(
        MascotaUbicacion(
            id = 1,
            nombre = "Alexis",
            ubicacion = "Mercado Bellavista",
            tipo = "Perro",
            coordenadas = LatLng(44.4355, 26.1025),
            imagen = R.drawable.mascot3
        ),
        MascotaUbicacion(
            id = 2,
            nombre = "Castillo",
            ubicacion = "Colegio San Carlos",
            tipo = "Perro",
            coordenadas = LatLng(44.4672, 26.0786),
            imagen = R.drawable.mascot5
        )
    )

    val context = LocalContext.current
    val cameraPosition = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(44.4375, 26.0975), 13f)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Mascotas cerca de ti",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFF9800),
                    titleContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onBackClick,
                containerColor = Color(0xFFFF9800),
                contentColor = Color.White
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                GoogleMap(
                    modifier = Modifier.fillMaxSize(),
                    cameraPositionState = cameraPosition,
                    properties = MapProperties(
                        mapType = MapType.NORMAL,
                        isBuildingEnabled = true
                    ),
                    uiSettings = MapUiSettings(
                        zoomControlsEnabled = true,
                        compassEnabled = true
                    )
                ) {
                    ubicaciones.forEach { mascota ->
                        Marker(
                            state = MarkerState(position = mascota.coordenadas),
                            title = mascota.nombre,
                            snippet = mascota.ubicacion,
                            icon = createCircularMarkerIcon(
                                context,
                                mascota.imagen,
                                if (mascota.tipo == "Gato") Color(0xFFFFA451) else Color(0xFF3BB7E8)
                            )
                        )
                    }
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.White)
            ) {
                items(ubicaciones) { mascota ->
                    ItemMascotaMapa(mascota)
                }
            }
        }
    }
}

fun createCircularMarkerIcon(
    context: Context,
    imageRes: Int,
    backgroundColor: Color
): BitmapDescriptor {
    val size = 120
    val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)

    // Fondo circular
    val paint = Paint().apply {
        color = backgroundColor.toArgb()
        style = Paint.Style.STROKE
        strokeWidth = 2f
        isAntiAlias = true
    }
    canvas.drawCircle(size / 2f, size / 2f, size / 2f, paint)

    val drawable = ContextCompat.getDrawable(context, imageRes)
    drawable?.let {
        val scale = 1.0f // Escala de la imagen dentro del círculo
        val imageSize = (size * scale).toInt()
        val left = (size - imageSize) / 2
        val top = (size - imageSize) / 2

        it.setBounds(left, top, left + imageSize, top + imageSize)
        it.draw(canvas)
    }

    return BitmapDescriptorFactory.fromBitmap(bitmap)
}

@Composable
fun ItemMascotaMapa(mascota: MascotaUbicacion) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(id = mascota.imagen),
                contentDescription = mascota.tipo,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(if (mascota.tipo == "Gato") Color(0x22FFA451) else Color(0x225E3BE8)),
                contentScale = ContentScale.Crop
            )

            Column {
                Text(
                    text = mascota.nombre,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = mascota.ubicacion,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = mascota.tipo,
                    fontSize = 12.sp,
                    color = if (mascota.tipo == "Gato") Color(0xFFFFA451) else Color(0xFF5E3BE8)
                )
            }
        }
    }
}

data class MascotaUbicacion(
    val id: Int,
    val nombre: String,
    val ubicacion: String,
    val tipo: String,
    val coordenadas: LatLng,
    val imagen: Int
)

@Preview(showBackground = true)
@Composable
fun MascotasMapaPreview() {
    MaterialTheme {
        MascotasMapa(onBackClick = {})
    }
}