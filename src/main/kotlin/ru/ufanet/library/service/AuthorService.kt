package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.Author
import ru.ufanet.library.repository.AuthorRepository

@Service
class AuthorService(private val authorRepository: AuthorRepository) {
    fun getAll(): Iterable<Author> = authorRepository.findAll()
    fun getById(id: Long): Author = authorRepository.getById(id)
    fun add(author: Author): Author = authorRepository.save(author)
    fun edit(id: Long, author: Author): Author = authorRepository.save(author)
    fun remove(id: Long) = authorRepository.delete(authorRepository.getById(id))
}