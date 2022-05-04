package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.Authorship
import ru.ufanet.library.domain.BookCopy
import ru.ufanet.library.repository.BookCopyRepository

@Service
class BookCopyService(private val bookCopyRepository: BookCopyRepository) {
    fun getAll(): Iterable<BookCopy> = bookCopyRepository.findAll()
    fun getById(id: Long): BookCopy = bookCopyRepository.getById(id)
    fun add(bookCopy: BookCopy): BookCopy = bookCopyRepository.save(bookCopy)
    fun edit(id: Long, bookCopy: BookCopy): BookCopy = bookCopyRepository.save(bookCopy)
    fun remove(id: Long) = bookCopyRepository.delete(bookCopyRepository.getById(id))
    fun getByLibraryId(id: Long): Iterable<BookCopy> {
        return getAll().filter { it.lib.id == id }
    }
    fun getByTitle(title: String): Iterable<BookCopy> {
        return  getAll().filter { it.paperBook.title.lowercase().contains(title.lowercase()) }
    }

    fun getFilteredBooks(title: String = "", lib_id: String = "") : Iterable<BookCopy> {
        var paperBooks = getAll();



        if (title != null)
            paperBooks = paperBooks.filter { it.paperBook.title.lowercase().contains(title.lowercase()) }
        if (lib_id.toLongOrNull() != null)
            paperBooks = paperBooks.filter { it.paperBook.id == lib_id.toLong() }

        return paperBooks
    }
}