package com.example.app_2.Provarjetpack

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import com.example.app_2.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text // O androidx.compose.material.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import com.example.app_2.ui.theme.fredoka
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource

@Preview
@Composable
fun inicio() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {

        Column() {
            Box(
                modifier = Modifier
                    .weight(4f)
                    .fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                Image(

                    painter = painterResource(id = R.drawable.perrologo),
                    contentDescription = "Logo de perro",
                )
            }
            Box(
                modifier = Modifier
                    .weight(4f)
                    .background(Color.Red)
                    .fillMaxWidth()
                ,contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Hey! bienbenido!",
                        fontSize = 30.sp,
                        fontFamily = fredoka,
                        modifier = Modifier.padding(15.dp)
                    )
                    Text(
                        text = "Aqui Cada Huellita Cuenta y Cada Historia Merece Un Final Felis \uD83D\uDC97 ",
                        fontSize = 20.sp,
                        fontFamily = fredoka
                        ,textAlign = TextAlign.Center
                        ,modifier = Modifier.padding(10.dp).padding(bottom = 20.dp)
                    )
                    Button(
                            onClick = {}
                            ,modifier = Modifier
                                .size(200.dp,50.dp)

                    ) {
                        Text(text = "Empezar >",fontSize = 20.sp,
                            fontFamily = fredoka,)
                    }
                }

            }
            Box(
                modifier = Modifier
                    .weight(2f)
                    .background(Color.Cyan)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center

            ) {
                Column(


                ) {
                    Text(
                        "Crea Una cuenta ",
                        fontSize = 25.sp,
                        fontFamily = fredoka,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Text(
                        "Iniciar Sesion",
                        fontSize = 25.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        fontFamily = fredoka

                    )
                }
            }
        }
    }
}

