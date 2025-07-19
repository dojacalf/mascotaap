package com.example.app_2.ui.features.perfiles_mascota.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_2.R
import com.example.app_2.ui.features.perfiles_mascota.components.ActionPanel
import com.example.app_2.ui.features.perfiles_mascota.components.PetGrid
import com.example.app_2.ui.theme.AppTheme

data class Pet(
    val id: String,
    val name: String,
    val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilesMascotaScreen() {
    val pets = remember {
        listOf(
            Pet("1", "tatiana", R.drawable.mujer_mascota),
            Pet("2", "Castillo", R.drawable.mujer_mascota),
            Pet("3", "Pedro", R.drawable.mujer_mascota),
            Pet("4", "Boluerte", R.drawable.mujer_mascota),
            Pet("5", "Pelusa", R.drawable.mujer_mascota),
            Pet("6", "Mac", R.drawable.mujer_mascota),
            Pet("7", "Alexis", R.drawable.mujer_mascota),
            Pet("8", "Chow Chow", R.drawable.mujer_mascota),
            Pet("9", "Paísana", R.drawable.mujer_mascota)
        )
    }

    var selectedPetId by remember { mutableStateOf<String?>(null) }
    val favoritePets = remember { mutableStateMapOf<String, Boolean>() }

    AppTheme {
        Scaffold(
            topBar = {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(85.dp),
                    color = MaterialTheme.colorScheme.primary,
                    shadowElevation = 8.dp,
                    shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        val Fredoka = FontFamily(Font(R.font.fredoka_semibold))
                        Text(
                            text = "Adopta una mascota",
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontFamily = Fredoka,
                            fontSize = 28.sp
                        )
                    }
                }
            },
            content = { padding ->
                Column(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    PetGrid(
                        pets = pets,
                        selectedPetId = selectedPetId,
                        favoritePets = favoritePets,
                        onPetSelected = { petId ->
                            selectedPetId = if (selectedPetId == petId) null else petId
                        },
                        onToggleFavorite = { petId ->
                            favoritePets[petId] = !(favoritePets[petId] ?: false)
                        }
                    )

                    selectedPetId?.let { petId ->
                        val pet = pets.first { it.id == petId }
                        ActionPanel(
                            petName = pet.name,
                            onAdopt = { /* Lógica de adopción */ },
                            onCancel = { selectedPetId = null }
                        )
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PetAdoptionScreenPreview() {
    AppTheme {
        PerfilesMascotaScreen()
    }
}