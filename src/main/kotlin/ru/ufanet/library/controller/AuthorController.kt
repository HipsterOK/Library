package ru.ufanet.library.controller

import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.Author
import ru.ufanet.library.service.AuthorService

@RestController
@RequestMapping("/author")
class AuthorController(private val authorService: AuthorService) {

    @CrossOrigin(origins = ["http://localhost:8081"])
    @GetMapping
    fun getAuthors(): Iterable<Author> {
        return authorService.getAll()
    }

    @GetMapping("{id}")
    fun getAuthorById(@PathVariable id: Long): Author {
        return authorService.getById(id)
    }

    @PostMapping
    fun addAuthor(@RequestBody author: Author) {
        authorService.add(author)
    }

    @PutMapping("{id}")
    fun editAuthor(@PathVariable id: Long, author: Author) {
        authorService.edit(id, author)
    }

    @DeleteMapping("{id}")
    fun deleteAuthor(@PathVariable id: Long) {
        authorService.remove(id)
    }
}