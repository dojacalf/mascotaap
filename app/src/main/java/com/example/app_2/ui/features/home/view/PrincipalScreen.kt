package com.example.app_2.ui.features.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.navigation.AppScreens
import com.example.app_2.ui.features.home.components.HeaderSection
import com.example.app_2.ui.features.home.components.PetsSection
import com.example.app_2.ui.features.home.viewmodel.HomeViewModel
import com.example.app_2.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrincipalScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state

    AppTheme {
        Scaffold(
            topBar = {
                HeaderSection(
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp),
                    navController = navController,
                    profilePictureUrl = state.user?.profilePictureUrl ?: ""
                )
            }
        ) { padding ->
            Box(modifier = Modifier.fillMaxSize().padding(padding)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 32.dp)
                ) {
                    // Content Section
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 24.dp)
                    ) {
                        // Search Bar
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(MaterialTheme.shapes.large)
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                                .clickable { navController.navigate(AppScreens.BuscarScreen.route) }
                                .padding(16.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Buscar mascotas...",
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(32.dp))

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
}

@Preview
@Composable
fun PantallaPrincipalPreview() {
    AppTheme {
        PrincipalScreen(navController = rememberNavController())
    }
}
