package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.BookCopy
import ru.ufanet.library.repository.BookCopyRepository

@Service
class BookCopyService(private val bookCopyRepository: BookCopyRepository) {
    fun getAll(): Iterable<BookCopy> = bookCopyRepository.findAll()
    fun getById(id: Long): BookCopy = bookCopyRepository.getById(id)
    fun add(bookCopy: BookCopy): BookCopy = bookCopyRepository.save(bookCopy)
    fun edit(id: Long, bookCopy: BookCopy): BookCopy = bookCopyRepository.save(bookCopy)
    fun remove(id: Long) = bookCopyRepository.delete(bookCopyRepository.getById(id))
}