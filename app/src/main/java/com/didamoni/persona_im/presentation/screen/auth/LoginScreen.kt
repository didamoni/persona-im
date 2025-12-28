package com.didamoni.persona_im.presentation.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.didamoni.persona_im.presentation.ui.theme.PersonaIMTheme

@Composable
fun LoginScreen(
    onLoginWithGoogle: () -> Unit,
    onClickLoginWithPhone: () -> Unit
) {
    var state by remember { mutableStateOf(Unit) }

    LoginScreenContent(state, onLoginWithGoogle, onClickLoginWithPhone)
}

@Composable
private fun LoginScreenContent(
    state: Unit, // use your screen's ViewState
    onClickLoginWithGoogle: () -> Unit,
    onClickLoginWithPhone: () -> Unit
) = Column(
    modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        .padding(16.dp).imePadding(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceAround
) {
    Text(
        text = "LoginScreen",
        style = typography.headlineMedium,
        color = colorScheme.onBackground
    )
    Button(
        onClick = onClickLoginWithGoogle,
    ) {
        Text("Login with Google")
    }
    Button(
        onClick = onClickLoginWithPhone,
    ) {
        Text("Login with Phone")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPreview() = PersonaIMTheme {
    Box(Modifier.background(colorScheme.background)) {
        LoginScreenContent(Unit, {}, {})
    }
}