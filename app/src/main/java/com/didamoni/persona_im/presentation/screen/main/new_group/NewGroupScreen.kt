package com.didamoni.persona_im.presentation.screen.main.new_group

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
fun NewGroupScreen(
    viewModel: NewGroupViewModel,
    onCreateGroup: (channelId: String) -> Unit,
    onClickBack: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    NewGroupScreenContent(state, onCreateGroup, onClickBack)
}

@Composable
private fun NewGroupScreenContent(
    state: Unit, // use your screen's ViewState
    onCreateGroup: (channelId: String) -> Unit,
    onClickBack: () -> Unit
) = Column(
    modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        .padding(16.dp).imePadding(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceAround
) {
    Text(
        text = "NewGroupScreen",
        style = typography.headlineMedium,
        color = colorScheme.onBackground
    )
    Button(
        onClick = { onCreateGroup("new_group_id") },
    ) {
        Text("Create Group")
    }
    Button(
        onClick = onClickBack,
    ) {
        Text("Back")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun NewGroupScreenPreview() = PersonaIMTheme {
    Box(Modifier.background(colorScheme.background)) {
        NewGroupScreenContent(Unit, {}, {})
    }
}