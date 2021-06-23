package br.com.iupp.infraestrutura.service

import br.com.iupp.core.port.NatsServicePort
import br.com.iupp.infraestrutura.client.ProductClient
import br.com.iupp.infraestrutura.model.Events
import br.com.iupp.infraestrutura.model.EventsInformationDto
import br.com.iupp.infraestrutura.model.ProductEvent
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class NatsService(private val client: ProductClient) : NatsServicePort {

    private val LOGGER = LoggerFactory.getLogger(this::class.java)

    override fun sendCreateNats(productEvent: ProductEvent) : EventsInformationDto{
        val eventsInfo =  EventsInformationDto(Events.SAVE_PRODUCT, productEvent)
        client.sendProduto(eventsInfo)
        LOGGER.info("CREATE message sent successfully")
        LOGGER.info("$eventsInfo")
        return eventsInfo
    }

    override fun sendDeleteNats(productEvent: ProductEvent) {
        client.sendProduto((EventsInformationDto(Events.DELETE_PRODUCT, productEvent)))
        LOGGER.info("DELETE message sent successfully")
    }

    override fun sendUpdateNats(productEvent: ProductEvent) {
        client.sendProduto((EventsInformationDto(Events.UPDATE_PRODUCT, productEvent)))
        LOGGER.info("UPDATE message sent successfully")
    }

}