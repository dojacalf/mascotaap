package com.example.app_2.ui.features.perfiles_mascota.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.app_2.R
import com.example.app_2.ui.features.perfiles_mascota.components.PetFeed
import com.example.app_2.ui.features.perfiles_mascota.viewmodel.PerfilesMascotaViewModel
import com.example.app_2.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilesMascotaScreen(
    viewModel: PerfilesMascotaViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    AppTheme {
        Scaffold(
            topBar = {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(85.dp),
                    color = MaterialTheme.colorScheme.primary,
                    shadowElevation = 8.dp,
                    shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        val Fredoka = FontFamily(Font(R.font.fredoka_semibold))
                        Text(
                            text = "Adopta una mascota",
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontFamily = Fredoka,
                            fontSize = 28.sp
                        )
                    }
                }
            },
            content = { padding ->
                Column(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    if (uiState.isLoading) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    uiState.error?.let { error ->
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = error, color = MaterialTheme.colorScheme.error)
                        }
                    }

                    if (!uiState.isLoading && uiState.error == null) {
                        PetFeed(
                            posts = uiState.posts,
                            onAdoptClick = { petId ->
                                // TODO: Handle adoption click
                            }
                        )
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PetAdoptionScreenPreview() {
    AppTheme {
        // This preview will be basic as it cannot instantiate the ViewModel
        PerfilesMascotaScreen()
    }
}