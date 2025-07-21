package com.example.app_2.ui.features.home.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderSection(
    modifier: Modifier = Modifier,
    navController: NavController,
    profilePictureUrl: String
) {
    TopAppBar(
        modifier = modifier,
        title = { LocationInfo() },
        actions = {
            ActionIcons(
                navController = navController,
                profilePictureUrl = profilePictureUrl
            )
        }
    )
}