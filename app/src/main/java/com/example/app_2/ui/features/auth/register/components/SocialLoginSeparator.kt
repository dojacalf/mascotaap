package com.example.app_2.ui.features.auth.register.components


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SocialLoginSeparator(
    textColor: Color,
    dividerColor: Color,
    fontFamily: FontFamily,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Divider(Modifier.weight(1f), color = dividerColor, thickness = 1.dp)
        Text(
            "O conéctate con",
            fontSize = 12.sp,
            color = textColor,
            fontFamily = fontFamily,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
        Divider(Modifier.weight(1f), color = dividerColor, thickness = 1.dp)
    }
}