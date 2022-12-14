package com.mercadolivro.controllers.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PostBookRequest (
    @field: NotEmpty(message = "O nome do livro deve ser informado")
    var name: String,
    @field: NotNull(message = "O preço precisa ser informado")
    var price: BigDecimal,
    @JsonAlias("customer_id")
    var customerId: Int
)