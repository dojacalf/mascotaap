package com.example.app_2.ui.features.perfiles_mascota.components

import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.app_2.ui.features.perfiles_mascota.view.Pet

@Composable
fun PetGrid(
    pets: List<Pet>,
    selectedPetId: String?,
    favoritePets: Map<String, Boolean>,
    onPetSelected: (String) -> Unit,
    onToggleFavorite: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        //modifier = Modifier.weight(1f),
        //modifier = Modifier.weight(1f),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(pets) { pet ->
            PetCard(
                pet = pet,
                isSelected = selectedPetId == pet.id,
                isFavorite = favoritePets[pet.id] ?: false,
                onSelect = { onPetSelected(pet.id) },
                onToggleFavorite = { onToggleFavorite(pet.id) }
            )
        }
    }
}