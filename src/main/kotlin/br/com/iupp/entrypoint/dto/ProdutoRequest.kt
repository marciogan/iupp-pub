package br.com.iupp.entrypoint.dto

import br.com.iupp.infraestrutura.model.ProductEvent
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Introspected
data class ProdutoRequest(
    val id: String = "",
    @field:NotBlank val nome: String,
    val descricao: String,
    @field:NotBlank @field:Positive val preco: BigDecimal,
    @field:NotBlank @field:Email val emailDono: String
)