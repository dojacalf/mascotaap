package com.example.app_2.ui.theme


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val AppShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),  // Para chips, tags
    small = RoundedCornerShape(8.dp),      // Para botones pequeños, checkboxes
    medium = RoundedCornerShape(12.dp),    // Para tarjetas, dialogs
    large = RoundedCornerShape(16.dp),     // Para botones estándar, FABs
    extraLarge = RoundedCornerShape(24.dp)  // Para full-screen modals
)