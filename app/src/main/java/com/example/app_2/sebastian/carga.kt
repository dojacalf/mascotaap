package com.example.app_2.Provarjetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.app_2.R
import com.example.app_2.ui.theme.fredoka

@Preview(showBackground = true)
@Composable
fun App_2Preview() {
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
                    .background(Color.Cyan)
            ) {

            }
            Box(
                modifier = Modifier
                    .weight(2f)
                    //.background(Color.Cyan)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center

            ) {
                Column(


                ) {
                    Text(
                        "Cargando...",
                        fontSize = 30.sp,
                        fontFamily = fredoka,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Text(
                        "Juntos crearemos fimilas felises",
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        fontFamily = fredoka

                    )
                }
            }
        }
    }
}


