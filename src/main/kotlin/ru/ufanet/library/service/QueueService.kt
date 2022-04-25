package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.Queue
import ru.ufanet.library.repository.QueueRepository

@Service
class QueueService(private val queueRepository: QueueRepository) {
    fun getAll(): Iterable<Queue> = queueRepository.findAll()
    fun getById(id: Long): Queue = queueRepository.getById(id)
    fun add(queue: Queue): Queue = queueRepository.save(queue)
    fun edit(id: Long, queue: Queue): Queue = queueRepository.save(queue)
    fun remove(id: Long) = queueRepository.delete(queueRepository.getById(id))
}