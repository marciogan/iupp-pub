package br.com.iupp.core.port

import br.com.iupp.core.model.Produto
import br.com.iupp.infraestrutura.model.ProductEvent
import javax.inject.Singleton

@Singleton
interface ProductServicePort {
    fun sendCreateMessage(produto: Produto)
    fun sendDeleteMessage(produto: Produto)
    fun sendUpdateMessage(produto: Produto)
}