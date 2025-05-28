package com.example.app_2.screns

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_2.R
import androidx.compose.foundation.lazy.items


val Fredoka = FontFamily(Font(com.example.app_2.R.font.fredoka_semibold))
val Fredoka1 = FontFamily(Font(com.example.app_2.R.font.fredoka_regular))

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen() {
    val notifications = listOf(
        AdoptionNotification(
            id = 1,
            user = "Inés",
            userImage = R.drawable.mujer_mascota,
            petImage = R.drawable.mujer_mascota,
            message = "quiere adoptar a tu mascota",
            time = "Hace 2 horas",
            accepted = false
        ),
        AdoptionNotification(
            id = 2,
            user = "Sam",
            userImage = R.drawable.sam,
            petImage = R.drawable.korayma,
            message = "desea conocer a tu gata",
            time = "Ayer",
            accepted = true
        )
    )

    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            AdoptionTopBar()
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFFFF7F0),
                                Color(0xFFFFE8D6)
                            )
                        )
                    )
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(vertical = 16.dp)
                ) {
                    items(notifications) { notification ->
                        AdoptionNotificationCard(notification)
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdoptionTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                "Solicitudes de adopción",
                style = TextStyle(
                    fontFamily = Fredoka,
                    fontSize = 24.sp,
                    color = Color(0xFF03063A),
                    letterSpacing = 0.5.sp
                )
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color(0xFF3B7AE8)
        ),
        modifier = Modifier.shadow(
            elevation = 8.dp,
            shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
        )
    )
}

@Composable
fun AdoptionNotificationCard(notification: AdoptionNotification) {
    var isAccepted by remember { mutableStateOf(notification.accepted) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(24.dp),
                spotColor = Color(0x405E3BE8)
            ),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Image(
                    painter = painterResource(id = notification.userImage),
                    contentDescription = "Foto de ${notification.user}",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color(0xFFFFA451), CircleShape),
                    contentScale = ContentScale.Crop
                )

                Column {
                    Text(
                        text = notification.user,
                        style = TextStyle(
                            fontFamily = Fredoka,
                            fontSize = 18.sp,
                            color = Color(0xFF333333)
                        )
                    )
                    Text(
                        text = notification.time,
                        style = TextStyle(
                            fontFamily = Fredoka1,
                            fontSize = 12.sp,
                            color = Color(0xFF888888)
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    painter = painterResource(id = notification.petImage),
                    contentDescription = "Mascota",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .border(2.dp, Color(0xFFFFA451), RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "${notification.user} ${notification.message}",
                    style = TextStyle(
                        fontFamily = Fredoka1,
                        fontSize = 16.sp,
                        color = Color(0xFF555555)
                    ),
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = { isAccepted = !isAccepted },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isAccepted) Color(0xFF4CAF50) else Color(0xFF5E3BE8),
                        contentColor = Color.White
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 4.dp,
                        pressedElevation = 8.dp
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = if (isAccepted) Icons.Filled.CheckCircle else Icons.Filled.Pets,
                            contentDescription = null
                        )
                        Text(
                            text = if (isAccepted) "ADOPTADO" else "ACEPTAR",
                            style = TextStyle(
                                fontFamily = Fredoka,
                                fontSize = 14.sp,
                                letterSpacing = 0.8.sp
                            )
                        )
                    }
                }

                OutlinedButton(
                    onClick = { /* Lógica para rechazar */ },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.5.dp, Color(0xFFF44336)),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFFF44336)
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = null
                        )
                        Text(
                            text = "RECHAZAR",
                            style = TextStyle(
                                fontFamily = Fredoka,
                                fontSize = 14.sp,
                                letterSpacing = 0.8.sp
                            )
                        )
                    }
                }
            }
        }
    }
}

data class AdoptionNotification(
    val id: Int,
    val user: String,
    val userImage: Int,
    val petImage: Int,
    val message: String,
    val time: String,
    val accepted: Boolean
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AdoptionNotificationsScreenPreview() {
    MaterialTheme(
        typography = Typography(
            titleLarge = TextStyle(fontFamily = Fredoka),
            bodyMedium = TextStyle(fontFamily = Fredoka1)
        )
    ) {
        NotificationsScreen()
    }
}