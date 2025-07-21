package com.example.app_2.ui.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HeaderSection(
    modifier: Modifier = Modifier,
    navController: NavController,
    profilePictureUrl: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LocationInfo()
        ActionIcons(
            navController = navController,
            profilePictureUrl = profilePictureUrl
        )
    }
}