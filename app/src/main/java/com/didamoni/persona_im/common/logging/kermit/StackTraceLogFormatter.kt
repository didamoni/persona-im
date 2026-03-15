package com.didamoni.persona_im.common.logging.kermit

/**
 * Defines how stack trace information should be converted into displayable strings.
 */
interface StackTraceLogFormatter {
    fun formatTag(tag: String, element: StackTraceElement?): String
    fun formatMessage(message: String, element: StackTraceElement?): String
}

/**
 * A stack-trace aware formatter that dynamically resolves the caller's class name to use as
 * a tag (if not provided) with a `#` prefix for high visibility in Log, and prepends the name of
 * the calling function to the message.
 *
 * Output Example:
 *
 * Tag: `#MainActivity` Message: `onCreate(): Activity created`
 */
object HashtagStackTraceFormatter : StackTraceLogFormatter {

    override fun formatTag(tag: String, element: StackTraceElement?): String {
        // Use explicitly provided tag if available, otherwise resolve from stack element
        val rawTag = when {
            tag.isNotEmpty() -> tag
            element != null -> {
                val className = element.className.substringAfterLast('.')
                ANONYMOUS_CLASS_REGEX.replace(className, "")
            }
            else -> "Kermit"
        }

        return "#$rawTag"
    }

    override fun formatMessage(message: String, element: StackTraceElement?): String {
        if (element == null) return message

        // Strip out $lambda or synthetic suffixes from the method name
        val cleanMethodName = element.methodName.substringBefore('$')
        return "$cleanMethodName(): $message"
    }

    private val ANONYMOUS_CLASS_REGEX = Regex("(\\$\\d+)+$")
}