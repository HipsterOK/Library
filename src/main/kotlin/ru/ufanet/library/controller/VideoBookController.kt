package ru.ufanet.library.controller

import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.AudioBook
import ru.ufanet.library.domain.Author
import ru.ufanet.library.domain.VideoBook
import ru.ufanet.library.service.AudioBookService
import ru.ufanet.library.service.AuthorService
import ru.ufanet.library.service.VideoBookService

@RestController
@RequestMapping("/videobook")
class VideoBookController(private val videoBookService: VideoBookService) {

    @CrossOrigin(origins = ["http://localhost:8081"])
    @GetMapping
    fun getAuthors(): Iterable<VideoBook> {
        return videoBookService.getAll()
    }

    @GetMapping("{id}")
    fun getAuthorById(@PathVariable id: Long): VideoBook {
        return videoBookService.getById(id)
    }

    @PostMapping
    fun addAuthor(@RequestBody videoBook: VideoBook) {
        videoBookService.add(videoBook)
    }

    @PutMapping("{id}")
    fun editAuthor(@PathVariable id: Long, videoBook: VideoBook) {
        videoBookService.edit(id, videoBook)
    }

    @DeleteMapping("{id}")
    fun deleteAuthor(@PathVariable id: Long) {
        videoBookService.remove(id)
    }
}