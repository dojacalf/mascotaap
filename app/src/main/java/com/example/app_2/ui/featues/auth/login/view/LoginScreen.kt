package com.example.app_2.ui.featues.auth.login.view

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_2.R
import com.example.app_2.ui.theme.fredoka


val AmarilloPrincipal = Color(0xFFF4B500)
val FondoBlanco = Color(0xFFEEEEEE)
val CaptionGrey = Color(0xFF666666)
val VerdeLink = Color(0xFF4CAF50)

private fun enableLogin(email: String, password: String): Boolean =
    Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6

@Preview(showBackground = true)
@Composable
fun LoginPrevier() {
    LoginScreen(navController = NavController(context = LocalContext.current))
}


@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundDecorations()

        Column(modifier = Modifier.fillMaxSize()) {

            LogoSection(Modifier.weight(1.5f))

            InputSection(
                email = email,
                onEmailChange = { email = it },
                password = password,
                onPasswordChange = { password = it },
                onForgotPassword = { /* TODO: forgot password flow */ },
                onLogin = { navController.navigate("principal") },
                modifier = Modifier.weight(2f)
            )

            SocialSection(
                onGoogle = { /* TODO: Google auth */ },
                onFacebook = { /* TODO: Facebook auth */ },
                onApple = { /* TODO: Apple auth  */ },
                modifier = Modifier.weight(2f)
            )

            Footer(Modifier.weight(0.3f))
        }
    }
}


@Composable
private fun BrandTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leading: @Composable () -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = Color.Gray) },
        leadingIcon = leading,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = FondoBlanco,
            unfocusedContainerColor = FondoBlanco,
            disabledContainerColor = FondoBlanco,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )
}

@Composable
private fun SocialButton(
    iconRes: Int,
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = FondoBlanco),
        shape = RoundedCornerShape(24.dp)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Spacer(Modifier.width(8.dp))
        Text(text, fontSize = 14.sp, color = Color(0xFF333333))
    }
}

@Composable
private fun BackgroundDecorations() {
    Image(
        painter = painterResource(id = R.drawable.buenperro),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier.fillMaxSize()
    )

    // Large upper‑right circle
    Box(
        Modifier
            .offset(x = 250.dp, y = (-120).dp)
            .size(200.dp)
            .clip(CircleShape)
            .background(AmarilloPrincipal)
    )

    // Smaller circle underneath
    Box(
        Modifier
            .offset(x = 350.dp, y = (-10).dp)
            .size(170.dp)
            .clip(CircleShape)
            .background(AmarilloPrincipal)
    )
}

@Composable
private fun LogoSection(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.perro2),
            contentDescription = "MascotApp logo",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun InputSection(
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
            leading = { Icon(Icons.Default.Email, contentDescription = null, tint = Color.Gray) }
        )

        Spacer(Modifier.height(8.dp))

        BrandTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = "Contraseña",
            leading = { Icon(Icons.Default.Lock, contentDescription = null, tint = Color.Gray) },
            //visualTransformation = PasswordVisualTransformation()
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
                contentColor = Color.White,
                disabledContainerColor = Color.Red,
                disabledContentColor = Color.White,
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
                fontWeight = FontWeight.Bold,
                fontFamily = fredoka,
                letterSpacing = 1.sp
            )
        }
    }
}

@Composable
private fun SocialSection(
    onGoogle: () -> Unit,
    onFacebook: () -> Unit,
    onApple: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(24.dp))

        Text(
            "O conéctate con",
            fontSize = 16.sp,
            color = CaptionGrey,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        SocialButton(R.drawable.google, "Iniciar Sesión Con Google", onGoogle)
        Spacer(Modifier.height(12.dp))
        SocialButton(R.drawable.facebook, "Iniciar Sesión Con Facebook", onFacebook)
        Spacer(Modifier.height(12.dp))
        SocialButton(R.drawable.apple, "Iniciar Sesión Con Apple", onApple)
    }
}

@Composable
private fun Footer(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(AmarilloPrincipal),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "© Todos los derechos reservados MascotApp - 2025",
            fontSize = 11.sp,
            color = Color.Black.copy(alpha = 0.6f),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}
