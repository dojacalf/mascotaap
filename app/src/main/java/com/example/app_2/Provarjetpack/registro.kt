package com.example.app_2.Provarjetpack

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.app_2.R
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text // O androidx.compose.material.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import com.example.app_2.ui.theme.fredoka
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.* // Para remember y mutableStateOf
import androidx.compose.material3.TextField // O androidx.compose.material.TextField si usas M2
import androidx.compose.material3.ExperimentalMaterial3Api // Puede ser necesaria dependiendo de la característica de TextField
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.material3.TextField // Importa el composable TextField
import androidx.compose.runtime.*
import androidx.compose.material3.OutlinedTextField // O androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.material3.Button // Importa el composable Button
import androidx.compose.material3.ButtonDefaults // Importa objetos para colores predefinidos y otros defaults
import androidx.compose.material3.Text // Si pones texto dentro del botón

@Preview(showBackground = true)
@Composable
fun registro() {
    var texto by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {

        Column() {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                Image(

                    painter = painterResource(id = R.drawable.perrologo),
                    contentDescription = "Logo de perro",
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Registrarse")
                Text("Al registrase estas aceptando nuestros")
                Text("Terminos y politicas de privacidad")
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("iniciar sesion")
                Text("Regisrrarse")
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = texto,
                    onValueChange = { nuevoTexto -> texto = nuevoTexto },
                    label = { Text("Correo electronico") }
                )
                OutlinedTextField(
                    value = texto,
                    onValueChange = { nuevoTexto -> texto = nuevoTexto },
                    label = { Text("Contraseña") }
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    // Acción que se ejecutará cuando se haga clic en el botón
                    println("¡Botón clicado!")
                    // Aquí puedes navegar a otra pantalla, mostrar un diálogo, etc.
                }) {
                    // Contenido del botón (generalmente un Text)
                    Text("Haz clic aquí")
                }
                Button(onClick = {
                    // Acción que se ejecutará cuando se haga clic en el botón
                    println("recordar contraseña")
                    // Aquí puedes navegar a otra pantalla, mostrar un diálogo, etc.
                }) {
                    // Contenido del botón (generalmente un Text)
                    Text("? olbidaste con contraseña")
                }
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    // Acción que se ejecutará cuando se haga clic en el botón
                    println("¡Botón clicado!")
                    // Aquí puedes navegar a otra pantalla, mostrar un diálogo, etc.
                }) {
                    // Contenido del botón (generalmente un Text)
                    Text("Registrarse")
                }

            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("o conectate con")
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {
                    // Acción que se ejecutará cuando se haga clic en el botón
                    println("¡Botón clicado!")
                    // Aquí puedes navegar a otra pantalla, mostrar un diálogo, etc.
                }) {
                    // Contenido del botón (generalmente un Text)
                    Text("f")
                }
                Button(onClick = {
                    // Acción que se ejecutará cuando se haga clic en el botón
                    println("¡Botón clicado!")
                    // Aquí puedes navegar a otra pantalla, mostrar un diálogo, etc.
                }) {
                    // Contenido del botón (generalmente un Text)
                    Text("g")
                }
                Button(onClick = {
                    // Acción que se ejecutará cuando se haga clic en el botón
                    println("¡Botón clicado!")
                    // Aquí puedes navegar a otra pantalla, mostrar un diálogo, etc.
                }) {
                    // Contenido del botón (generalmente un Text)
                    Text("a")
                }
            }

            Column(

            ) {
                Text(
                    "todos los derechos reserbados",
                    fontSize = 25.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontFamily = fredoka

                )
            }

        }
    }
}
