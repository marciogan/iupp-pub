package br.com.iupp.core.service

import br.com.iupp.core.model.Produto
import br.com.iupp.core.port.NatsServicePort
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
class ProductServiceTest : AnnotationSpec(){

/*

    val service = mockk<NatsServicePort>()
    val produtoService = ProductService(service)

    @Test
    fun `deve enviar CREATE message`(){
        val produto = Produto(UUID.randomUUID().toString(), "Produto 1", "Descrição produto 1", BigDecimal.ZERO, "teste@teste.com")
        val produtoEvent = ProductEvent(UUID.randomUUID().toString(), "Produto 1", "Descrição produto 1", BigDecimal.ZERO, "teste@teste.com")

        val eventsInformationDto = EventsInformationDto(Events.SAVE_PRODUCT, produtoEvent)
        every { produtoService.sendCreateMessage(produto)} returns produtoEvent

        val result = service.sendCreateNats(produtoEvent)

        result shouldBe eventsInformationDto
    }

*/

}
