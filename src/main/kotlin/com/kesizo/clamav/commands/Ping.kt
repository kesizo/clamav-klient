package com.kesizo.clamav.commands

import com.kesizo.clamav.InvalidResponseException

internal object Ping : Command<Unit>() {
    override val commandString
        get() = "PING"

    override val format
        get() = CommandFormat.NULL_CHAR

    override fun parseResponse(responseString: String) {
        if (responseString != "PONG") {
            throw InvalidResponseException(responseString)
        }
        logger.debug { responseString }
    }
}
