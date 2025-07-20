package com.example.app_2.ui.features.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.app_2.domain.model.Pet

@Composable
fun PetCard(pet: Pet, navController: NavController) {
    Card(
        modifier = Modifier
            .clickable {
                // Navegar a la pantalla de detalle de la mascota, pasando el ID
                // navController.navigate("perfil_mascota_screen/${pet.id}")
            }
            .width(170.dp)
            .height(300.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            PetCardHeader(ownerName = pet.ownerName)
            PetImage(
                imageUrl = pet.imageUrl,
                petName = pet.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 12.dp)
            )
            PetName(nombre = pet.name)
        }
    }
}
