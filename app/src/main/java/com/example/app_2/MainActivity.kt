package com.example.app_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.app_2.navigation.AppNavigation
import com.example.app_2.ui.features.actividad
import com.example.app_2.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            /*AppTheme {
                AppNavigation()
            }*/
            actividad()
        }
    }
}

