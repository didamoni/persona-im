package com.didamoni.persona_im.presentation.screen.main

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
import androidx.compose.material3.OutlinedButton
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
fun HomeScreen(
    onClickChannel: (channelId: String) -> Unit,
    onClickNewChat: () -> Unit,
    onClickNewGroup: () -> Unit,
    onClickProfile: () -> Unit,
    onClickAccount: () -> Unit,
    onClickPrivacy: () -> Unit,
    onClickSettings: () -> Unit,
    onClickAbout: () -> Unit,
    onLogout: () -> Unit
) {
    var state by remember { mutableStateOf(Unit) }

    HomeScreenContent(
        state,
        onClickChannel, onClickNewChat, onClickNewGroup,
        onClickProfile, onClickAccount, onClickPrivacy,
        onClickSettings, onClickAbout, onLogout
    )
}

@Composable
private fun HomeScreenContent(
    state: Unit, // use your screen's ViewState
    onClickChannel: (channelId: String) -> Unit,
    onClickNewChat: () -> Unit,
    onClickNewGroup: () -> Unit,
    onClickProfile: () -> Unit,
    onClickAccount: () -> Unit,
    onClickPrivacy: () -> Unit,
    onClickSettings: () -> Unit,
    onClickAbout: () -> Unit,
    onClickLogout: () -> Unit
) = Column(
    modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        .padding(16.dp).imePadding(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceAround
) {
    Text(
        text = "HomeScreen",
        style = typography.headlineMedium,
        color = colorScheme.onBackground
    )
    Button(
        onClick = onClickNewChat,
    ) {
        Text("New Chat")
    }
    Button(
        onClick = onClickNewGroup,
    ) {
        Text("New Group")
    }
    Button(
        onClick = onClickProfile,
    ) {
        Text("Profile")
    }
    Button(
        onClick = onClickAccount,
    ) {
        Text("Account")
    }
    Button(
        onClick = onClickPrivacy,
    ) {
        Text("Privacy")
    }
    Button(
        onClick = onClickSettings,
    ) {
        Text("Settings")
    }
    repeat(5) {
        OutlinedButton(
            onClick = { onClickChannel("channel_$it") },

        ) {
            Text("Channel $it")
        }
    }
    Button(
        onClick = onClickAbout,
    ) {
        Text("About")
    }
    Button(
        onClick = onClickLogout,
    ) {
        Text("Logout")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() = PersonaIMTheme {
    Box(Modifier.background(colorScheme.background)) {
        HomeScreenContent(Unit, {}, {}, {}, {}, {}, {}, {}, {}, {})
    }
}