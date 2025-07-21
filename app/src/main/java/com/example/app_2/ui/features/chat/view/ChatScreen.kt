package com.example.app_2.ui.features.chat.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.ui.features.chat.components.ChatBottomBar
import com.example.app_2.ui.features.chat.components.ChatTopBar
import com.example.app_2.ui.features.chat.components.MessageArea
import com.example.app_2.ui.features.chat.viewmodel.ChatViewModel
import com.example.app_2.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    navController: NavController,
    viewModel: ChatViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    AppTheme {
        Scaffold(
            topBar = {
                uiState.owner?.let { owner ->
                    uiState.pet?.let { pet ->
                        ChatTopBar(
                            navController = navController,
                            ownerName = owner.name,
                            petImageUrl = pet.imageUrl
                        )
                    }
                }
            },
            bottomBar = { ChatBottomBar() }
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(padding)
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                uiState.error?.let { error ->
                    Text(
                        text = error,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                if (!uiState.isLoading && uiState.error == null) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f))
                    )
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        MessageArea(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun ChatSimpleScreenPreview() {
    ChatScreen(navController = rememberNavController())
}*/
