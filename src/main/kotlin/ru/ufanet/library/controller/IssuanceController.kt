package ru.ufanet.library.controller

import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.CorpUser
import ru.ufanet.library.domain.Issuance
import ru.ufanet.library.domain.utility.Debtor
import ru.ufanet.library.service.IssuanceService
import javax.persistence.Tuple

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

    @GetMapping("debtors")
    fun getAllDebtors(): List<Debtor> {
        return issuanceService.getAllDebtors()
    }

    @GetMapping("{user}")
    fun getAllIssuanceByUser(@PathVariable user: CorpUser): Iterable<Issuance> {
        return issuanceService.getAllByUser(user)
    }

    @PutMapping("extend/{id}")
    fun extendIssuance(@PathVariable id: Long){
        issuanceService.extendIssuanceById(id)
    }
}