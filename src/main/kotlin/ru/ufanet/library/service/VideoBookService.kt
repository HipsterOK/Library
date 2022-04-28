package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.AudioBook
import ru.ufanet.library.domain.VideoBook
import ru.ufanet.library.repository.AudioBookRepository
import ru.ufanet.library.repository.VideoBookRepository

@Service
class VideoBookService (private val videoBookRepository: VideoBookRepository) {
    fun getAll(): Iterable<VideoBook> = videoBookRepository.findAll()
    fun getById(id: Long): VideoBook = videoBookRepository.getById(id)
    fun add(book: VideoBook): VideoBook = videoBookRepository.save(book)
    fun edit(id: Long, book: VideoBook): VideoBook = videoBookRepository.save(book)
    fun remove(id: Long) = videoBookRepository.delete(videoBookRepository.getById(id))
}