package com.example.app_2.ui.features

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun actividad(){
    Column (
        Modifier.fillMaxSize().statusBarsPadding()
    ){
        Text("codigo antes de probar runtime")
    }

}

