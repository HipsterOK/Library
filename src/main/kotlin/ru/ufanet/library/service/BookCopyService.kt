package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.Authorship
import ru.ufanet.library.domain.BookCopy
import ru.ufanet.library.repository.BookCopyRepository
import java.awt.Stroke
import java.util.*

@Service
class BookCopyService(private val bookCopyRepository: BookCopyRepository) {
    fun getAll(): Iterable<BookCopy> = bookCopyRepository.findAll()
    fun getById(id: Long): BookCopy = bookCopyRepository.getById(id)
    fun add(bookCopy: BookCopy): BookCopy {
        if (bookCopy.code == null || bookCopy.code == "") {
            var generatedCode: String;
            do {
                generatedCode = (100000..999999).random().toString();

            } while (getByCode(generatedCode) != null)
            bookCopy.code = generatedCode;
        }
        println(bookCopy.code)
        if (bookCopy.date == null)
            bookCopy.date = Date()
        return bookCopyRepository.save(bookCopy)
    }

    fun getByCode(code: String): BookCopy? {
        return try {
            bookCopyRepository.getBookCopyByCode(code)
        } catch (e: Exception) {
            null
        }

    }
    fun edit(id: Long, bookCopy: BookCopy): BookCopy = bookCopyRepository.saveAndFlush(bookCopy)
    fun remove(id: Long) = bookCopyRepository.delete(bookCopyRepository.getById(id))
    fun getByLibraryId(id: Long): Iterable<BookCopy> {
        return getAll().filter { it.lib.id == id }
    }
    fun getByTitle(title: String): Iterable<BookCopy> {
        return  getAll().filter { it.paperBook.title.lowercase().contains(title.lowercase()) }
    }

    fun getFilteredBooks(title: String = "", lib_id: String = "") : Iterable<BookCopy> {
        var paperBooks = getAll();

        if (title != "")
            paperBooks = paperBooks.filter { it.paperBook.title.lowercase().contains(title.lowercase()) }
        if (lib_id.toLongOrNull() != null)
            paperBooks = paperBooks.filter { it.lib.id == lib_id.toLong() }

        return paperBooks
    }
}