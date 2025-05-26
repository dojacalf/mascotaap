package com.example.app_2.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text


@Composable
fun DetailScreen(navigateBack:()->Unit){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.weight(1f))
        Text("Details Screen", fontSize = 20.sp)
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {navigateBack()}) {
            Text("Atrás")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}
