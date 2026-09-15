package com.didamoni.persona_im.core.common.coroutines

import org.koin.core.annotation.Qualifier

/**
 * Qualifier annotation to specify which CoroutineDispatcher to inject.
 * Example: @Dispatcher.Default, @Dispatcher.IO
 */
annotation class Dispatcher {

    @Qualifier
    annotation class Default

    @Qualifier
    annotation class IO
}

/**
 * Qualifier annotation for the application-wide process-lifecycle CoroutineScope.
 */
@Qualifier
annotation class ApplicationScope