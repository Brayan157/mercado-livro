package com.mercadolivro.extension

import com.mercadolivro.controllers.request.PostBookRequest
import com.mercadolivro.controllers.request.PostCustomerRequest
import com.mercadolivro.controllers.request.PutBookRequest
import com.mercadolivro.controllers.request.PutCustomerRequest
import com.mercadolivro.controllers.response.BookResponse
import com.mercadolivro.controllers.response.CustomerResponse
import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel (name = this.name, email = this.email, status = CustomerStatus.ATIVO)
}
fun PutCustomerRequest.toCustomerModel(previosValue: CustomerModel): CustomerModel {
    return CustomerModel (id = previosValue.id, name = this.name, email = this.email, status = previosValue.status)
}
fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel{
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}
fun PutBookRequest.toBookModel(previosValue: BookModel): BookModel{
    return BookModel(
        id = previosValue.id,
        name = this.name ?: previosValue.name,
        price = this.price ?: previosValue.price,
        status = previosValue.status!!,
        customer = previosValue.customer
    )
}
fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )
}
fun BookModel.toResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        status = this.status,
        customer = this.customer
    )
}