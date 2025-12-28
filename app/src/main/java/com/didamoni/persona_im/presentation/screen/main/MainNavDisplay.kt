package com.didamoni.persona_im.presentation.screen.main

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.didamoni.persona_im.presentation.ui.navigation.Route.Main

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
                    onClickChannel = onOpenChat,
                    onClickNewChat = { backStack.add(Main.NewChat) },
                    onClickNewGroup = { backStack.add(Main.NewGroup) },
                    onClickProfile = { backStack.add(Main.Profile) },
                    onClickSettings = { backStack.add(Main.Settings) },
                    onClickAbout = { backStack.add(Main.About) },
                    onLogout = onLogout
                )
            }
            entry<Main.NewChat> {
                NewChatScreen(
                    onCreateChat = { backStack.removeLast(); onOpenChat(it) },
                    onClickBack = { backStack.removeLast() }
                )
            }
            entry<Main.NewGroup> {
                NewGroupScreen(
                    onCreateGroup = { backStack.removeLast(); onOpenChat(it) },
                    onClickBack = { backStack.removeLast() }
                )
            }
            entry<Main.Profile> {
                ProfileScreen(
                    onClickBack = { backStack.removeLast() }
                )
            }
            entry<Main.Settings> {
                SettingsScreen(
                    onClickBack = { backStack.removeLast() }
                )
            }
            entry<Main.About> {
                AboutScreen(
                    onClickBack = { backStack.removeLast() }
                )
            }
        }
    )
}