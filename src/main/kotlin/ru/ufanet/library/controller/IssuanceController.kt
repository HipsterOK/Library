package ru.ufanet.library.controller

import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.Issuance
import ru.ufanet.library.service.IssuanceService

@RestController
@RequestMapping("/issuance")
class IssuanceController(private val issuanceService: IssuanceService) {

    @CrossOrigin(origins = ["http://localhost:8081"])
    @GetMapping
    fun getIssuance(): Iterable<Issuance> {
        return issuanceService.getAll()
    }

    @GetMapping("{id}")
    fun getIssuanceById(@PathVariable id: Long): Issuance {
        return issuanceService.getById(id)
    }

    @PostMapping
    fun addIssuance(@RequestBody issuance: Issuance) {
        issuanceService.add(issuance)
    }

    @PutMapping("{id}")
    fun editIssuance(@PathVariable id: Long, issuance: Issuance) {
        issuanceService.edit(id, issuance)
    }

    @DeleteMapping("{id}")
    fun deleteIssuance(@PathVariable id: Long) {
        issuanceService.remove(id)
    }
}