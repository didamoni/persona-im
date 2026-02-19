package com.didamoni.persona_im.presentation.screen.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.annotation.InjectedParam
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class ChatViewModel(
    @InjectedParam val channelId: String
) : ViewModel() {

    private val _state = MutableStateFlow(channelId)
    val state = _state.asStateFlow()

    /*
    private val _event = Channel<Unit>()
    val event = _event.receiveAsFlow()
    */

    init {
        viewModelScope.launch { }
    }

    /*
	fun processIntent(intent: Unit) {
		when (intent) {
			Unit -> doSomething()
		}
	}

	private fun doSomething() = viewModelScope.launch {  }
    */
}