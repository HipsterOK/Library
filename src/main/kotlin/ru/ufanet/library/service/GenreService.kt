package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.Genre
import ru.ufanet.library.repository.GenreRepository

@Service
class GenreService(private val genreRepository: GenreRepository) {
    fun getAll(): Iterable<Genre> = genreRepository.findAll()
    fun getById(id: Long): Genre = genreRepository.getById(id)
    fun getByName(name: String): Iterable<Genre> {
        return genreRepository.findAll().filter{it.name.lowercase() == name.lowercase()}
    }


    fun add(genre: Genre): Genre {
        var existed = getByName(genre.name);
        return if (!existed.toList().isEmpty())
            existed.last()
        else
            genreRepository.save(genre)

    }
    fun edit(id: Long, genre: Genre): Genre = genreRepository.save(genre)
    fun remove(id: Long) = genreRepository.delete(genreRepository.getById(id))
}