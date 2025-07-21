package com.example.app_2.ui.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.app_2.R
import com.example.app_2.navigation.AppScreens

@Composable
fun ActionIcons(
    navController: NavController,
    profilePictureUrl: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navController.navigate(AppScreens.BuscarScreen.route) }) {
            Icon(
                painter = painterResource(id = R.drawable.buscar),
                contentDescription = "Buscar",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(24.dp)
            )
        }
        IconButton(onClick = { navController.navigate(AppScreens.NotificationsScreen.route) }) {
            Icon(
                painter = painterResource(id = R.drawable.noti),
                contentDescription = "Notificaciones",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(24.dp)
            )
        }
        ProfileImage(
            navController = navController,
            destinationRoute = AppScreens.PerfilUsuarioScreen.route,
            profilePictureUrl = profilePictureUrl
        )
    }
}