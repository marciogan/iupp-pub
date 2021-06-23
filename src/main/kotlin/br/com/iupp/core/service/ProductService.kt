package br.com.iupp.core.service

import br.com.iupp.core.mapper.ProdutoConverter
import br.com.iupp.core.model.Produto
import br.com.iupp.core.port.NatsServicePort
import br.com.iupp.core.port.ProductServicePort
import br.com.iupp.infraestrutura.model.ProductEvent
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class ProductService(private val service: NatsServicePort) : ProductServicePort {

    private val LOGGER = LoggerFactory.getLogger(this::class.java)

    override fun sendCreateMessage(product: Produto) {
        service.sendCreateNats(
            ProdutoConverter.produtoRequestToProductEvent(
                ProdutoConverter.produtoToProductRequest(product)
            )
        )
    }

    override fun sendDeleteMessage(produto: Produto) {
        service.sendDeleteNats(
            ProdutoConverter.produtoRequestToProductEvent(
                ProdutoConverter.produtoToProductRequest(produto)
            )
        )
    }

    override fun sendUpdateMessage(produto: Produto) {
        service.sendUpdateNats(
            ProdutoConverter.produtoRequestToProductEvent(
                ProdutoConverter.produtoToProductRequest(produto)
            )
        )
    }

}