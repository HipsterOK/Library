package ru.ufanet.library.controller

import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.PaperBook
import ru.ufanet.library.service.PaperBookService

//@CrossOrigin(origins = ["http://localhost:8081", "http://localhost:8081/book", "/**"])
@RestController()
@RequestMapping("/book")
class PaperBookController(private val bookService: PaperBookService) {

    @GetMapping
    fun getBooks(): Iterable<PaperBook> {
        return bookService.getAll()
    }

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Long): PaperBook {
        return bookService.getById(id)
    }

    @GetMapping("/title/{title}")
    fun getBookByTitle(@PathVariable title: String): Iterable<PaperBook> {
        return bookService.getByTitle(title)
    }

    @PostMapping
    fun addBook(@RequestBody paperBook: PaperBook): PaperBook {
        return bookService.add(paperBook)
    }

    @PutMapping("/{id}")
    fun editBook(@PathVariable id: Long, paperBook: PaperBook) : PaperBook {
        bookService.edit(id, paperBook)
        return paperBook
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: Long) {
        bookService.remove(id)
    }
}
