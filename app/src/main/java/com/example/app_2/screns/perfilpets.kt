import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_2.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Pets
import androidx.compose.runtime.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.BorderStroke
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import kotlin.collections.first
import kotlin.collections.set
import kotlin.let


data class Pet(
    val id: String,
    val name: String,
    val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun perfilpets() {
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

    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp),
                color = Color(0xFFF7B803),
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
                        color = Color.White,
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
                    .background(Color(0xFFF5F5F5))
            ) {
                // Grid de mascotas (2 columnas)
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.weight(1f),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(pets) { pet ->
                        PetCard(
                            pet = pet,
                            isSelected = selectedPetId == pet.id,
                            isFavorite = favoritePets[pet.id] ?: false,
                            onSelect = { selectedPetId = if (selectedPetId == pet.id) null else pet.id },
                            onToggleFavorite = {
                                favoritePets[pet.id] = !(favoritePets[pet.id] ?: false)
                            }
                        )
                    }

                }

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

@Composable
fun PetCard(
    pet: Pet,
    isSelected: Boolean,
    isFavorite: Boolean,
    onSelect: () -> Unit,
    onToggleFavorite: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(
            width = if (isSelected) 3.dp else 1.dp,
            color = if (isSelected) Color(0xFFFFE330) else Color.LightGray
        )
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopEnd
            ) {

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.LightGray, CircleShape)
                        .align(Alignment.Center)
                ) {
                    if (pet.imageRes != 0) {
                        Image(
                            painter = painterResource(id = pet.imageRes),
                            contentDescription = "Foto de ${pet.name}",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Pets,
                            contentDescription = "Imagen no disponible",
                            tint = Color.Gray,
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }

                IconButton(
                    onClick = { onToggleFavorite() },
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = if (isFavorite) "Quitar de favoritos" else "Añadir a favoritos",
                        tint = if (isFavorite) Color(0xFFFF0C00) else Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = pet.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                color = if (isSelected) Color(0xFF4CAF50) else Color.Black
            )
        }
    }
}

@Composable
fun ActionPanel(
    petName: String,
    onAdopt: () -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Divider(
            thickness = 1.dp,
            color = Color.LightGray
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onAdopt,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2E8AFF)
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp
            )
        ) {
            Text(
                text = "ADOPTAR A  $petName",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        TextButton(
            onClick = onCancel,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "CANCELAR",
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PetAdoptionScreenPreview() {
    MaterialTheme {
        perfilpets()
    }
}