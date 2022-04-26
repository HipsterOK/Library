package ru.ufanet.library.controller

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.BookCopy
import ru.ufanet.library.service.BookCopyService

//@CrossOrigin(origins = ["http://localhost:8081", "http://localhost:8081/bookCopy", "/**"])
@RestController()
@RequestMapping("/bookCopy")
class BookCopyCopyController(private val bookCopyService: BookCopyService) {

    @GetMapping
    fun getBookCopys(): Iterable<BookCopy> {
        return bookCopyService.getAll()
    }

    @GetMapping("/{id}")
    fun getBookCopy(@PathVariable id: Long): BookCopy {
        return bookCopyService.getById(id)
    }

    @PostMapping
    fun addBookCopy(@RequestBody bookCopy: BookCopy): BookCopy {
        return bookCopyService.add(bookCopy)
    }

    @PutMapping("/{id}")
    fun editBookCopy(@PathVariable id: Long, bookCopy: BookCopy) : BookCopy {
        bookCopyService.edit(id, bookCopy)
        return bookCopy
    }

    @DeleteMapping("/{id}")
    fun deleteBookCopy(@PathVariable id: Long) {
        bookCopyService.remove(id)
    }
}
