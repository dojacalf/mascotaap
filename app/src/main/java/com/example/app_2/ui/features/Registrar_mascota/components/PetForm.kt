package com.example.app_2.ui.features.Registrar_mascota.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetForm(
    nombre: String,
    onNombreChanged: (String) -> Unit,
    edad: String,
    onEdadChanged: (String) -> Unit,
    tipo: String,
    onTipoChanged: (String) -> Unit,
    sexo: String,
    onSexoChanged: (String) -> Unit,
    descripcion: String,
    onDescripcionChanged: (String) -> Unit
) {
    var expandedTipo by remember { mutableStateOf(false) }
    val tipoOpciones = listOf("Perro", "Gato", "Ave", "Otro")

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = nombre,
                onValueChange = onNombreChanged,
                label = { Text("Nombre") },
                leadingIcon = { Icon(Icons.Default.Pets, null) },
                modifier = Modifier.fillMaxWidth()
            )
            val opciones = listOf("Macho", "Hembra")
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Sexo:")
                Spacer(Modifier.width(12.dp))
                SingleChoiceSegmentedButtonRow {
                    opciones.forEach { opcion ->
                        SegmentedButton(
                            selected = sexo == opcion,
                            onClick = { onSexoChanged(opcion) },
                            shape = RoundedCornerShape(8.dp),
                            label = { Text(opcion) }
                        )
                    }
                }
            }

            ExposedDropdownMenuBox(
                expanded = expandedTipo,
                onExpandedChange = { expandedTipo = !expandedTipo }) {
                OutlinedTextField(
                    value = tipo,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Tipo") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedTipo) },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expandedTipo,
                    onDismissRequest = { expandedTipo = false }) {
                    tipoOpciones.forEach { opcion ->
                        DropdownMenuItem(
                            text = { Text(opcion) },
                            onClick = {
                                onTipoChanged(opcion)
                                expandedTipo = false
                            }
                        )
                    }
                }
            }

            OutlinedTextField(
                value = edad,
                onValueChange = onEdadChanged,
                label = { Text("Edad aprox.") },
                leadingIcon = { Icon(Icons.Default.Cake, null) },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = descripcion,
                onValueChange = onDescripcionChanged,
                label = { Text("Descripción / comportamiento") },
                leadingIcon = { Icon(Icons.Default.Description, null) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                maxLines = 4
            )
        }
    }
}