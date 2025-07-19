package com.example.app_2.ui.features.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.ui.features.home.components.BannerSection
import com.example.app_2.ui.features.home.components.CategoriesSection
import com.example.app_2.ui.features.home.components.HeaderSection
import com.example.app_2.ui.features.home.components.PetsSection
import com.example.app_2.ui.theme.AppTheme

@Composable
fun PrincipalScreen(navController: NavController) {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            // Header Section
            HeaderSection(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
                navController = navController
            )

            // Content Section
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                // Banner Section
                BannerSection()

                Spacer(modifier = Modifier.height(60.dp))

                // Categories Section
                CategoriesSection()

                Spacer(modifier = Modifier.height(60.dp))

                // Pets Section
                PetsSection(navController = navController)
            }
        }
    }
}

@Preview
@Composable
fun PantallaPrincipalPreview() {
    AppTheme {
        PrincipalScreen(navController = rememberNavController())
    }
}