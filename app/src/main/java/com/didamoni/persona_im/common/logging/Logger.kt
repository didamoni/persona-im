package com.didamoni.persona_im.common.logging

/**
 * Core logging interface that provides methods for different log severity levels.
 * This interface uses higher-order functions for the message parameters to support lazy evaluation.
 */
interface Logger {
    /**
     * Log a message with Verbose severity. This is the lowest severity level.
     *
     * @param throwable Optional throwable to log.
     * @param tag Tag to associate with the log message. Defaults to this logger's tag.
     * @param message Lambda returning the message to log.
     */
    fun v(throwable: Throwable? = null, tag: String? = null, message: () -> String)

    /**
     * Log a message with Debug severity. This is above 'Verbose'.
     *
     * @param throwable Optional throwable to log.
     * @param tag Tag to associate with the log message. Defaults to this logger's tag.
     * @param message Lambda returning the message to log.
     */
    fun d(throwable: Throwable? = null, tag: String? = null, message: () -> String)

    /**
     * Log a message with Info severity. This is above 'Debug'.
     *
     * @param throwable Optional throwable to log.
     * @param tag Tag to associate with the log message. Defaults to this logger's tag.
     * @param message Lambda returning the message to log.
     */
    fun i(throwable: Throwable? = null, tag: String? = null, message: () -> String)

    /**
     * Log a message with Warn severity. This is above 'Info'.
     *
     * @param throwable Optional throwable to log.
     * @param tag Tag to associate with the log message. Defaults to this logger's tag.
     * @param message Lambda returning the message to log.
     */
    fun w(throwable: Throwable? = null, tag: String? = null, message: () -> String)

    /**
     * Log a message with Error severity. This is above 'Warn'.
     *
     * @param throwable Optional throwable to log.
     * @param tag Tag to associate with the log message. Defaults to this logger's tag.
     * @param message Lambda returning the message to log.
     */
    fun e(throwable: Throwable? = null, tag: String? = null, message: () -> String)

    /**
     * Log a message with Assert severity. This is the highest severity level.
     *
     * @param throwable Optional throwable to log.
     * @param tag Tag to associate with the log message. Defaults to this logger's tag.
     * @param message Lambda returning the message to log.
     */
    fun a(throwable: Throwable? = null, tag: String? = null, message: () -> String)
}