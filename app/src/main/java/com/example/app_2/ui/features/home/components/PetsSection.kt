package com.example.app_2.ui.features.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.app_2.domain.model.Pet

@Composable
fun PetsSection(navController: NavController, pets: List<Pet>) {
    Column {
        PetsSectionHeader(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
        PetsList(navController = navController, pets = pets)
    }
}
