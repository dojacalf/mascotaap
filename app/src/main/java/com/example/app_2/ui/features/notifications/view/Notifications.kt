package com.example.app_2.ui.features.notifications.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_2.R
import com.example.app_2.ui.features.notifications.components.AdoptionNotification
import com.example.app_2.ui.features.notifications.components.AdoptionTopBar
import com.example.app_2.ui.features.notifications.components.NotificationList
import com.example.app_2.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen() {
    val notifications = listOf(
        AdoptionNotification(
            id = 1,
            user = "Inés",
            userImage = R.drawable.mujer_mascota,
            petImage = R.drawable.mujer_mascota,
            message = "quiere adoptar a tu mascota",
            time = "Hace 2 horas",
            accepted = false
        ),
        AdoptionNotification(
            id = 2,
            user = "Sam",
            userImage = R.drawable.sam,
            petImage = R.drawable.korayma,
            message = "desea conocer a tu gata",
            time = "Ayer",
            accepted = true
        )
    )

    AppTheme {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                AdoptionTopBar()
            },
            content = { padding ->
                Box(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f),
                                    MaterialTheme.colorScheme.secondaryContainer
                                )
                            )
                        )
                ) {
                    NotificationList(notifications = notifications)
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AdoptionNotificationsScreenPreview() {
    AppTheme {
        NotificationsScreen()
    }
}