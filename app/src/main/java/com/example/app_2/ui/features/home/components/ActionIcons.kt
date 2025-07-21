package com.example.app_2.ui.features.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.app_2.R

@Composable
fun ActionIcons(
    navController: NavController,
    profilePictureUrl: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.buscar),
            contentDescription = "Buscar",
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    navController.navigate("busqueda")
                }
        )
        Icon(
            painter = painterResource(id = R.drawable.noti),
            contentDescription = "Notificaciones",
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    navController.navigate("notificaciones")
                }
        )
        ProfileImage(
            navController = navController,
            destinationRoute = "perfil_usuario_screen",
            profilePictureUrl = profilePictureUrl
        )
    }
}