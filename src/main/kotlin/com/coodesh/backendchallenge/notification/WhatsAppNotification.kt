package com.coodesh.backendchallenge.notification

import com.coodesh.backendchallenge.core.circuitbreaker.CircuitBreakerConfig
import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class WhatsAppNotification : Notification {

    private val logger: Logger = LoggerFactory.getLogger(WhatsAppNotification::class.java)

    val ACCOUNT_SID = "XXXXXXXXXXXXXx"
    val AUTH_TOKEN = "XXXXXXXXXXXXXXx"

    override fun sendMessage(from: String, to: String, body: String) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN)
        val message = Message.creator(
            PhoneNumber("whatsapp:$to"),
            PhoneNumber("whatsapp:$from"),
            body
        ).create()

        logger.info("Generating id ${message.sid}")
        logger.info("Send message to WhatsApp")
    }
}