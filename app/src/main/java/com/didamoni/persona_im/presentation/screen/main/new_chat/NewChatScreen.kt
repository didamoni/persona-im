package com.didamoni.persona_im.presentation.screen.main.new_chat

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.didamoni.persona_im.presentation.ui.theme.PersonaIMTheme

@Composable
fun NewChatScreen(
    viewModel: NewChatViewModel,
    onCreateChat: (channelId: String) -> Unit,
    onClickBack: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    NewChatScreenContent(state, onCreateChat, onClickBack)
}

@Composable
private fun NewChatScreenContent(
    state: Unit, // use your screen's ViewState
    onCreateChat: (channelId: String) -> Unit,
    onClickBack: () -> Unit
) = Column(
    modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        .padding(16.dp).imePadding(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceAround
) {
    Text(
        text = "NewChatScreen",
        style = typography.headlineMedium,
        color = colorScheme.onBackground
    )
    Button(
        onClick = { onCreateChat("new_channel_id") },
    ) {
        Text("Create Chat")
    }
    Button(
        onClick = onClickBack,
    ) {
        Text("Back")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun NewChatScreenPreview() = PersonaIMTheme {
    Box(Modifier.background(colorScheme.background)) {
        NewChatScreenContent(Unit, {}, {})
    }
}