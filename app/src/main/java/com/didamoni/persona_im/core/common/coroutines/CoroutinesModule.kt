package com.didamoni.persona_im.core.common.coroutines

import com.didamoni.persona_im.core.common.logging.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@Configuration
class CoroutinesModule {

    @Single
    @Dispatcher.IO
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Single
    @Dispatcher.Default
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Single
    @ApplicationScope
    fun provideApplicationScope(
        @Dispatcher.Default defaultDispatcher: CoroutineDispatcher
    ): CoroutineScope = CoroutineScope(
        SupervisorJob() + defaultDispatcher + CoroutineExceptionHandler { _, throwable ->
            Log.e(throwable) { "Uncaught exception in ApplicationScope coroutine" }
        }
    )
}