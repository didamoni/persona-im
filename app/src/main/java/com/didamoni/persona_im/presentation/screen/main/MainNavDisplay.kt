package com.didamoni.persona_im.presentation.screen.main

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.didamoni.persona_im.presentation.screen.main.about.AboutScreen
import com.didamoni.persona_im.presentation.screen.main.account.AccountScreen
import com.didamoni.persona_im.presentation.screen.main.account.AccountViewModel
import com.didamoni.persona_im.presentation.screen.main.home.HomeScreen
import com.didamoni.persona_im.presentation.screen.main.home.HomeViewModel
import com.didamoni.persona_im.presentation.screen.main.new_chat.NewChatScreen
import com.didamoni.persona_im.presentation.screen.main.new_chat.NewChatViewModel
import com.didamoni.persona_im.presentation.screen.main.new_group.NewGroupScreen
import com.didamoni.persona_im.presentation.screen.main.new_group.NewGroupViewModel
import com.didamoni.persona_im.presentation.screen.main.privacy.PrivacyScreen
import com.didamoni.persona_im.presentation.screen.main.privacy.PrivacyViewModel
import com.didamoni.persona_im.presentation.screen.main.profile.ProfileScreen
import com.didamoni.persona_im.presentation.screen.main.profile.ProfileViewModel
import com.didamoni.persona_im.presentation.screen.main.settings.SettingsScreen
import com.didamoni.persona_im.presentation.screen.main.settings.SettingsViewModel
import com.didamoni.persona_im.presentation.ui.navigation.Route.Main
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainNavDisplay(
    onOpenChat: (channelId: String) -> Unit,
    onLogout: () -> Unit
) {
    val backStack = rememberNavBackStack(Main.Home)

    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Main.Home> {
                HomeScreen(
                    viewModel = koinViewModel<HomeViewModel>(),
                    onClickChannel = onOpenChat,
                    onClickNewChat = { backStack.add(Main.NewChat) },
                    onClickNewGroup = { backStack.add(Main.NewGroup) },
                    onClickProfile = { backStack.add(Main.Profile) },
                    onClickAccount = { backStack.add(Main.Account) },
                    onClickPrivacy = { backStack.add(Main.Privacy) },
                    onClickSettings = { backStack.add(Main.Settings) },
                    onClickAbout = { backStack.add(Main.About) },
                    onLogout = onLogout
                )
            }
            entry<Main.NewChat> {
                NewChatScreen(
                    viewModel = koinViewModel<NewChatViewModel>(),
                    onCreateChat = { backStack.removeLastOrNull(); onOpenChat(it) },
                    onClickBack = { backStack.removeLastOrNull() }
                )
            }
            entry<Main.NewGroup> {
                NewGroupScreen(
                    viewModel = koinViewModel<NewGroupViewModel>(),
                    onCreateGroup = { backStack.removeLastOrNull(); onOpenChat(it) },
                    onClickBack = { backStack.removeLastOrNull() }
                )
            }
            entry<Main.Profile> {
                ProfileScreen(
                    viewModel = koinViewModel<ProfileViewModel>(),
                    onClickBack = { backStack.removeLastOrNull() }
                )
            }
            entry<Main.Account> {
                AccountScreen(
                    viewModel = koinViewModel<AccountViewModel>(),
                    onClickBack = { backStack.removeLastOrNull() }
                )
            }
            entry<Main.Privacy> {
                PrivacyScreen(
                    viewModel = koinViewModel<PrivacyViewModel>(),
                    onClickBack = { backStack.removeLastOrNull() }
                )
            }
            entry<Main.Settings> {
                SettingsScreen(
                    viewModel = koinViewModel<SettingsViewModel>(),
                    onClickBack = { backStack.removeLastOrNull() }
                )
            }
            entry<Main.About> {
                AboutScreen(
                    onClickBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}