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
import androidx.compose.ui.res.stringResource
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
        // ...decorative shapes omitidas para brevedad...

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
                text = stringResource(R.string.register_title),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(top = 24.dp, bottom = 4.dp)
            )

            Text(
                text = stringResource(R.string.register_terms),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = stringResource(R.string.register_privacy),
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
                    text = stringResource(R.string.login_option),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(end = 16.dp)
                )
                Text(
                    text = stringResource(R.string.register_option),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.drawWithContent {
                        drawContent()
                    }
                )
            }

            AuthTextField(
                value = email,
                onValueChange = { email = it },
                hint = stringResource(R.string.hint_email),
                leadingIconRes = R.drawable.mail,
                modifier = Modifier.padding(vertical = 6.dp)
            )

            AuthTextField(
                value = password,
                onValueChange = { password = it },
                hint = stringResource(R.string.hint_password),
                leadingIconRes = R.drawable.lock,
                modifier = Modifier.padding(vertical = 6.dp)
            )

            OptionRow(
                iconRes = R.drawable.a,
                text = stringResource(R.string.option_remember),
                modifier = Modifier.padding(vertical = 4.dp)
            )

            OptionRow(
                iconRes = R.drawable.b,
                text = stringResource(R.string.option_forgot),
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("principal") },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor   = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                elevation = ButtonDefaults.buttonElevation(0.dp),
                modifier  = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(stringResource(R.string.button_register),
                    style = MaterialTheme.typography.labelLarge)
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
                text = stringResource(R.string.footer_copyright),
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