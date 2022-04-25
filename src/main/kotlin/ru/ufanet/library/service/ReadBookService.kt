package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.ReadBook
import ru.ufanet.library.repository.ReadBookRepository

@Service
class ReadBookService(private val readBookRepository: ReadBookRepository) {
    fun getAll(): Iterable<ReadBook> = readBookRepository.findAll()
    fun getById(id: Long): ReadBook = readBookRepository.getById(id)
    fun add(readBook: ReadBook): ReadBook = readBookRepository.save(readBook)
    fun edit(id: Long, readBook: ReadBook): ReadBook = readBookRepository.save(readBook)
    fun remove(id: Long) = readBookRepository.delete(readBookRepository.getById(id))
}