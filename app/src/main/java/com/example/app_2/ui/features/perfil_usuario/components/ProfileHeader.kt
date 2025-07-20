package com.example.app_2.ui.features.perfil_usuario.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.app_2.R
// import coil.compose.rememberAsyncImagePainter

@Composable
fun ProfileHeader(profilePictureUrl: String, backgroundImageUrl: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
    ) {
        // Imagen de fondo
        // TODO: Usar una librería como Coil para cargar imágenes desde una URL
        // val backgroundImage = rememberAsyncImagePainter(backgroundImageUrl.ifEmpty { R.drawable.dcori })
        Image(
            painter = painterResource(id = R.drawable.dcori), // Placeholder
            contentDescription = "Imagen de fondo",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        // Ícono de mascota en la esquina superior derecha
        IconButton(
            onClick = { /* Acción */ },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.perrologo),
                contentDescription = "Mascota",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }

        // Imagen de perfil circular
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
        ) {
            // val profileImage = rememberAsyncImagePainter(profilePictureUrl.ifEmpty { R.drawable.dcori })
            Image(
                painter = painterResource(id = R.drawable.dcori), // Placeholder
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(4.dp, MaterialTheme.colorScheme.surface, CircleShape),
                contentScale = ContentScale.Crop
            )

            // Botón de editar
            IconButton(
                onClick = { /* Acción editar */ },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "Editar",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
