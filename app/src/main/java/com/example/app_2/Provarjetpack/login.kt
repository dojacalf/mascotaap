package com.example.app_2.Provarjetpack

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
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
import com.example.app_2.R
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


@Preview
@Composable
fun login() {
    var texto by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {

        Column() {
            Box(
                modifier = Modifier
                    .weight(4f)
                    .fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                Image(

                    painter = painterResource(id = R.drawable.perrologo),
                    contentDescription = "Logo de perro",
                )
            }
            Column(
                modifier = Modifier
                    .weight(4f)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = texto,
                    onValueChange = { nuevoTexto -> texto = nuevoTexto},
                    label = {Text("correo electronico")}
                )
                OutlinedTextField(
                    value = texto,
                    onValueChange = { nuevoTexto -> texto = nuevoTexto},
                    label = {Text("contraseña")}
                )
            }
            Box(
                modifier = Modifier
                    .weight(4f)
                    .background(Color.Red)
                    .fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "o conectate con",
                        fontSize = 30.sp,
                        fontFamily = fredoka,
                        modifier = Modifier.padding(15.dp)
                    )
                    Button(onClick = {}){
                        Text("Iniciar Secion Con google")
                    }
                    Button(onClick = {}){
                        Text("Iniciar Secion Con Facebook")
                    }
                    Button(onClick = {}){
                        Text("Iniciar Secion Con Apple")
                    }
                }

            }
            Box(
                modifier = Modifier
                    .weight(2f)
                    .background(Color.Cyan)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center

            ) {
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
}

