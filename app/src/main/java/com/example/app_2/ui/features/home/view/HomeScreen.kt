package com.example.app_2.ui.features.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen(name: String, navigationToDetails: ()-> Unit){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.weight(1f))
        Text("Bienvenido al Inicio", fontSize = 25.sp)
        Text("$name", fontSize = 25.sp)
        Spacer(modifier = Modifier.weight(1f))
        Button( onClick = {navigationToDetails()}) {
            Text("More Details")
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}
