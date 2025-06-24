package com.example.app_2.ui.features.auth.register.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    leadingIconRes: Int,
    hintColor: Color,
    unfocusedBorderColor: Color,
    fontFamily: FontFamily,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(hint, color = hintColor, fontSize = 14.sp) },
        leadingIcon = {
            Image(
                painter = painterResource(leadingIconRes),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = unfocusedBorderColor,
            focusedBorderColor = unfocusedBorderColor,
            unfocusedContainerColor = Color.White
        ),
        textStyle = MaterialTheme.typography.bodySmall.copy(
            fontFamily = fontFamily,
            fontSize = 14.sp
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(vertical = 6.dp)
    )
}