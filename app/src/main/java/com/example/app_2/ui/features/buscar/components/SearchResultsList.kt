package com.example.app_2.ui.features.buscar.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.app_2.domain.model.Pet

@Composable
fun SearchResultsList(
    searchResults: List<Pet>,
    onItemClick: (Pet) -> Unit,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = searchResults.isNotEmpty(),
        enter = fadeIn() + expandVertically(),
        exit = fadeOut() + shrinkVertically()
    ) {
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            items(searchResults) { pet ->
                SearchResultItem(pet = pet, onItemClick = onItemClick)
            }
        }
    }
}
