package com.example.app_2.ui.features.auth.register.components


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SocialLoginSeparator(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Divider(
            Modifier.weight(1f),
            color = MaterialTheme.colorScheme.outline,
            thickness = 1.dp
        )
        Text(
            "O conéctate con",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Divider(
            Modifier.weight(1f),
            color = MaterialTheme.colorScheme.outline,
            thickness = 1.dp
        )
    }
}