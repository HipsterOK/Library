package ru.ufanet.library.controller

import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.PaperBook
import ru.ufanet.library.service.PaperBookService

//@CrossOrigin(origins = ["http://localhost:8081", "http://localhost:8081/book", "/**"])
@RestController()
@RequestMapping("/paperBook")
class PaperBookController(private val paperBookService: PaperBookService) {

    @GetMapping
    fun getBooks(): Iterable<PaperBook> {
        return paperBookService.getAll()
    }

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Long): PaperBook {
        return paperBookService.getById(id)
    }

    @GetMapping("/title/{title}")
    fun getBookByTitle(@PathVariable title: String): Iterable<PaperBook> {
        return paperBookService.getByTitle(title)
    }

    @PostMapping
    fun addBook(@RequestBody paperBook: PaperBook): PaperBook {
        return paperBookService.add(paperBook)
    }

    @PutMapping("/{id}")
    fun editBook(@PathVariable id: Long, paperBook: PaperBook) : PaperBook {
        paperBookService.edit(id, paperBook)
        return paperBook
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: Long) {
        paperBookService.remove(id)
    }
}
