package com.didamoni.persona_im

import android.app.Application
import com.didamoni.persona_im.common.logging.Log
import com.didamoni.persona_im.common.logging.kermit.KermitLogger
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.annotation.KoinApplication
import org.koin.core.logger.Level
import org.koin.plugin.module.dsl.startKoin

@KoinApplication
class PersonaIMApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Log.setLogger(KermitLogger)

        startKoin<PersonaIMApp> {
            androidContext(this@PersonaIMApp)

            @Suppress("KotlinConstantConditions")
            if (BuildConfig.DEBUG) androidLogger(Level.DEBUG)
        }
    }
}