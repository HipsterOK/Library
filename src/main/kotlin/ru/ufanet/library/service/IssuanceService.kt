package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.Issuance
import ru.ufanet.library.repository.IssuanceRepository

@Service
class IssuanceService(private val issuanceRepository: IssuanceRepository) {
    fun getAll(): Iterable<Issuance> = issuanceRepository.findAll()
    fun getById(id: Long): Issuance = issuanceRepository.getById(id)
    fun add(issuance: Issuance): Issuance = issuanceRepository.save(issuance)
    fun edit(id: Long, issuance: Issuance): Issuance = issuanceRepository.save(issuance)
    fun remove(id: Long) = issuanceRepository.delete(issuanceRepository.getById(id))
}