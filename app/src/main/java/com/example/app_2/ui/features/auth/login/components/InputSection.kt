package com.example.app_2.ui.features.auth.login.components

import android.util.Patterns
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_2.ui.theme.fredoka

private fun enableLogin(email: String, password: String) =
    Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6

@Composable
fun InputSection(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onForgotPassword: () -> Unit,
    onLogin: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val isLoginEnabled = enableLogin(email, password)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BrandTextField(
            value = email,
            onValueChange = onEmailChange,
            label = "Correo electrónico",
            leading = { Icon(Icons.Default.Email, contentDescription = null) }
        )

        Spacer(Modifier.height(8.dp))

        BrandTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = "Contraseña",
            leading = { Icon(Icons.Default.Lock, contentDescription = null) }
        )

        Text(
            "¿Olvidaste tu contraseña?",
            fontSize = 14.sp,
            color = VerdeLink,
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 8.dp)
                .clickable(onClick = onForgotPassword)
        )

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = onLogin,
            enabled = isLoginEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AmarilloPrincipal,
                contentColor   = Color.White,
                disabledContainerColor = Color.Cyan,
                disabledContentColor  = Color.White,
            ),
            shape = RoundedCornerShape(28.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 6.dp,
                pressedElevation = 12.dp
            )
        ) {
            Text(
                "INICIAR SESIÓN",
                fontSize = 18.sp,
                fontFamily = fredoka,
                letterSpacing = 1.sp
            )
        }
    }
}

