package com.didamoni.persona_im.common.logging

object Log : Logger {
    @Volatile
    private var logger: Logger = ConsoleLogger

    fun setLogger(logger: Logger) {
        Log.logger = logger
    }

    override fun v(throwable: Throwable?, tag: String?, message: () -> String) =
        logger.v(throwable, tag, message)
    override fun d(throwable: Throwable?, tag: String?, message: () -> String) =
        logger.d(throwable, tag, message)
    override fun i(throwable: Throwable?, tag: String?, message: () -> String) =
        logger.i(throwable, tag, message)
    override fun w(throwable: Throwable?, tag: String?, message: () -> String) =
        logger.w(throwable, tag, message)
    override fun e(throwable: Throwable?, tag: String?, message: () -> String) =
        logger.e(throwable, tag, message)
    override fun a(throwable: Throwable?, tag: String?, message: () -> String) =
        logger.a(throwable, tag, message)

    /**
     * A lightweight, dependency-free logger that outputs to standard console.
     *
     * Output example: `🔵 D/Network: Fetched user data`
     */
    object ConsoleLogger : Logger {

        override fun v(throwable: Throwable?, tag: String?, message: () -> String) =
            printLog("⚪", "V", tag, throwable, message)

        override fun d(throwable: Throwable?, tag: String?, message: () -> String) =
            printLog("🔵", "D", tag, throwable, message)

        override fun i(throwable: Throwable?, tag: String?, message: () -> String) =
            printLog("🟢", "I", tag, throwable, message)

        override fun w(throwable: Throwable?, tag: String?, message: () -> String) =
            printLog("🟠", "W", tag, throwable, message)

        override fun e(throwable: Throwable?, tag: String?, message: () -> String) =
            printLog("🔴", "E", tag, throwable, message)

        override fun a(throwable: Throwable?, tag: String?, message: () -> String) =
            printLog("🟣", "A", tag, throwable, message)


        private fun printLog(
            icon: String,
            severityChar: String,
            tag: String?,
            throwable: Throwable?,
            message: () -> String
        ) {
            val finalTag = if (tag.isNullOrEmpty()) "Log" else tag

            println("$icon $severityChar/$finalTag: ${message()}")
            throwable?.printStackTrace()
        }
    }
}


