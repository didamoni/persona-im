package com.didamoni.persona_im.common.logging.kermit

import co.touchlab.kermit.ExperimentalKermitApi
import co.touchlab.kermit.Severity
import co.touchlab.kermit.crashlytics.CrashlyticsLogWriter
import com.didamoni.persona_im.BuildConfig
import com.didamoni.persona_im.common.logging.Log
import com.didamoni.persona_im.common.logging.Logger
import co.touchlab.kermit.Logger as TouchLabLogger

@OptIn(ExperimentalKermitApi::class)
object KermitLogger : Logger {

    init {
        TouchLabLogger.apply {
            if (BuildConfig.DEBUG) {
                val callerIgnoreList = listOf(Logger::class, Log::class, KermitLogger::class)
                val debugWriter = StackTraceLogWriter(callerIgnoreList)

                setLogWriters(debugWriter)
                setMinSeverity(Severity.Verbose)
            } else {
                val releaseWriter = CrashlyticsLogWriter()

                setLogWriters(releaseWriter)
                setMinSeverity(Severity.Warn)
            }
        }
    }

    override fun v(throwable: Throwable?, tag: String?, message: () -> String) =
        TouchLabLogger.v(throwable, tag ?: TouchLabLogger.tag, message)

    override fun d(throwable: Throwable?, tag: String?, message: () -> String) =
        TouchLabLogger.d(throwable, tag ?: TouchLabLogger.tag, message)

    override fun i(throwable: Throwable?, tag: String?, message: () -> String) =
        TouchLabLogger.i(throwable, tag ?: TouchLabLogger.tag, message)

    override fun w(throwable: Throwable?, tag: String?, message: () -> String) =
        TouchLabLogger.w(throwable, tag ?: TouchLabLogger.tag, message)

    override fun e(throwable: Throwable?, tag: String?, message: () -> String) =
        TouchLabLogger.e(throwable, tag ?: TouchLabLogger.tag, message)

    override fun a(throwable: Throwable?, tag: String?, message: () -> String) =
        TouchLabLogger.a(throwable, tag ?: TouchLabLogger.tag, message)
}
