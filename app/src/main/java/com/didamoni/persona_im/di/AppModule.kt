package com.didamoni.persona_im.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.Module

@Module
@Configuration
@ComponentScan("com.didamoni.persona_im")
@Suppress("unused") // Used by the Koin compiler plugin
class AppModule
