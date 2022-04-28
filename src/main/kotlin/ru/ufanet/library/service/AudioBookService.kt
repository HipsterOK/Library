package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.AudioBook
import ru.ufanet.library.repository.AudioBookRepository

@Service
class AudioBookService (private val bookRepository: AudioBookRepository) {
    fun getAll(): Iterable<AudioBook> = bookRepository.findAll()
    fun getById(id: Long): AudioBook = bookRepository.getById(id)
    fun add(book: AudioBook): AudioBook = bookRepository.save(book)
    fun edit(id: Long, book: AudioBook): AudioBook = bookRepository.save(book)
    fun remove(id: Long) = bookRepository.delete(bookRepository.getById(id))
}