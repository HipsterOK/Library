package ru.ufanet.library.controller

import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.Reservation
import ru.ufanet.library.service.ReservationService

@RestController
@RequestMapping("/reservation")
class ReservationController(private val reservationService: ReservationService) {

    @CrossOrigin(origins = ["http://localhost:8081"])
    @GetMapping
    fun getReservation(): Iterable<Reservation> {
        return reservationService.getAll()
    }

    @GetMapping("{id}")
    fun getReservationById(@PathVariable id: Long): Reservation {
        return reservationService.getById(id)
    }

    @PostMapping
    fun addReservation(@RequestBody reservation: Reservation) {
        reservationService.add(reservation)
    }

    @PutMapping("{id}")
    fun editReservation(@PathVariable id: Long, reservation: Reservation) {
        reservationService.edit(id, reservation)
    }

    @DeleteMapping("{id}")
    fun deleteReservation(@PathVariable id: Long) {
        reservationService.remove(id)
    }
}