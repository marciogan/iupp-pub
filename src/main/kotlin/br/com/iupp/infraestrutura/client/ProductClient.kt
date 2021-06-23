package br.com.iupp.infraestrutura.client

import br.com.iupp.infraestrutura.model.EventsInformationDto
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface ProductClient {

    @Subject("platform.produto.cadastro")
    fun sendProduto(eventsInformation: EventsInformationDto)

}

