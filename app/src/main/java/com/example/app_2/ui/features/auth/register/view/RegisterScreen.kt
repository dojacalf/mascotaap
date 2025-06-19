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

/** Public entry point used by NavHost. */
@Composable
fun Registro(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        /* ---------- Decorative coloured shapes ---------- */
        Box(
            Modifier
                .offset(x = 250.dp, y = (-120).dp)
                .size(200.dp)
                .clip(CircleShape)
                .background(Palette.Yellow)
        )
        Box(
            Modifier
                .offset(x = 350.dp, y = (-10).dp)
                .size(170.dp)
                .clip(CircleShape)
                .background(Palette.Yellow)
        )
        Box(
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(50.dp)
                .background(Palette.Yellow)
        )

        /* ---------- Main column ---------- */
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(Modifier.height(40.dp))

            /* -- header image -- */
            Image(
                painter = painterResource(R.drawable.register2),
                contentDescription = null,
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Fit
            )

            /* -- titles -- */
            Text(
                "Registrarse",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fredoka,
                modifier = Modifier.padding(top = 24.dp, bottom = 4.dp)
            )
            Text(
                "Al registrarte, estás aceptando nuestros",
                fontSize = 15.sp,
                color = Palette.TextGray,
                fontFamily = fredoka
            )
            Text(
                "Términos y política de privacidad",
                fontSize = 15.sp,
                color = Palette.Accent,
                fontWeight = FontWeight.Medium,
                fontFamily = fredoka,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            /* -- tabs (“Iniciar sesión” / “Registrarse”) -- */
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Iniciar sesión",
                    color = Palette.TextGray,
                    fontSize = 17.sp,
                    fontFamily = fredoka,
                    modifier = Modifier.padding(end = 16.dp)
                )
                Text(
                    "Registrarse",
                    color = Palette.Accent,
                    fontSize = 17.sp,
                    fontFamily = fredoka,
                    modifier = Modifier.drawWithContent {
                        drawContent()
                        drawLine(
                            Palette.Yellow,
                            start = Offset(0f, size.height),
                            end   = Offset(size.width, size.height),
                            strokeWidth = 2f
                        )
                    }
                )
            }

            /* -- form fields -- */
            AuthTextField(
                value = email,
                onValueChange = { email = it },
                hint = "Correo electrónico",
                leadingIconRes = R.drawable.mail,
                hintColor = Palette.TextGray,
                unfocusedBorderColor = Color.LightGray,
                fontFamily = fredoka
            )
            AuthTextField(
                value = password,
                onValueChange = { password = it },
                hint = "Contraseña",
                leadingIconRes = R.drawable.lock,
                hintColor = Palette.TextGray,
                unfocusedBorderColor = Color.LightGray,
                fontFamily = fredoka
            )

            /* -- remember / forgot -- */
            OptionRow(
                iconRes = R.drawable.a,
                text = "Recordar contraseña",
                textColor = Palette.TextGray,
                fontFamily = fredoka
            )
            OptionRow(
                iconRes = R.drawable.b,
                text = "Olvidaste tu contraseña",
                textColor = Palette.TextGray,
                fontFamily = fredoka
            )

            Spacer(Modifier.height(16.dp))

            /* -- register button -- */
            Button(
                onClick   = { navController.navigate("principal") },
                shape     = RoundedCornerShape(8.dp),
                colors    = ButtonDefaults.buttonColors(
                    containerColor = Palette.LightGray,
                    contentColor   = Color.Black
                ),
                elevation = ButtonDefaults.buttonElevation(0.dp),
                modifier  = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text("Register", fontWeight = FontWeight.Medium, fontFamily = fredoka, fontSize = 15.sp)
            }

            Spacer(Modifier.height(24.dp))

            /* -- “o conéctate con” separator -- */
            SocialLoginSeparator(
                textColor = Palette.TextGray,
                dividerColor = Color.LightGray,
                fontFamily = fredoka
            )

            Spacer(Modifier.height(20.dp))

            /* -- social buttons -- */
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                SocialButton(R.drawable.facebook, Palette.FacebookBlu)
                Spacer(Modifier.width(24.dp))
                SocialButton(
                    iconRes = R.drawable.google,
                    backgroundColor = Color.White,
                    hasBorder = true
                )
                Spacer(Modifier.width(24.dp))
                SocialButton(R.drawable.apple, Color(0xFF000000)) // solid black apple background
            }

            Spacer(Modifier.weight(1f))

            /* -- footer -- */
            Text(
                "© Todos los derechos reservados Incubaker • 2025",
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                fontFamily = fredoka,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
        }
    }
}