package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.AbstractBook
import ru.ufanet.library.domain.AudioBook
import ru.ufanet.library.repository.AbstractBookRepository
import ru.ufanet.library.repository.AudioBookRepository

@Service
class AbstractBookService (private val abstractBookRepository: AbstractBookRepository) {
    fun getAll(): Iterable<AbstractBook> = abstractBookRepository.findAll()
    fun getById(id: Long): AbstractBook = abstractBookRepository.getById(id)
    fun add(book: AbstractBook): AbstractBook = abstractBookRepository.save(book)
    fun edit(id: Long, book: AbstractBook): AbstractBook = abstractBookRepository.save(book)
    fun remove(id: Long) = abstractBookRepository.delete(abstractBookRepository.getById(id))
}