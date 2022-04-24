package ru.ufanet.library.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.ufanet.library.domain.CorpUser
import ru.ufanet.library.domain.Genre

@Repository
interface GenreRepository : JpaRepository<Genre, Long> {

}