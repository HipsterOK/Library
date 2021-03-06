package ru.ufanet.library.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.ufanet.library.domain.Author
import ru.ufanet.library.domain.Authorship

interface AuthorshipRepository: JpaRepository<Authorship, Long> {
    fun getByBook_Id(id: Long):Iterable<Authorship>
    fun deleteByBookId(id: Long)
}