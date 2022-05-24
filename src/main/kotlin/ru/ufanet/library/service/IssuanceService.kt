package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.CorpUser
import ru.ufanet.library.domain.Issuance
import ru.ufanet.library.domain.utility.Debtor
import ru.ufanet.library.repository.IssuanceRepository
import java.text.SimpleDateFormat
import java.util.*


@Service
class IssuanceService(private val issuanceRepository: IssuanceRepository) {
    fun getAll(): Iterable<Issuance> = issuanceRepository.findAll()
    fun getById(id: Long): Issuance = issuanceRepository.getById(id)
    fun add(issuance: Issuance): Issuance = issuanceRepository.save(issuance)
    fun edit(id: Long, issuance: Issuance): Issuance = issuanceRepository.save(issuance)
    fun remove(id: Long) = issuanceRepository.delete(issuanceRepository.getById(id))
    fun getAllDebtors(): List<Debtor> {
        return issuanceRepository.findAllDebtors().stream().map { t ->
            Debtor(t[0], t[1], t[2], t[3],
                    SimpleDateFormat("dd.MM.yyyy").format(SimpleDateFormat("yyyy-MM-dd").parse(t[4])))
        }.toList()
    }

    fun getAllByUser(user: CorpUser): Iterable<Issuance> = issuanceRepository.findAllByUser(user)
    fun extendIssuanceById(id: Long) {
        val issuance = issuanceRepository.getById(id)
        val cal = Calendar.getInstance()
        cal.time = issuance.endDate
        cal.add(Calendar.MONTH, 1)
        issuance.endDate.month = cal.time.month
        issuance.endDate.year = cal.time.year
        issuanceRepository.save(issuance)
    }
}