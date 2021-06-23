package br.com.iupp.core.port

import br.com.iupp.infraestrutura.model.Events
import br.com.iupp.infraestrutura.model.EventsInformationDto
import br.com.iupp.infraestrutura.model.ProductEvent
import javax.inject.Singleton

@Singleton
interface NatsServicePort {
    fun sendCreateNats(productEvent: ProductEvent):EventsInformationDto
    fun sendDeleteNats(productEvent: ProductEvent)
    fun sendUpdateNats(productEvent: ProductEvent)
}
