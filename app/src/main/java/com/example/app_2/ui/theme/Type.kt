package com.example.app_2.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.app_2.R


val fredoka = FontFamily(
    Font(R.font.fredoka, FontWeight.Normal),
)

private val Fredoka = FontFamily(
    Font(R.font.fredoka_regular, FontWeight.Normal),
    Font(R.font.fredoka_semibold, FontWeight.SemiBold)
)


val AppTypography = Typography(
    headlineLarge = Typography().headlineLarge.copy(fontFamily = Fredoka),
    headlineMedium = Typography().headlineMedium.copy(fontFamily = Fredoka),
    bodyLarge = Typography().bodyLarge.copy(fontFamily = Fredoka),
    bodyMedium = Typography().bodyMedium.copy(fontFamily = Fredoka),
    bodySmall = TextStyle(
        fontFamily = fredoka,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    titleLarge = TextStyle(
        fontFamily = fredoka,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    labelSmall = TextStyle(
        fontFamily = fredoka,
        fontSize = 12.sp
    ),
    labelMedium = TextStyle(
        fontFamily = fredoka,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp
    )
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

