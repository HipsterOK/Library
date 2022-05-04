package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.Authorship
import ru.ufanet.library.domain.PaperBook
import ru.ufanet.library.repository.PaperBookRepository

@Service
class PaperBookService(private val paperBookRepository: PaperBookRepository,
                           private val bookCopyService: BookCopyService) {
    fun getAll(): Iterable<PaperBook> = paperBookRepository.findAll()
    fun getById(id: Long): PaperBook = paperBookRepository.getById(id)
    fun add(paperBook: PaperBook): PaperBook = paperBookRepository.save(paperBook)
    fun edit(id: Long, paperBook: PaperBook): PaperBook = paperBookRepository.save(paperBook)
    fun remove(id: Long) = paperBookRepository.delete(paperBookRepository.getById(id))
    fun getByTitle(title: String): Iterable<PaperBook> {
        val filteredBooks = getAll().filter { it.title.lowercase().contains(title.lowercase()) }
        return  filteredBooks;
    }
    fun getByLibrary(id: Long): Iterable<PaperBook> {

        var filteredBooks = bookCopyService.getByLibraryId(id)
        return filteredBooks.map { it.paperBook }.distinct();
    }

//    fun getFilteredAuthorships(title: String = "", lib_id: String = "") : Iterable<Authorship> {
////        var paperBooks = getAll();
////
////
////
////        if (title.toLongOrNull() != null)
////            paperBooks = paperBooks.filter { it.title.lowercase().contains(title.lowercase()) }
////        if (lib_id.toLongOrNull() != null)
////            authorships = authorships.filter { it.paperBook.id == book_id.toLong() }
////
////        return authorships
////    }
}