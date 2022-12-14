package com.mercadolivro.controllers.request

import com.mercadolivro.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest (

    @field: NotEmpty(message = "Nome deve ser informado")
    var name: String,
    @field: Email(message = "E-mail deve ser valido")
    @EmailAvailable
    var email: String,
)