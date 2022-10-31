package com.mercadolivro.enums

enum class Errors(val code: String, val message: String) {
    ML001("ML-001", "Invalid Request"),
    ML0101("ML-0101", "Book [%s] não existe"),
    ML0102("ML-0102", "Cannot update book with status [%s]"),
    ML0201("ML-0201", "Customer [%s] não existe")


}