package com.example.app_2.ui.features.encuentra.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_2.R

@Composable
fun WelcomeTextSection(
    title: String,
    subtitle: String
) {
    val Fredoka = FontFamily(Font(R.font.fredoka_semibold))
    Text(
        text = title,
        fontSize = 32.sp,
        textAlign = TextAlign.Center,
        lineHeight = 34.sp,
        color = MaterialTheme.colorScheme.onBackground,
        fontFamily = Fredoka,
        modifier = Modifier.padding(bottom = 16.dp)
    )

    val Fredoka1 = FontFamily(Font(R.font.fredoka_regular))
    Column(
        modifier = Modifier.padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = subtitle,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontFamily = Fredoka1
        )
    }
}