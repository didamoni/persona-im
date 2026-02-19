package com.didamoni.persona_im

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.annotation.KoinApplication
import org.koin.plugin.module.dsl.startKoin

@KoinApplication
class PersonaIMApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin<PersonaIMApp> {
            androidContext(this@PersonaIMApp)
            androidLogger()
        }
    }
}