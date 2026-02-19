package com.didamoni.persona_im.presentation.screen.auth

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.didamoni.persona_im.presentation.ui.navigation.Route.Auth
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthNavDisplay(
    onLogin: () -> Unit,
    onSignup: () -> Unit,
) {
    val backStack = rememberNavBackStack(Auth.Login)
    val viewModel = koinViewModel<AuthViewModel>()

    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Auth.Login> {
                LoginScreen(
                    viewModel = viewModel,
                    onLoginWithGoogle = onLogin,
                    onClickLoginWithPhone = { backStack.add(Auth.PhoneAuth) }
                )
            }
            entry<Auth.PhoneAuth> {
                PhoneAuthScreen(
                    viewModel = viewModel,
                    onLoginWithPhone = onSignup,
                    onClickBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}