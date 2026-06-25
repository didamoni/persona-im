@file:Suppress("unused")

package com.didamoni.persona_im.common.result

/**
 * A wrapper representing the outcome of an operation that resulted in either a [Success] containing data [D],
 * or a [Failure] containing an error [E].
 */
sealed interface Result<out D, out E : Error> {
    data class Success<out D>(val data: D) : Result<D, Nothing>
    data class Failure<out E : Error>(val error: E) : Result<Nothing, E>
}

/**
 * Transforms the successful data [D] into a new type [R] using [transform].
 * If the result is [Result.Failure], it is returned unmodified.
 */
inline fun <D, E : Error, R> Result<D, E>.map(
    transform: (D) -> R
): Result<R, E> {
    return when (this) {
        is Result.Success -> Result.Success(transform(data))
        is Result.Failure -> this
    }
}

/**
 * Transforms the successful data [D] into a new [Result] of type [R] using [transform].
 * If the result is [Result.Failure], it is returned unmodified.
 */
inline fun <D, E : Error, R> Result<D, E>.flatMap(
    transform: (D) -> Result<R, E>
): Result<R, E> {
    return when (this) {
        is Result.Success -> transform(data)
        is Result.Failure -> this
    }
}

/**
 * Executes the [action] block if the result is [Result.Success].
 * Always returns the original [Result] instance to support fluent chaining.
 */
inline fun <D, E : Error> Result<D, E>.onSuccess(
    action: (D) -> Unit
): Result<D, E> {
    if (this is Result.Success) {
        action(data)
    }
    return this
}

/**
 * Executes the [action] block if the result is [Result.Failure].
 * Always returns the original [Result] instance to support fluent chaining.
 */
inline fun <D, E : Error> Result<D, E>.onFailure(
    action: (E) -> Unit
): Result<D, E> {
    if (this is Result.Failure) {
        action(error)
    }
    return this
}

/**
 * Safely extracts the data [D] if successful, or executes [fallback] to
 * supply a default value of [D] if a failure occurred.
 */
inline fun <D, E : Error> Result<D, E>.getOrElse(
    fallback: (E) -> D
): D {
    return when (this) {
        is Result.Success -> data
        is Result.Failure -> fallback(error)
    }
}