package com.example.daniel_parte_3.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.ui.graphics.Color // <-- MANTÉN ESTA, es la de Jetpack Compose
import com.example.daniel_parte_3.R


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PantallaPrincipal2()
                }
            }

        }
    }
}

@Composable
fun PantallaPrincipal2() {
    Text(
        text = "Ubicación ",
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(35.dp)
    )
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Spacer(modifier = Modifier.height(50.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Juliaca, Puno")
            IconButton(onClick = { /* Acción búsqueda */ }) {
                Icon(
                    painter = painterResource(id = com.example.daniel_parte_3.R.drawable.iconobuscar),
                    contentDescription = "Buscar"
                )
            }
            IconButton(onClick = { /* Acción ubicación */ }) {
                Icon(
                    painter = painterResource(id = com.example.daniel_parte_3.R.drawable.icononotificacion),
                    contentDescription = "Notificaciones"
                )
            }
            IconButton(onClick = { /* Acción perfil */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.iconousuario),
                    contentDescription = "Perfil"
                )
            }
        }

        // Ubicación


        Spacer(modifier = Modifier.height(16.dp))

        // Banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF2196F3))
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                Text("Únete a nuestra comunidad de amantes de los animales", color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color(0xFFFFC107))) {
                    Text("Únete ahora", color = Color.White)
                }
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        // Categorías
        Text("Categorías:", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Categorias2()

        Spacer(modifier = Modifier.height(30.dp))

        // Lista de mascotas
        Text("Adopta una mascota", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(25.dp))
        ListaMascotas2()
    }
}


@Composable
fun Categorias2() {
    val categorias = listOf("Gatos", "Perros", "Aves", "Peces")
    var seleccion by remember { mutableStateOf("Perros") }

    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(categorias.size) { index ->
            val categoria = categorias[index]
            val selected = categoria == seleccion
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(if (selected) Color(0xFF2196F3) else Color(0xFFF1F1F1))
                    .clickable { seleccion = categoria }
                    .padding(horizontal = 18.dp, vertical = 10.dp)
            ) {
                Text(
                    text = categoria,
                    color = if (selected) Color.White else Color.Black
                )
            }
        }
    }
}


data class Mascota2(val nombre: String, val distancia: String, val colorFondo: Color,val imagenResId: Int)

@Composable
fun ListaMascotas2() {
    val mascotas = listOf(
        Mascota("Dorayma", "5km", Color(0xFFFFE0B2), com.example.daniel_parte_3.R.drawable.p_dorayma),
        Mascota("Tonia", "7km", Color(0xFFC8E6C9), com.example.daniel_parte_3.R.drawable.p_tonia),)

    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        items(mascotas.size) { index -> TarjetaMascota2(mascota = mascotas[index])
        }
    }
}


@Composable
fun TarjetaMascota2(mascota: Mascota) {
    Box(
        modifier = Modifier
            .width(170.dp)
            .height(300.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(mascota.colorFondo)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Default.LocationOn, contentDescription = "Ubicación", tint = Color.Gray)
                Text("Distancia (${mascota.distancia})", fontSize = 12.sp)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Favorito",
                    tint = Color.Red,
                    modifier = Modifier.size(20.dp)
                )
            }

            Text(
                mascota.nombre,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.Start)
            )

            Image(
                painter = painterResource(id = mascota.imagenResId),
                contentDescription = mascota.nombre,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
fun PantallaPrincipalPreview2() {
    PantallaPrincipal2()
}