package com.mercadolivro.service

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.Errors
import com.mercadolivro.exception.NotFoundException
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService (
    val bookRepository: BookRepository
){
    fun findAll(pageable: Pageable, name: String?): Page<BookModel>{
        name?.let {
            return bookRepository.findByNameContainingIgnoreCase(pageable, name)
        }
        return bookRepository.findAll(pageable)
    }
    //Cria via post
    fun create(book: BookModel){
        bookRepository.save(book)
    }
    //Lista via id
    fun findById(id: Int): BookModel{
        return bookRepository.findById(id).orElseThrow{NotFoundException(Errors.ML0101.message.format(id), Errors.ML0101.code)}
    }
    fun findActives(pageable: Pageable): Page<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO, pageable)
    }
    //Edita um elemento
    fun update(book: BookModel){
        bookRepository.save(book)
    }
    //Muda status para cancelado
    fun delete(id: Int){
        val book = findById(id)
        book.status = BookStatus.CANCELADO
        update(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomer(customer)
        for (book in books){
            book.status = BookStatus.DELETADO
        }
        bookRepository.saveAll(books)
    }
}