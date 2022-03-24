package com.coodesh.backendchallenge.core.circuitbreaker


import io.github.resilience4j.circuitbreaker.CircuitBreaker
import io.github.resilience4j.core.registry.EntryAddedEvent
import io.github.resilience4j.core.registry.EntryRemovedEvent
import io.github.resilience4j.core.registry.EntryReplacedEvent
import io.github.resilience4j.core.registry.RegistryEventConsumer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Configuration
class CircuitBreakerConfig {

    @Bean
    fun circuitBreakerLogger(): RegistryEventConsumer<CircuitBreaker>{
        return RegistryEventConsumerLogger()
    }
}
@Component
class RegistryEventConsumerLogger: RegistryEventConsumer<CircuitBreaker>{

    private val logger: Logger = LoggerFactory.getLogger(RegistryEventConsumerLogger::class.java)

    override fun onEntryAddedEvent(entryAddedEvent: EntryAddedEvent<CircuitBreaker>) {

        entryAddedEvent.addedEntry.eventPublisher.onStateTransition{  logger.info(it.toString()) }
    }

    override fun onEntryRemovedEvent(entryRemoveEvent: EntryRemovedEvent<CircuitBreaker>) {
        TODO("Not yet implemented")
    }

    override fun onEntryReplacedEvent(entryReplacedEvent: EntryReplacedEvent<CircuitBreaker>) {
        TODO("Not yet implemented")
    }
}