package com.didamoni.persona_im.presentation.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class RegisterViewModel : ViewModel() {

    private val _state = MutableStateFlow(Unit)
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