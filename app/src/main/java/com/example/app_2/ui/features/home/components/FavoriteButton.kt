package com.example.app_2.ui.features.home.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.app_2.R

@Composable
fun FavoriteButton() {
    IconButton(
        onClick = { },
        modifier = Modifier.size(28.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.cora),
            contentDescription = "Favorito",
            tint = MaterialTheme.colorScheme.error,
            modifier = Modifier.size(16.dp)
        )
    }
}