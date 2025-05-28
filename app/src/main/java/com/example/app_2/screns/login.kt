package com.example.app_2.Provarjetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_2.R
import com.example.app_2.ui.theme.fredoka


val amarillo = Color(0xFFF4B500)

@Composable
fun LoginScreen( navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        BackgroundDecorations()

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LogoSection(
                modifier = Modifier.weight(1.5f)
            )

            InputFieldsSection(
                email = email,
                onEmailChange = { email = it },
                password = password,
                onPasswordChange = { password = it },
                onForgotPasswordClick = { /* TODO: Implement forgot password */ },
                onLoginClick = { navController.navigate("principal")},
                modifier = Modifier.weight(2f) // Increased weight for better visibility
            )

            SocialLoginSection(
                onGoogleLoginClick = { /* TODO: Google Login */ },
                onFacebookLoginClick = { /* TODO: Facebook Login */ },
                onAppleLoginClick = { /* TODO: Apple Login */ },
                modifier = Modifier.weight(2f)
            )

            FooterSection(
                modifier = Modifier.weight(0.3f)
            )
        }
    }
}

@Composable
private fun BackgroundDecorations() {
    Image(
        painter = painterResource(id = R.drawable.buenperro),
        contentDescription = "Imagen de registro",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .fillMaxSize()
    )

    // Círculo superior derecho grande
    Box(
        modifier = Modifier
            .offset(x = 250.dp, y = (-120).dp)
            .size(200.dp)
            .clip(CircleShape)
            .background(amarillo)
    )

    // Segundo círculo más pequeño (debajo del grande)
    Box(
        modifier = Modifier
            .offset(x = 350.dp, y = -10.dp)
            .size(170.dp)
            .clip(CircleShape)
            .background(amarillo)
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
            contentDescription = "Logo de la aplicación",
            //modifier = Modifier.fillMaxWidth(0.3f),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun InputFieldsSection(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            label = { Text("Correo electrónico", color = Color.Gray) },
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = null, tint = Color.Gray)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFEEEEEE),
                unfocusedContainerColor = Color(0xFFEEEEEE),
                disabledContainerColor = Color(0xFFEEEEEE),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = { Text("Contraseña", color = Color.Gray) },
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = null, tint = Color.Gray)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFEEEEEE),
                unfocusedContainerColor = Color(0xFFEEEEEE),
                disabledContainerColor = Color(0xFFEEEEEE),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
            // visualTransformation = PasswordVisualTransformation() // Uncomment for password visibility
        )

        Text(
            text = "¿Olvidaste tu contraseña?",
            fontSize = 14.sp,
            color = Color(0xFF4CAF50), // Green color
            fontFamily = FontFamily.Default,
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 8.dp)
                .clickable(onClick = onForgotPasswordClick)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Login Button - Más visible y destacado
        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = amarillo,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(28.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 6.dp,
                pressedElevation = 12.dp
            )
        ) {
            Text(
                text = "INICIAR SESIÓN",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fredoka,
                color = Color.White,
                letterSpacing = 1.sp
            )
        }
    }
}

@Composable
private fun SocialLoginSection(
    onGoogleLoginClick: () -> Unit,
    onFacebookLoginClick: () -> Unit,
    onAppleLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top // Changed to Top
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "O conéctate con",
            fontSize = 16.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF666666),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // Google Login Button
        Button(
            onClick = onGoogleLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEEEEEE)
            ),
            shape = RoundedCornerShape(24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Iniciar Sesión Con Google",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Default,
                color = Color(0xFF333333)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Facebook Login Button
        Button(
            onClick = onFacebookLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEEEEEE)
            ),
            shape = RoundedCornerShape(24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Iniciar Sesión Con Facebook",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Default,
                color = Color(0xFF333333)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Apple Login Button
        Button(
            onClick = onAppleLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEEEEEE)
            ),
            shape = RoundedCornerShape(24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Iniciar Sesión Con Apple",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Default,
                color = Color(0xFF333333)
            )
        }
    }
}

@Composable
private fun FooterSection(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(amarillo),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "© Todos los derechos reservados MascotApp - 2025",
            fontSize = 11.sp,
            fontFamily = FontFamily.Default,
            color = Color.Black.copy(alpha = 0.6f),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}