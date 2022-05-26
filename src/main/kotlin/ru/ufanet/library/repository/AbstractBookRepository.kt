package ru.ufanet.library.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.ufanet.library.domain.AbstractBook

interface AbstractBookRepository: JpaRepository<AbstractBook, Long> {
}