package com.mercadolivro.exception

class MercadoLivroException(override val message:String="Error Service", val errorCode:String="500"):Exception() {
}