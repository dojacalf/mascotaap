package com.example.app_2.ui.features.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.ui.features.home.components.BannerSection
import com.example.app_2.ui.features.home.components.CategoriesSection
import com.example.app_2.ui.features.home.components.HeaderSection
import com.example.app_2.ui.features.home.components.PetsSection
import com.example.app_2.ui.features.home.viewmodel.HomeViewModel
import com.example.app_2.ui.theme.AppTheme

@Composable
fun PrincipalScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state

    AppTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .verticalScroll(rememberScrollState())
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
                    PetsSection(navController = navController, pets = state.pets)
                }
            }

            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            state.error?.let {
                Text(
                    text = it,
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.error
                )
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
