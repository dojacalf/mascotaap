
package com.example.app_2.screns

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.rememberAsyncImagePainter
import android.content.Context
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.collections.forEach
import kotlin.let

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroMascota(onSubmit: () -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("Macho") }
    var descripcion by remember { mutableStateOf("") }
    var imagenUri by remember { mutableStateOf<Uri?>(null) }
    var showImageDialog by remember { mutableStateOf(false) }
    var expandedTipo by remember { mutableStateOf(false) }

    val tipoOpciones = listOf("Perro", "Gato", "Ave", "Otro")

    val context = LocalContext.current
    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (!success) imagenUri = null
    }

    val galleryLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let { imagenUri = it }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Registro de mi mascota") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFFF9800), titleContentColor = Color.White)
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onSubmit, containerColor = Color(0xFF03A9F4)) {
                Icon(Icons.Default.Check, contentDescription = "Registrar")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Imagen
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(Color(0x11000000))
                    .clickable { showImageDialog = true }
                    .align(Alignment.CenterHorizontally),
                contentAlignment = Alignment.Center
            ) {
                if (imagenUri != null) {
                    Image(
                        painter = rememberAsyncImagePainter(imagenUri),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Icon(Icons.Default.AddAPhoto, contentDescription = null, tint = Color.Gray, modifier = Modifier.size(48.dp))
                }
            }

            // Datos básicos
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Nombre") },
                        leadingIcon = { Icon(Icons.Default.Pets, null) },
                        modifier = Modifier.fillMaxWidth()
                    )
                    var sexo by remember { mutableStateOf("Macho") }
                    val opciones = listOf("Macho", "Hembra")
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Sexo:")
                        Spacer(Modifier.width(12.dp))
                        SingleChoiceSegmentedButtonRow {
                            opciones.forEach { opcion ->
                                SegmentedButton(
                                    selected = sexo == opcion,
                                    onClick = { sexo = opcion },
                                    shape = RoundedCornerShape(8.dp),
                                    label = { Text(opcion) }
                                )
                            }
                        }
                    }


                    ExposedDropdownMenuBox(expanded = expandedTipo, onExpandedChange = { expandedTipo = !expandedTipo }) {
                        OutlinedTextField(
                            value = tipo,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Tipo") },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedTipo) },
                            modifier = Modifier.menuAnchor().fillMaxWidth()
                        )
                        ExposedDropdownMenu(expanded = expandedTipo, onDismissRequest = { expandedTipo = false }) {
                            tipoOpciones.forEach { opcion ->
                                DropdownMenuItem(
                                    text = { Text(opcion) },
                                    onClick = {
                                        tipo = opcion
                                        expandedTipo = false
                                    }
                                )
                            }
                        }
                    }

                    OutlinedTextField(
                        value = edad,
                        onValueChange = { edad = it },
                        label = { Text("Edad aprox.") },
                        leadingIcon = { Icon(Icons.Default.Cake, null) },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = descripcion,
                        onValueChange = { descripcion = it },
                        label = { Text("Descripción / comportamiento") },
                        leadingIcon = { Icon(Icons.Default.Description, null) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        maxLines = 4
                    )
                }
            }

            // Botón secundario
            Button(
                onClick = onSubmit,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
            ) {
                Icon(Icons.Default.Pets, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Publicar Mascota para Adopción", fontWeight = FontWeight.Bold)
            }
        }
    }
    fun createImageUri(context: Context): Uri {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val imageFileName = "JPEG_${timeStamp}_"
        val storageDir = context.externalCacheDir
        val imageFile = File.createTempFile(imageFileName, ".jpg", storageDir)

        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.provider",
            imageFile
        )
    }
    if (showImageDialog) {
        Dialog(onDismissRequest = { showImageDialog = false }) {
            Card(shape = RoundedCornerShape(16.dp)) {
                Column(Modifier.padding(16.dp)) {
                    Text("Selecciona una opción", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        val uri = createImageUri(context)
                        imagenUri = uri
                        cameraLauncher.launch(uri)
                        showImageDialog = false
                    }) {
                        Icon(Icons.Default.CameraAlt, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Tomar Foto")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        galleryLauncher.launch("image/*")
                        showImageDialog = false
                    }) {
                        Icon(Icons.Default.PhotoLibrary, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Elegir de Galería")
                    }
                }
            }
        }
    }
}