package com.didamoni.persona_im.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.didamoni.persona_im.presentation.MainViewModel
import com.didamoni.persona_im.presentation.screen.auth.AuthNavDisplay
import com.didamoni.persona_im.presentation.screen.chat.ChatNavDisplay
import com.didamoni.persona_im.presentation.screen.loading.LoadingScreen
import com.didamoni.persona_im.presentation.screen.main.MainNavDisplay
import com.didamoni.persona_im.presentation.screen.register.RegisterScreen
import com.didamoni.persona_im.presentation.screen.register.RegisterViewModel
import org.koin.compose.viewmodel.koinActivityViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PersonaIMNavDisplay(
    startDestination: Route,
    modifier: Modifier = Modifier
) {
    val rootBackStack = rememberNavBackStack(startDestination)

    NavDisplay(
        modifier = modifier,
        backStack = rootBackStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Route.Auth> {
                AuthNavDisplay(
                    onLogin = { rootBackStack.clear(); rootBackStack.add(Route.Loading) },
                    onSignup = { rootBackStack.clear(); rootBackStack.add(Route.Register) }
                )
            }
            entry<Route.Register> {
                RegisterScreen(
                    viewModel = koinViewModel<RegisterViewModel>(),
                    onRegister = { rootBackStack.clear(); rootBackStack.add(Route.Main) },
                    onLogout = { rootBackStack.clear(); rootBackStack.add(Route.Auth) }
                )
            }
            entry<Route.Loading> {
                LoadingScreen(
                    viewModel = koinActivityViewModel<MainViewModel>(),
                    onConnect = { rootBackStack.clear(); rootBackStack.add(Route.Main) }
                )
            }
            entry<Route.Main> {
                MainNavDisplay(
                    onOpenChat = { rootBackStack.add(Route.Chat(it)) },
                    onLogout = { rootBackStack.clear(); rootBackStack.add(Route.Auth) }
                )
            }
            entry<Route.Chat> { chat ->
                ChatNavDisplay(chat.channelId)
            }
        }
    )
}


