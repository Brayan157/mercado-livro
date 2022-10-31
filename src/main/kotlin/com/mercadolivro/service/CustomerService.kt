package com.mercadolivro.service

import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.enums.Errors
import com.mercadolivro.exception.NotFoundException
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
) {
    //Lista todos
    fun findAll(name: String?): List<CustomerModel>{
        name?.let {
            return customerRepository.findByNameContainingIgnoreCase(it)
        }
        return customerRepository.findAll().toList()
    }
    //Cria via post
    fun create(customer: CustomerModel){
        customerRepository.save(customer)
    }
    //Lista via id
    fun findById(id: Int): CustomerModel{
        return customerRepository.findById(id).orElseThrow{NotFoundException(Errors.ML0201.message.format(id), Errors.ML0201.code)}
    }
    //Edita um elemento
    fun update(customer: CustomerModel){
        if (!customerRepository.existsById(customer.id!!)){
            throw Exception()
        }
        customerRepository.save(customer)
    }
    //Deleta um elemento
    fun delete(id: Int){
        val customer = findById(id)
        customer.status = CustomerStatus.INATIVO;
        bookService.deleteByCustomer(customer)
        customerRepository.save(customer)
    }

    fun emailAvailable(email: String): Boolean {
        return !customerRepository.existsByEmail(email)
    }
}