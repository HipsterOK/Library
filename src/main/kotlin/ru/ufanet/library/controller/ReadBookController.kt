package ru.ufanet.library.controller

import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.ReadBook
import ru.ufanet.library.service.ReadBookService

@RestController
@RequestMapping("/readBook")
class ReadBookController(private val readBookService: ReadBookService) {

    @CrossOrigin(origins = ["http://localhost:8081"])
    @GetMapping
    fun getReadBook(): Iterable<ReadBook> {
        return readBookService.getAll()
    }

    @GetMapping("{id}")
    fun getReadBookById(@PathVariable id: Long): ReadBook {
        return readBookService.getById(id)
    }

    @PostMapping
    fun addReadBook(@RequestBody readBook: ReadBook) {
        readBookService.add(readBook)
    }

    @PutMapping("{id}")
    fun editReadBook(@PathVariable id: Long, readBook: ReadBook) {
        readBookService.edit(id, readBook)
    }

    @DeleteMapping("{id}")
    fun deleteReadBook(@PathVariable id: Long) {
        readBookService.remove(id)
    }
}