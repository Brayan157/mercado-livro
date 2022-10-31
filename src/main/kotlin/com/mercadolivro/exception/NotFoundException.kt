package com.mercadolivro.exception

import java.lang.Exception

class NotFoundException(override val message: String, val errorCode:String):Exception()  {

}