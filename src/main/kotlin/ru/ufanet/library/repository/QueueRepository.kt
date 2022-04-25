package ru.ufanet.library.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.ufanet.library.domain.*

interface QueueRepository: JpaRepository<Queue, Long> {
}