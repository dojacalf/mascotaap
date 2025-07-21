package com.example.app_2.ui.features.perfiles_mascota.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.app_2.ui.features.perfiles_mascota.viewmodel.PetPost

@Composable
fun PetFeed(
    posts: List<PetPost>,
    onAdoptClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(posts) { post ->
            PetPostCard(
                post = post,
                onAdoptClick = onAdoptClick
            )
        }
    }
}