package com.coodesh.backendchallenge.core.jackson

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.springframework.boot.jackson.JsonComponent
import org.springframework.data.domain.Page

@JsonComponent
class PageJsonSerializer : JsonSerializer<Page<Any>>() {

    override fun serialize(value: Page<Any>?,
                           gen: JsonGenerator?,
                           serializers: SerializerProvider?) {
        gen?.writeStartObject()
        gen?.writeObjectField("content", value?.content)
        gen?.writeNumberField("size", value?.size ?: 0)
        gen?.writeNumberField("totalElements", value?.totalElements ?: 0)
        gen?.writeNumberField("totalPages", value?.totalPages ?: 0)
        gen?.writeNumberField("number", value?.number ?: 0)
        gen?.writeEndObject()
    }
}