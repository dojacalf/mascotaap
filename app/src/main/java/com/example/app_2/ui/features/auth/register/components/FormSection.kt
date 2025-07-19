package com.example.app_2.ui.features.auth.register.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.app_2.R
import com.example.app_2.ui.features.auth.register.viewmodel.AuthState

@Composable
fun FormSection(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    authState: AuthState
) {
    AuthTextField(
        value = email,
        onValueChange = onEmailChange,
        hint = stringResource(R.string.hint_email),
        leadingIconRes = R.drawable.mail,
        modifier = Modifier.padding(vertical = 6.dp)
    )

    AuthTextField(
        value = password,
        onValueChange = onPasswordChange,
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
        onClick = onRegisterClick,
        enabled = authState != AuthState.Loading,
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
        if (authState == AuthState.Loading) {
            CircularProgressIndicator(modifier = Modifier.size(24.dp))
        } else {
            Text(stringResource(R.string.button_register),
                style = MaterialTheme.typography.labelLarge)
        }
    }
}