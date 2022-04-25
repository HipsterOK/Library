package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.Authorship
import ru.ufanet.library.repository.AuthorshipRepository

@Service
class AuthorshipService(private val authorshipRepository: AuthorshipRepository) {
    fun getAll(): Iterable<Authorship> = authorshipRepository.findAll()
    fun getById(id: Long): Authorship = authorshipRepository.getById(id)
    fun add(authorship: Authorship): Authorship = authorshipRepository.save(authorship)
    fun edit(id: Long, authorship: Authorship): Authorship = authorshipRepository.save(authorship)
    fun remove(id: Long) = authorshipRepository.delete(authorshipRepository.getById(id))
}