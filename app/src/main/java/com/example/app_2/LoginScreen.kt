package com.example.app_2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(navigateToHome: (String)-> Unit){
    var text by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.weight(1f))
        Text("Login Screen", fontSize = 25.sp)
        Spacer(modifier = Modifier.weight(1f))
        OutlinedTextField(value = text,
            label = {Text("Ingrese su nombre: ")},
            onValueChange = {text=it})
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick =  {navigateToHome(text) }) {
            Text("Navegar a inicio")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}
