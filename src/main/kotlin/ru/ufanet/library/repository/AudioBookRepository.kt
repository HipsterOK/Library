package ru.ufanet.library.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.ufanet.library.domain.AudioBook

interface AudioBookRepository : JpaRepository<AudioBook, Long> {
}