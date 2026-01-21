package com.didamoni.persona_im.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.didamoni.persona_im.presentation.ui.navigation.PersonaIMNavDisplay
import com.didamoni.persona_im.presentation.ui.navigation.Route
import com.didamoni.persona_im.presentation.ui.theme.PersonaIMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PersonaIMTheme {
                Scaffold { innerPadding ->
                    PersonaIMNavDisplay(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        startDestination = Route.Auth
                    )
                }
            }
        }
    }
}