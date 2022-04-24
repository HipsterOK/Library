package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.CorpUser
import ru.ufanet.library.repository.UserRepository

@Service
class UserService(private val userRepository: UserRepository) {
    fun getAll(): Iterable<CorpUser> = userRepository.findAll()
    fun getById(id: Long): CorpUser = userRepository.getById(id)
    fun add(corpUser: CorpUser): CorpUser = userRepository.save(corpUser)
    fun edit(id: Long, corpUser: CorpUser): CorpUser = userRepository.save(corpUser)
    fun remove(id: Long) = userRepository.delete(userRepository.getById(id))
}