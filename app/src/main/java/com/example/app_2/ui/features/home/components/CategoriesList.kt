package com.example.app_2.ui.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

@Composable
fun CategoriesList() {
    val categorias = listOf("Gatos", "Perros", "Aves", "Peces")
    var seleccion by remember { mutableStateOf("Gatos") }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categorias.size) { index ->
            val categoria = categorias[index]
            CategoryChip(
                text = categoria,
                isSelected = categoria == seleccion,
                onClick = { seleccion = categoria }
            )
        }
    }
}