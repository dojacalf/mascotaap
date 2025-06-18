package com.example.app_2.ui.features.home.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


// Colores personalizados
val colorKorayma = Color(0xFFFFF5E6)
val colorKitty = Color(0xFFF0FAF0)
val colorBanner = Color(0xFF5DADE2)
val fondoApp = Color(0xFFFAFAFA)

@Composable
fun PantallaPrincipal(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondoApp)
    ) {
        // Header Section
        HeaderSection(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
            navController = navController // <-- Pasa NavController a HeaderSection
        )

        // Content Section
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            // Banner Section
            BannerSection()

            Spacer(modifier = Modifier.height(60.dp))

            // Categories Section
            CategoriesSection()

            Spacer(modifier = Modifier.height(60.dp))

            // Pets Section
            PetsSection(navController = navController)
        }
    }
}

@Composable
fun HeaderSection(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Location Column
        LocationInfo()

        // Action Icons Row
        ActionIcons(navController = navController)
    }
}

@Composable
fun LocationInfo() {
    Column {
        Text(
            text = "Ubicación",
            fontSize = 12.sp,
            color = Color.Gray
        )
        Text(
            text = "Salcedo, Puno",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ActionIcons(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Search Icon
        Icon(
            painter = painterResource(id = R.drawable.buscar),
            contentDescription = "Buscar",
            tint = Color.Gray,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    navController.navigate("busqueda")
                }
        )

        // Notification Icon
        Icon(
            painter = painterResource(id = R.drawable.noti),
            contentDescription = "Buscar",
            tint = Color.Gray,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    // Navegar a la pantalla de búsqueda
                    navController.navigate("notificaciones")
                }
        )
        ProfileImage(
            navController = navController,
            destinationRoute = "perfil usuario"
        )
    }
}

@Composable
fun ProfileImage(
    navController: NavController, // Parámetro para controlar la navegación
    destinationRoute: String,      // Parámetro para la ruta a la que quieres navegar
) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(Color(0xFFFFB74D))
            .border(2.dp, Color.Gray.copy(alpha = 0.3f), CircleShape)
            .clickable {
                // Acción de navegación al hacer clic
                navController.navigate(destinationRoute)
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.dcori), // Asegúrate que este recurso exista
            contentDescription = "Perfil",
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape), // Aplicar clip también a la imagen si es necesario
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun BannerSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(colorBanner)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Únete a nuestra\ncomunidad de\namantes de los\nanimales",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            JoinButton()
        }
    }
}

@Composable
fun JoinButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFC107)
        ),
        shape = RoundedCornerShape(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
        modifier = Modifier.height(30.dp)
    ) {
        Text(
            "Únete ahora",
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun CategoriesSection() {
    Column {
        Text(
            "Categorías",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        CategoriesList()
    }
}

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

@Composable
fun CategoryChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (isSelected) Color(0xFF5DADE2) else Color(0xFFF5F5F5)
            )
            .clickable { onClick() }
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 14.sp,
            fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal
        )
    }
}

@Composable
fun PetsSection(navController: NavController) {
    Column {
        PetsSectionHeader(navController = navController)

        Spacer(modifier = Modifier.height(16.dp))

        PetsList(navController = navController)
    }
}

@Composable
fun PetsSectionHeader(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Adopta una mascota",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Text(
            "Ver todo",
            color = Color(0xFFFF9800),
            fontSize = 12.sp,
            modifier = Modifier.clickable { navController.navigate("ver_todo")}
        )
    }
}

@Composable
fun PetsList(navController: NavController) {
    val mascotas = listOf(
        Mascota("Korayma", "5km", colorKorayma, R.drawable.gato2),
        Mascota("Kitty", "7km", colorKitty, R.drawable.gatoxd),
        Mascota("Kitty", "7km", colorKitty, R.drawable.gato3)
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

@Composable
fun PetCard(mascota: Mascota, navController: NavController) {
    Card(
        modifier = Modifier
            .clickable {
                // Navegar a la pantalla de búsqueda
                navController.navigate("mascota")
            }
            .width(170.dp)
            .height(300.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = mascota.colorFondo
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top Row with location and favorite
            PetCardHeader(distancia = mascota.distancia)

            // Pet Image
            PetImage(
                imageResId = mascota.imagenResId,
                nombre = mascota.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 12.dp)
            )

            // Pet Name
            PetName(nombre = mascota.nombre)
        }
    }
}

@Composable
fun PetCardHeader(distancia: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LocationBadge(distancia = distancia)
        FavoriteButton()
    }
}

@Composable
fun LocationBadge(distancia: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White.copy(alpha = 0.7f))
            .padding(horizontal = 6.dp, vertical = 3.dp)
    ) {
        Icon(
            Icons.Default.LocationOn,
            contentDescription = "Ubicación",
            tint = Color.Gray,
            modifier = Modifier.size(14.dp)
        )

        Spacer(modifier = Modifier.width(2.dp))

        Text(
            "Distancia ($distancia)",
            fontSize = 10.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun FavoriteButton() {
    FilledIconButton(
        onClick = { },
        modifier = Modifier.size(28.dp),
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = Color.White
        )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.cora),
            contentDescription = "Favorito",
            tint = Color(0xFFFF6B6B),
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
fun PetImage(
    imageResId: Int,
    nombre: String,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = nombre,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
        )
    }
}

@Composable
fun PetName(nombre: String) {
    Text(
        nombre,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        modifier = Modifier.padding(
            start = 12.dp,
            end = 12.dp,
            top = 8.dp,
            bottom = 12.dp
        )
    )
}

// Data class
data class Mascota(
    val nombre: String,
    val distancia: String,
    val colorFondo: Color,
    val imagenResId: Int,
)

@Preview
@Composable
fun PantallaPrincipalPreview() {
    PantallaPrincipal(navController = rememberNavController())
}