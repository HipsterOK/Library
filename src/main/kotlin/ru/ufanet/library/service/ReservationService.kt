package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.Reservation
import ru.ufanet.library.repository.ReservationRepository

@Service
class ReservationService(private val reservationRepository: ReservationRepository) {
    fun getAll(): Iterable<Reservation> = reservationRepository.findAll()
    fun getById(id: Long): Reservation = reservationRepository.getById(id)
    fun add(reservation: Reservation): Reservation = reservationRepository.save(reservation)
    fun edit(id: Long, reservation: Reservation): Reservation = reservationRepository.save(reservation)
    fun remove(id: Long) = reservationRepository.delete(reservationRepository.getById(id))
}