package ru.ufanet.library.controller

import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.AbstractBook
import ru.ufanet.library.domain.PaperBook
import ru.ufanet.library.service.AbstractBookService
import ru.ufanet.library.service.PaperBookService

//@CrossOrigin(origins = ["http://localhost:8081", "http://localhost:8081/book", "/**"])
@RestController()
@RequestMapping("/book")
class AbstractBookController(private val abstractBookService: AbstractBookService) {

    @GetMapping
    fun getBooks(): Iterable<AbstractBook> {
        return abstractBookService.getAll()
    }

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Long): AbstractBook {
        return abstractBookService.getById(id)
    }


    @PostMapping
    fun addBook(@RequestBody book: AbstractBook): AbstractBook {
        return abstractBookService.add(book)
    }

    @PutMapping("/{id}")
    fun editBook(@PathVariable id: Long, book: AbstractBook) : AbstractBook {
        abstractBookService.edit(id, book)
        return book
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: Long) {
        abstractBookService.remove(id)
    }
}
