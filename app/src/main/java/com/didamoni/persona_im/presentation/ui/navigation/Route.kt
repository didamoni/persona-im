package com.didamoni.persona_im.presentation.ui.navigation

import androidx.compose.runtime.Stable
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Stable
sealed interface Route : NavKey {

    @Serializable
    data object Auth : Route {
        @Serializable
        data object Login : Route
        @Serializable
        data object PhoneAuth : Route
    }

    @Serializable
    data object Register : Route

    @Serializable
    data object Loading : Route

    @Serializable
    data object Main : Route {
        @Serializable
        data object Home : Route
        @Serializable
        data object Profile : Route
        @Serializable
        data object Account : Route
        @Serializable
        data object Privacy : Route
        @Serializable
        data object Settings : Route
        @Serializable
        data object About : Route
        @Serializable
        data object NewChat : Route
        @Serializable
        data object NewGroup : Route
    }

    @Serializable
    data class Chat(val channelId: String) : Route {
        @Serializable
        data object Channel : Route
        @Serializable
        data object ChannelInfo : Route
        @Serializable
        data object FileAttachments : Route
        @Serializable
        data object MediaAttachments : Route
    }
}
