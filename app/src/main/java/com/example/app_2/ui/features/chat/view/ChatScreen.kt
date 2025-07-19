package com.example.app_2.ui.features.chat.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.ui.features.chat.components.ChatBottomBar
import com.example.app_2.ui.features.chat.components.ChatTopBar
import com.example.app_2.ui.features.chat.components.MessageArea
import com.example.app_2.ui.theme.AppTheme

@Composable
fun ChatScreen(navController: NavController) {
    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f))
            )
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                ChatTopBar(navController = navController)
                MessageArea(modifier = Modifier.weight(1f))
                ChatBottomBar()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatSimpleScreenPreview() {
    ChatScreen(navController = rememberNavController())
}