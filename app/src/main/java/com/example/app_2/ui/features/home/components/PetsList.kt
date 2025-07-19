package com.example.app_2.ui.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.app_2.R

@Composable
fun PetsList(navController: NavController) {
    val mascotas = listOf(
        Mascota("Korayma", "5km", MaterialTheme.colorScheme.secondaryContainer, R.drawable.gato2),
        Mascota("Kitty", "7km", MaterialTheme.colorScheme.tertiaryContainer, R.drawable.gatoxd),
        Mascota("Kitty", "7km", MaterialTheme.colorScheme.tertiaryContainer, R.drawable.gato3)
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(end = 16.dp)
    ) {
        items(mascotas.size) { index ->
            PetCard(mascota = mascotas[index], navController = navController)
        }
    }
}