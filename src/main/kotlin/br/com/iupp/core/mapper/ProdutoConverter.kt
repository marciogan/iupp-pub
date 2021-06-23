package br.com.iupp.core.mapper

import br.com.iupp.core.model.Produto
import br.com.iupp.entrypoint.dto.ProdutoRequest
import br.com.iupp.infraestrutura.model.ProductEvent
import java.math.BigDecimal

class ProdutoConverter {

    companion object {
        fun produtoRequestToProductEvent(produtoRequest: ProdutoRequest) =
            ProductEvent(produtoRequest.id, produtoRequest.nome, produtoRequest.descricao, produtoRequest.preco, produtoRequest.emailDono)

        fun produtoToProductRequest(produto: Produto) =
            ProdutoRequest(produto.id, produto.nome, produto.descricao, produto.preco, produto.emailDono)

        fun produtoRequestToProduto(produtoRequest: ProdutoRequest) =
            Produto(produtoRequest.id, produtoRequest.nome, produtoRequest.descricao, produtoRequest.preco, produtoRequest.emailDono)

        fun productEventToProduto(id: String) =
            Produto(id=id, "", "", BigDecimal.ZERO, "")

        fun produtoToProductEvent(produto: Produto) =
            ProductEvent(produto.id, produto.nome, produto.descricao, produto.preco, produto.emailDono)
        }


    }
