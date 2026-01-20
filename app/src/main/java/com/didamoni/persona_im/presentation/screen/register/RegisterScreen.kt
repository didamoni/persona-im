package com.didamoni.persona_im.presentation.screen.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun RegisterScreen() {
    var state by remember { mutableStateOf(Unit) }
    RegisterScreenContent(state)
}

@Composable
private fun RegisterScreenContent(
    state: Unit // use your screen's ViewState
) = Column(
    modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        .padding(16.dp).imePadding(),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(
        text = "RegisterScreen",
        style = typography.headlineMedium,
        color = colorScheme.onBackground
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RegisterScreenPreview() = PersonaIMTheme {
    Box(Modifier.background(colorScheme.background)) {
        RegisterScreenContent(Unit)
    }
}