package ru.ufanet.library.controller

import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.Queue
import ru.ufanet.library.service.QueueService

@RestController
@RequestMapping("/queue")
class QueueController(private val queueService: QueueService) {

    @CrossOrigin(origins = ["http://localhost:8081"])
    @GetMapping
    fun getQueue(): Iterable<Queue> {
        return queueService.getAll()
    }

    @GetMapping("{id}")
    fun getQueueById(@PathVariable id: Long): Queue {
        return queueService.getById(id)
    }

    @PostMapping
    fun addQueue(@RequestBody queue: Queue) {
        queueService.add(queue)
    }

    @PutMapping("{id}")
    fun editQueue(@PathVariable id: Long, queue: Queue) {
        queueService.edit(id, queue)
    }

    @DeleteMapping("{id}")
    fun deleteQueue(@PathVariable id: Long) {
        queueService.remove(id)
    }
}