package br.com.iupp.infraestrutura.model

import io.micronaut.core.annotation.Introspected

@Introspected
data class EventsInformationDto(
    val events: Events,
    val productEvent: ProductEvent
)

