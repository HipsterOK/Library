package ru.ufanet.library.controller

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.Book
import ru.ufanet.library.service.BookService

//@CrossOrigin(origins = ["http://localhost:8081", "http://localhost:8081/book", "/**"])
@RestController()
@RequestMapping("/book")
class BookController(private val bookService: BookService) {

    @GetMapping
    fun getBooks(): Iterable<Book> {
        return bookService.getAll()
    }

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Long): Book {
        return bookService.getById(id)
    }

    @PostMapping
    fun addBook(@RequestBody book: Book): Book {
        return bookService.add(book)
    }

    @PutMapping("/{id}")
    fun editBook(@PathVariable id: Long, book: Book) : Book {
        bookService.edit(id, book)
        return book
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: Long) {
        bookService.remove(id)
    }
}
