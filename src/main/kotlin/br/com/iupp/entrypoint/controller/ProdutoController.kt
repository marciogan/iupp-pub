package br.com.iupp.entrypoint.controller

import br.com.iupp.core.mapper.ProdutoConverter
import br.com.iupp.entrypoint.dto.ProdutoRequest
import br.com.iupp.infraestrutura.model.Events
import br.com.iupp.infraestrutura.model.ProductEvent
import br.com.iupp.core.port.ProductServicePort
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import java.util.*
import javax.validation.Valid

@Validated
@Controller("/produtos")
class ProdutoController(private val productServicePort: ProductServicePort) {

    @Post
    fun ProdutoParaNats(@Body @Valid produtoRequest: ProdutoRequest) : HttpResponse<Any> {

        productServicePort.sendCreateMessage(ProdutoConverter.produtoRequestToProduto(produtoRequest))

        return HttpResponse.accepted()
    }

    @Delete("/{id}")
    fun DeletaProdutoParaNats(@QueryValue id: UUID) : HttpResponse<Any>{

        productServicePort.sendDeleteMessage(ProdutoConverter.productEventToProduto(id=id.toString()))

        return HttpResponse.accepted()
    }

    @Put
    fun UpdateProdutoParaNats(@Body @Valid produtoRequest: ProdutoRequest) : HttpResponse<Any>{

        productServicePort.sendUpdateMessage(ProdutoConverter.produtoRequestToProduto(produtoRequest))

        return HttpResponse.accepted()
    }
}