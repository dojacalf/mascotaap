package com.example.app_2.ui.features.carga

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_2.R
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

@Composable
fun Cargando() {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primaryContainer,
                        MaterialTheme.colorScheme.secondaryContainer
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        AnimatedBackground()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.perrologo),
                contentDescription = "App logo",
                modifier = Modifier.size(350.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Cargando...",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onBackground
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(vertical = 16.dp)
            ) {
                AnimatedProgressBar()

                WalkingPet()
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Creando conexiones felices",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Composable
fun AnimatedBackground() {
    val infiniteTransition = rememberInfiniteTransition(label = "backgroundAnimation")
    val offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(15000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "bgOffset"
    )

    val primary = Color(0xFF6A11CB)
    val secondary = Color(0xFF2575FC)
    val tertiary = Color(0xFFFFA500)

    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawRect(
            brush = Brush.linearGradient(
                0.0f to primary.copy(alpha = 0.05f),
                0.5f to secondary.copy(alpha = 0.03f),
                1.0f to tertiary.copy(alpha = 0.05f),
                start = Offset(canvasWidth * offset, 0f),
                end = Offset(canvasWidth * offset + canvasWidth, canvasHeight)
            ),
            size = size
        )

        val shapeSize = canvasWidth * 0.3f
        drawCircle(
            color = primary.copy(alpha = 0.08f),
            center = Offset(canvasWidth * 0.2f, canvasHeight * (0.3f + offset * 0.1f)),
            radius = shapeSize
        )

        drawCircle(
            color = tertiary.copy(alpha = 0.06f),
            center = Offset(canvasWidth * 0.8f, canvasHeight * (0.7f - offset * 0.1f)),
            radius = shapeSize * 0.7f
        )
    }
}

@Composable
fun AnimatedProgressBar() {
    var progress by remember { mutableStateOf(0f) }

    LaunchedEffect(Unit) {
        repeat(100) {
            progress = it / 100f
            delay(40)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progress)
                .height(16.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary
                        )
                    )
                )
        )

        Canvas(modifier = Modifier.matchParentSize()) {
            drawRect(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.3f),
                        Color.Transparent
                    )
                ),
                topLeft = Offset(0f, 0f),
                size = Size(size.width * progress, size.height)
            )
        }
    }
}

@Composable
fun WalkingPet() {
    val frameCount = 8
    val density = LocalDensity.current
    val screenWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val boxSize = 60.dp

    val screenWidthPx = with(density) { screenWidthDp.toPx() }
    val boxSizePx = with(density) { boxSize.toPx() }

    val frameAnim = rememberInfiniteTransition(label = "frameAnim")
    val frame by frameAnim.animateFloat(
        initialValue = 0f,
        targetValue = frameCount.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 800
                for (i in 0 until frameCount) i.toFloat() at (i * 100)
            },
            repeatMode = RepeatMode.Restart
        ),
        label = "frame"
    )
    val currentFrame = frame.roundToInt() % frameCount

    val posAnim = rememberInfiniteTransition(label = "posAnim")
    val position by posAnim.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "pos"
    )

    val bounceAnim = rememberInfiniteTransition(label = "bounceAnim")
    val bounce by bounceAnim.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 500
                0f at 0; 1f at 250; 0f at 500
            },
            repeatMode = RepeatMode.Restart
        ),
        label = "bounce"
    )
    val bounceOffsetPx = bounce * with(density) { 15.dp.toPx() }

    val frameResId = when (currentFrame) {
        0 -> R.drawable.dog1
        1 -> R.drawable.dog2
        2 -> R.drawable.dog3
        3 -> R.drawable.dog4
        4 -> R.drawable.dog5
        5 -> R.drawable.dog6
        6 -> R.drawable.dog7
        else -> R.drawable.dog8
    }

    Box(
        modifier = Modifier
            .offset {
                IntOffset(
                    x = (position * (screenWidthPx - boxSizePx)).toInt(),
                    y = (-bounceOffsetPx).toInt()
                )
            }
            .size(boxSize)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(12.dp),
                ambientColor = Color.Black.copy(alpha = 0.2f),
                spotColor = Color.Black.copy(alpha = 0.4f)
            )
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Transparent)
    ) {
        Image(
            painter = painterResource(id = frameResId),
            contentDescription = "Mascota caminando",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )

        Canvas(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(8.dp)
        ) {
            val radius = size.width / 3 * (1f - bounce * 0.7f)
            drawCircle(
                color = Color.Black.copy(alpha = 0.2f - bounce * 0.15f),
                center = Offset(size.width / 2, 0f),
                radius = radius
            )
        }
    }
}