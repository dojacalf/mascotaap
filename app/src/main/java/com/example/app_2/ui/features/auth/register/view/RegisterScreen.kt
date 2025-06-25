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



@Composable
fun Registro(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        /* ---------- Decorative coloured shapes ---------- */
        Box(
            Modifier
                .offset(x = 250.dp, y = (-120).dp)
                .size(200.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer)
        )
        Box(
            Modifier
                .offset(x = 350.dp, y = (-10).dp)
                .size(170.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer)
        )
        Box(
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(50.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(40.dp))

            Image(
                painter = painterResource(R.drawable.register2),
                contentDescription = null,
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                "Registrarse",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(top = 24.dp, bottom = 4.dp)
            )
            Text(
                "Al registrarte, estás aceptando nuestros",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                "Términos y política de privacidad",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Iniciar sesión",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(end = 16.dp)
                )
                Text(
                    "Registrarse",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.drawWithContent {
                        drawContent()
                        /*
                        drawLine(
                            MaterialTheme.colorScheme.primary,
                            start = Offset(0f, size.height),
                            end   = Offset(size.width, size.height),
                            strokeWidth = 2f
                        )*/
                    }
                )
            }

            AuthTextField(
                value = email,
                onValueChange = { email = it },
                hint = "Correo electrónico",
                leadingIconRes = R.drawable.mail,
                modifier = Modifier.padding(vertical = 6.dp)
            )
            AuthTextField(
                value = password,
                onValueChange = { password = it },
                hint = "Contraseña",
                leadingIconRes = R.drawable.lock,
                modifier = Modifier.padding(vertical = 6.dp)
            )

            OptionRow(
                iconRes = R.drawable.a,
                text = "Recordar contraseña",
                modifier = Modifier.padding(vertical = 4.dp)
            )
            OptionRow(
                iconRes = R.drawable.b,
                text = "Olvidaste tu contraseña",
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Spacer(Modifier.height(16.dp))

            Button(
                onClick   = { navController.navigate("principal") },
                shape     = RoundedCornerShape(8.dp),
                colors    = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor   = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                elevation = ButtonDefaults.buttonElevation(0.dp),
                modifier  = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text("Register", style = MaterialTheme.typography.labelLarge)
            }

            Spacer(Modifier.height(24.dp))

            SocialLoginSeparator()

            Spacer(Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                SocialButton(R.drawable.facebook)
                Spacer(Modifier.width(24.dp))
                SocialButton(R.drawable.google, hasBorder = true)
                Spacer(Modifier.width(24.dp))
                SocialButton(R.drawable.apple)
            }

            Spacer(Modifier.weight(1f))

            Text(
                "© Todos los derechos reservados Incubaker • 2025",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
        }
    }
}