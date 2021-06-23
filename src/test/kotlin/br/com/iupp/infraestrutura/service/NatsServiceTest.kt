package br.com.iupp.infraestrutura.service

import br.com.iupp.infraestrutura.client.ProductClient
import br.com.iupp.infraestrutura.model.Events
import br.com.iupp.infraestrutura.model.EventsInformationDto
import br.com.iupp.infraestrutura.model.ProductEvent
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.util.*

@MicronautTest
class NatsServiceTest : AnnotationSpec(){

    val service = mockk<ProductClient>()
    val produtoService = NatsService(service)

    @Test
    fun `deve enviar um nats de SAVE_PRODUCT`() {

        val productEvent = ProductEvent("", "produto 1", "descricao 1", BigDecimal.ZERO, "teste@teste.com")
        val event = Events.SAVE_PRODUCT
        val eventsInformation = EventsInformationDto(event, productEvent)

        every { produtoService.sendCreateNats(productEvent) } answers {eventsInformation}

        val result = service.sendProduto(eventsInformation)
        result shouldBe Unit

    }

    @Test
    fun `deve enviar um nats de UPDATE_PRODUCT`() {

        val event = Events.UPDATE_PRODUCT
        val productEvent = ProductEvent(UUID.randomUUID().toString(), "produto 1", "descricao 1", BigDecimal.ZERO, "teste@teste.com")
        val eventsInformation = EventsInformationDto(event, productEvent)

        every { produtoService.sendUpdateNats(productEvent) } answers { }

        val result = service.sendProduto(eventsInformation)
        result shouldBe Unit
    }

    @Test
    fun `deve enviar um nats de DELETE_PRODUCT`() {

        val event = Events.DELETE_PRODUCT
        val productEvent = ProductEvent(id = UUID.randomUUID().toString())
        val eventsInformation = EventsInformationDto(event, productEvent)

        every { produtoService.sendDeleteNats(productEvent) } answers {}

        val result = service.sendProduto(eventsInformation)
        result shouldBe Unit

    }


}
