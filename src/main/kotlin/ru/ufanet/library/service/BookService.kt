package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.Book
import ru.ufanet.library.repository.BookRepository

@Service
class BookService(private val bookRepository: BookRepository) {
    fun getAll(): Iterable<Book> = bookRepository.findAll()
    fun getById(id: Long): Book = bookRepository.getById(id)
    fun add(book: Book): Book = bookRepository.save(book)
    fun edit(id: Long, book: Book): Book = bookRepository.save(book)
    fun remove(id: Long) = bookRepository.delete(bookRepository.getById(id))
}