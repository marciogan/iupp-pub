package br.com.iupp.entrypoint.controler

import br.com.iupp.core.model.Produto
import br.com.iupp.entrypoint.controller.ProdutoController
import br.com.iupp.entrypoint.dto.ProdutoRequest
import br.com.iupp.infraestrutura.model.Events
import br.com.iupp.infraestrutura.model.ProductEvent
import br.com.iupp.core.port.NatsServicePort
import br.com.iupp.core.port.ProductServicePort
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpResponse
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.util.*

@MicronautTest
class ProdutoControllerTest : AnnotationSpec() {

    val service = mockk<ProductServicePort>(relaxed = true)
    val produtoController = ProdutoController(service)

    companion object{
        val produtoRequest = ProdutoRequest("", "32", "rewr", BigDecimal.ZERO, "teste@teste.com")
        val productEvent = ProductEvent(UUID.randomUUID().toString(), "Produto 1", "Descrição produto 1", BigDecimal.ZERO, "teste@teste.com")
        val product = Produto(UUID.randomUUID().toString(), "Produto 1", "Descrição produto 1", BigDecimal.ZERO, "teste@teste.com")
        val id = UUID.randomUUID()
    }

    @Test
    internal fun `deve receber um POST e enviar um nats`() {

        every { produtoController.ProdutoParaNats(produtoRequest) } returns HttpResponse.accepted()
        val result = service.sendCreateMessage(product)

        result shouldBe Unit
    }

    @Test
    internal fun `deve receber um DELETE e enviar um nats`() {

        every { produtoController.DeletaProdutoParaNats(id) } returns HttpResponse.accepted()
        val result = service.sendDeleteMessage(product)

        result shouldBe Unit
    }

    @Test
    internal fun `deve receber um UPDATE e enviar um nats`() {

        every { produtoController.UpdateProdutoParaNats(produtoRequest) } returns HttpResponse.accepted()
        val result = service.sendUpdateMessage(product)

        result shouldBe Unit
    }
}
