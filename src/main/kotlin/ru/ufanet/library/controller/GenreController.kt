package ru.ufanet.library.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.ufanet.library.domain.Genre
import ru.ufanet.library.service.GenreService

@RestController
@RequestMapping("/genre")
class GenreController(private val genreService: GenreService) {

    @CrossOrigin(origins = ["http://localhost:8081"])
    @GetMapping
    fun getAllGenre(): Iterable<Genre> {
        return genreService.getAll()
    }

    @GetMapping("{id}")
    fun getGenreById(@PathVariable id: Long): Genre {
        return genreService.getById(id)
    }

    @PostMapping
    fun addGenre(@RequestBody genre: Genre): Genre {
        return genreService.add(genre)
    }

    @PutMapping("{id}")
    fun editGenre(@PathVariable id: Long, genre: Genre) {
        genreService.edit(id, genre)
    }

    @DeleteMapping("{id}")
    fun deleteGenre(@PathVariable id: Long) {
        genreService.remove(id)
    }
}