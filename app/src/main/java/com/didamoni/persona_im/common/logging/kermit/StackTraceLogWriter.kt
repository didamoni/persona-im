package com.didamoni.persona_im.common.logging.kermit

import co.touchlab.kermit.BaseLogger
import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.LogcatWriter
import co.touchlab.kermit.Severity
import kotlin.reflect.KClass

/**
 * A [LogWriter] that automatically generates tags based on the call stack.
 *
 * This writer decorates a [delegate] writer (defaulting to [LogcatWriter]) by injecting
 * caller information such as the class name and method name into the log.
 *
 * @param callerIgnoreList A list of [KClass]es to skip when searching the stack trace for the caller.
 * Use this to ignore base classes or utility wrappers.
 * @param formatter The strategy used to format the tag and message strings.
 * @param delegate The actual writer that will perform the final log output.
 */
class StackTraceLogWriter(
    callerIgnoreList: List<KClass<*>> = emptyList(),
    private val minSeverity: Severity = Severity.Verbose,
    private val formatter: StackTraceLogFormatter = HashtagStackTraceFormatter,
    private val delegate: LogWriter = LogcatWriter()
) : LogWriter() {

    private val callerIgnoreList = callerIgnoreList.map { it.java.name }

    override fun isLoggable(tag: String, severity: Severity): Boolean = severity >= minSeverity

    override fun log(severity: Severity, message: String, tag: String, throwable: Throwable?) {
        val element = getCallerElement()

        val formattedTag = formatter.formatTag(tag, element)
        val formattedMessage = formatter.formatMessage(message, element)

        delegate.log(severity, formattedMessage, formattedTag, throwable)
    }

    /**
     * Walks the current thread's stack trace to find the first element that is not
     * part of the internal logging infrastructure or the [callerIgnoreList].
     */
    private fun getCallerElement(): StackTraceElement? {
        val stackTrace = Throwable().stackTrace
        return stackTrace.firstOrNull { it.className !in ignoreList + callerIgnoreList }
    }

    companion object {
        /**
         * Internal classes that should always be ignored to ensure the tag reflects the user code.
         */
        private val ignoreList = listOf(
            BaseLogger::class.java.name,
            StackTraceLogWriter::class.java.name
        )
    }
}