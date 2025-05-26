package com.example.app_2.Provarjetpack


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_2.R
import com.example.app_2.ui.theme.fredoka

// Colores personalizados según el diseño
val YellowAccent = Color(0xFFFFD600)
val LightGray = Color(0xFFF5F5F5)
val TextGray = Color(0xFF9E9E9E)
val registrarse = Color(0xFF9C7F41)
val FacebookBlue = Color(0xFF3b5998)
val plomo1 = Color(0xFFA6A6A6)
val color1 = Color(0xFF3b5998)



@Preview(showBackground = true)
@Composable
fun Registro() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberPassword by remember { mutableStateOf(false) }
    var forgotPassword by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
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

        // Esquina amarilla inferior
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(50.dp)
                .background(amarillo)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            // Imagen del registro con borde redondeado
            Box(
                modifier = Modifier
                    .size(200.dp)
                    //.clip(RoundedCornerShape(16.dp))
                    .background(Color.Transparent),

                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.register2),
                    contentDescription = "Imagen de registro",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }

            // Textos de registro
            Text(
                text = "Registrarse",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fredoka,
                modifier = Modifier.padding(top = 24.dp, bottom = 4.dp)
            )

            Text(
                text = "Al registrarte, estás aceptando nuestros",
                fontSize = 15.sp,
                color = plomo1,
                fontFamily = fredoka
            )

            Text(
                text = "Términos y política de privacidad",
                fontSize = 15.sp,
                color = registrarse,
                fontWeight = FontWeight.Medium,
                fontFamily = fredoka,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Opciones de inicio de sesión / registro
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Iniciar sesión",
                    color = plomo1,
                    fontSize = 17.sp,
                    fontFamily = fredoka,
                    modifier = Modifier.padding(end = 16.dp)
                )

                Text(
                    text = "Registrarse",
                    color = registrarse,
                    fontSize = 17.sp,
                    modifier = Modifier
                        .drawWithContent {
                            drawContent()
                            drawLine(
                                Color.Yellow,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = 2f
                            )
                        }
                )

            }

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de correo electrónico
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Correo electrónico", color = TextGray, fontSize = 14.sp) },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.mail),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.LightGray,
                    focusedBorderColor = Color.LightGray,
                    unfocusedContainerColor = Color.White
                ),
                singleLine = true,
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 14.sp,
                    fontFamily = fredoka
                )
            )

            // Campo de contraseña
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Contraseña", color = TextGray, fontSize = 14.sp) },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.lock),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.LightGray,
                    focusedBorderColor = Color.LightGray,
                    unfocusedContainerColor = Color.White
                ),
                singleLine = true,
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 14.sp,
                    fontFamily = fredoka
                )
            )

            // Opciones de contraseña
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f),
                            horizontalArrangement = Arrangement.Center,

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.a),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Recordar contraseña",
                        fontSize = 16.sp,
                        color = TextGray,
                        fontFamily = fredoka
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f),
                            horizontalArrangement = Arrangement.Center,

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.b),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Olvidaste tu contraseña",
                        fontSize = 16.sp,
                        color = TextGray,
                        fontFamily = fredoka
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de registro
            Button(
                onClick = { /* Acción de registro */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGray,
                    contentColor = Color.Black
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 0.dp
                )
            ) {
                Text(
                    text = "Register",
                    fontWeight = FontWeight.Medium,
                    fontFamily = fredoka,
                    fontSize = 15.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Separador "o conéctate con"
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Divider(
                    modifier = Modifier.weight(1f),
                    color = Color.LightGray,
                    thickness = 1.dp
                )
                Text(
                    text = "O conéctate con",
                    modifier = Modifier.padding(horizontal = 12.dp),
                    color = TextGray,
                    fontSize = 12.sp,
                    fontFamily = fredoka
                )
                Divider(
                    modifier = Modifier.weight(1f),
                    color = Color.LightGray,
                    thickness = 1.dp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Botones de redes sociales
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                // Facebook
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(FacebookBlue)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.width(24.dp))

                // Google
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.width(24.dp))

                // Apple
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.apple),
                        contentDescription = "Imagen de registro",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "© Todos los derechos reservados Incubaker • 2025",
                    fontSize = 13.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontFamily = fredoka
                )
            }
        }
    }
}