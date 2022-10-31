package com.mercadolivro.controllers.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty


data class PutCustomerRequest (
    @field: NotEmpty(message = "Nome não pode estar vazio")
    var name: String,

    @field: Email(message = "E-mail invalido")
    var email: String,
)