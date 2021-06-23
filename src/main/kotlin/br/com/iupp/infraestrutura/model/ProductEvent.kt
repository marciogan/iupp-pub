package br.com.iupp.infraestrutura.model

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal

data class ProductEvent(
    val id: String = "",
    val nome: String = "",
    val descricao: String = "",
    val preco: BigDecimal = BigDecimal.ZERO,
    val emailDono: String = ""
)
//{
//    constructor(id: String) : this(id = id, nome = "",descricao = "",BigDecimal.ZERO, emailDono = "")
//}