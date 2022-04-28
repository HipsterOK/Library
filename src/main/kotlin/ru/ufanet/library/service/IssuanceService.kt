package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.Issuance
import ru.ufanet.library.domain.utility.Debtor
import ru.ufanet.library.repository.IssuanceRepository
import java.text.SimpleDateFormat
import java.util.*
import java.util.stream.Collector
import javax.persistence.Tuple

@Service
class IssuanceService(private val issuanceRepository: IssuanceRepository) {
    fun getAll(): Iterable<Issuance> = issuanceRepository.findAll()
    fun getById(id: Long): Issuance = issuanceRepository.getById(id)
    fun add(issuance: Issuance): Issuance = issuanceRepository.save(issuance)
    fun edit(id: Long, issuance: Issuance): Issuance = issuanceRepository.save(issuance)
    fun remove(id: Long) = issuanceRepository.delete(issuanceRepository.getById(id))
    fun getAllDebtors(): List<Debtor> {
        val listDebtor: List<Debtor> = issuanceRepository.findAllDebtors().stream().map { t ->
            Debtor(t[0], t[1], t[2],
                    SimpleDateFormat("yyyy-MM-dd").parse(t[3]))
        }.toList()
        //issuanceRepository.findAllDebtors().stream().forEach{t-> run { println(t[0]);println(t[1]);println(t[2]);println(t[3]) } }
        return listDebtor
    }
}