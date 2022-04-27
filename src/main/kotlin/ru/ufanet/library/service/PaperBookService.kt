package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.PaperBook
import ru.ufanet.library.repository.PaperBookRepository

@Service
class PaperBookService(private val paperBookRepository: PaperBookRepository) {
    fun getAll(): Iterable<PaperBook> = paperBookRepository.findAll()
    fun getById(id: Long): PaperBook = paperBookRepository.getById(id)
    fun add(paperBook: PaperBook): PaperBook = paperBookRepository.save(paperBook)
    fun edit(id: Long, paperBook: PaperBook): PaperBook = paperBookRepository.save(paperBook)
    fun remove(id: Long) = paperBookRepository.delete(paperBookRepository.getById(id))
}