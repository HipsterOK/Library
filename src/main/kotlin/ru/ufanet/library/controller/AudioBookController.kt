package ru.ufanet.library.controller

import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.AudioBook
import ru.ufanet.library.domain.Author
import ru.ufanet.library.service.AudioBookService
import ru.ufanet.library.service.AuthorService

@RestController
@RequestMapping("/audiobook")
class AudioBookController(private val audioBookService: AudioBookService) {

    @CrossOrigin(origins = ["http://localhost:8081"])
    @GetMapping
    fun getAuthors(): Iterable<AudioBook> {
        return audioBookService.getAll()
    }

    @GetMapping("{id}")
    fun getAuthorById(@PathVariable id: Long): AudioBook {
        return audioBookService.getById(id)
    }

    @PostMapping
    fun addAuthor(@RequestBody audioBook: AudioBook) {
        audioBookService.add(audioBook)
    }

    @PutMapping("{id}")
    fun editAuthor(@PathVariable id: Long, audioBook: AudioBook) {
        audioBookService.edit(id, audioBook)
    }

    @DeleteMapping("{id}")
    fun deleteAuthor(@PathVariable id: Long) {
        audioBookService.remove(id)
    }
}