package com.example.app_2.ui.features.auth.register.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_2.ui.features.auth.register.components.AuthTextField
import com.example.app_2.ui.features.auth.register.components.OptionRow
import com.example.app_2.ui.features.auth.register.components.SocialButton
import com.example.app_2.ui.features.auth.register.components.SocialLoginSeparator
import com.example.app_2.R

// Paleta y fuente definidas localmente en el archivo de la pantalla.
private object Palette {
    val Yellow      = Color(0xFFFFD600)
    val LightGray   = Color(0xFFF5F5F5)
    val TextGray    = Color(0xFF9E9E9E)
    val Accent      = Color(0xFF9C7F41)
    val FacebookBlu = Color(0xFF3b5998)
}

private val fredoka = FontFamily(
    Font(R.font.fredoka_regular) // Asegúrate de que este recurso exista en res/font
)

@Composable
fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    leadingIconRes: Int,
    modifier: Modifier = Modifier
) {
    val colors = MaterialTheme.colorScheme
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                hint,
                style = MaterialTheme.typography.bodySmall,
                color = colors.onSurfaceVariant
            )
        },
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
            unfocusedBorderColor = colors.outline,
            focusedBorderColor = colors.primary,
            unfocusedContainerColor = colors.surface,
            focusedContainerColor = colors.surface
        ),
        textStyle = MaterialTheme.typography.bodySmall.copy(
            fontSize = 14.sp
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(vertical = 6.dp)
    )
}