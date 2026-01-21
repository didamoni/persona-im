package com.didamoni.persona_im.presentation.screen.chat

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.didamoni.persona_im.presentation.ui.navigation.Route.Chat

@Composable
fun ChatNavDisplay(
    channelId: String
) {
    val backStack = rememberNavBackStack(Chat.Channel)

    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Chat.Channel> {
                ChannelScreen(
                    channelId = channelId,
                    onClickChannelInfo = { backStack.add(Chat.ChannelInfo) }
                )
            }
            entry<Chat.ChannelInfo> {
                ChannelInfoScreen(
                    channelId = channelId,
                    onClickFileAttachments = { backStack.add(Chat.FileAttachments) },
                    onClickMediaAttachments = { backStack.add(Chat.MediaAttachments) },
                    onClickBack = { backStack.removeLastOrNull() }
                )
            }
            entry<Chat.FileAttachments> {
                FileAttachmentsScreen(
                    onClickBack = { backStack.removeLastOrNull() }
                )
            }
            entry<Chat.MediaAttachments> {
                MediaAttachmentsScreen(
                    onClickBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}