package ru.ufanet.library.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.ufanet.library.domain.Author
import ru.ufanet.library.domain.Authorship
import ru.ufanet.library.domain.ReadBook
import ru.ufanet.library.domain.Reservation

interface ReservationRepository: JpaRepository<Reservation, Long> {
}