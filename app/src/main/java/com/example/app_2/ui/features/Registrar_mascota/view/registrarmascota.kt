package com.example.app_2.ui.features.Registrar_mascota.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PantallaRegistroMascota()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaRegistroMascota() {
    var nombre by remember { mutableStateOf("") }
    var categoriaSeleccionada by remember { mutableStateOf("") }
    var razaSeleccionada by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var fechaNacimiento by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("") }

    var expandedCategoria by remember { mutableStateOf(false) }
    var expandedRaza by remember { mutableStateOf(false) }

    val categorias = listOf("Perro", "Gato", "Ave", "Conejo", "Hamster", "Otro")
    val razas = listOf("Labrador", "Pastor Alemán", "Bulldog", "Golden Retriever", "Chihuahua", "Mestizo", "Otra")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()), // Agregamos scroll aquí
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                // Botón de retroceso
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { /* Manejar navegación */ },
                    tint = Color.Gray
                )

                Spacer(modifier = Modifier.height(20.dp))

                // NOMBRE
                Text(
                    text = "NOMBRE:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    placeholder = { Text("Nombre de la mascota", color = Color.Gray) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.LightGray,
                        focusedBorderColor = Color.Blue
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                // CATEGORÍA - Dropdown simple
                Text(
                    text = "CATEGORÍA",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box {
                    OutlinedTextField(
                        value = categoriaSeleccionada,
                        onValueChange = {},
                        readOnly = true,
                        placeholder = { Text("Selecciona la categoría", color = Color.Gray) },
                        trailingIcon = {
                            Icon(
                                Icons.Default.KeyboardArrowDown,
                                contentDescription = "Dropdown",
                                tint = Color.Gray
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { expandedCategoria = true },
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.LightGray,
                            focusedBorderColor = Color.Blue
                        ),
                        singleLine = true
                    )

                    DropdownMenu(
                        expanded = expandedCategoria,
                        onDismissRequest = { expandedCategoria = false },
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        categorias.forEach { categoria ->
                            DropdownMenuItem(
                                text = { Text(categoria) },
                                onClick = {
                                    categoriaSeleccionada = categoria
                                    expandedCategoria = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // RAZA - Dropdown simple
                Text(
                    text = "RAZA:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box {
                    OutlinedTextField(
                        value = razaSeleccionada,
                        onValueChange = {},
                        readOnly = true,
                        placeholder = { Text("Raza", color = Color.Gray) },
                        trailingIcon = {
                            Icon(
                                Icons.Default.KeyboardArrowDown,
                                contentDescription = "Dropdown",
                                tint = Color.Gray
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { expandedRaza = true },
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.LightGray,
                            focusedBorderColor = Color.Blue
                        ),
                        singleLine = true
                    )

                    DropdownMenu(
                        expanded = expandedRaza,
                        onDismissRequest = { expandedRaza = false },
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        razas.forEach { raza ->
                            DropdownMenuItem(
                                text = { Text(raza) },
                                onClick = {
                                    razaSeleccionada = raza
                                    expandedRaza = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // PESO
                Text(
                    text = "PESO:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = peso,
                    onValueChange = { peso = it },
                    placeholder = { Text("Ingrese el peso de tu mascota", color = Color.Gray) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.LightGray,
                        focusedBorderColor = Color.Blue
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                // EDAD
                Text(
                    text = "EDAD:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = edad,
                    onValueChange = { edad = it },
                    placeholder = { Text("Ingrese la edad de tu mascota", color = Color.Gray) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.LightGray,
                        focusedBorderColor = Color.Blue
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                // FECHA DE NACIMIENTO
                Text(
                    text = "FECHA DE NACIMIENTO:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = fechaNacimiento,
                    onValueChange = { fechaNacimiento = it },
                    placeholder = { Text("Ingrese la fecha de nacimiento", color = Color.Gray) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.LightGray,
                        focusedBorderColor = Color.Blue
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                // COLOR
                Text(
                    text = "COLOR:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = color,
                    onValueChange = { color = it },
                    placeholder = { Text("Ingrese el color de tu mascota", color = Color.Gray) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.LightGray,
                        focusedBorderColor = Color.Blue
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                // FOTO
                Text(
                    text = "FOTO:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /* Manejar carga de archivo */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE8E8F8)
                    )
                ) {
                    Text(
                        text = "Subir archivo",
                        color = Color(0xFF6B6B8B),
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // BOTÓN REGISTRAR
                Button(
                    onClick = { /* Manejar registro */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF007AFF)
                    )
                ) {
                    Text(
                        text = "Registrar",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // BOTÓN ADICIONAL (parece ser un botón secundario o de cancelar)
                TextButton(
                    onClick = { /* Manejar acción secundaria */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(
                        text = "Cancelar",
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPantallaRegistroMascota() {
    MaterialTheme {
        PantallaRegistroMascota()
    }
}