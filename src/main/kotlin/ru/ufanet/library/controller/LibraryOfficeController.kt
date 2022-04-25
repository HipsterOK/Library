package ru.ufanet.library.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.ufanet.library.domain.LibraryOffice
import ru.ufanet.library.service.LibraryOfficeService

@RestController
@RequestMapping("/libraryOffice")
class LibraryOfficeController(private val libraryOfficeService: LibraryOfficeService) {

    @CrossOrigin(origins = ["http://localhost:8081"])
    @GetMapping
    fun getAllLibraryOffice(): Iterable<LibraryOffice> {
        return libraryOfficeService.getAll()
    }

    @GetMapping("{id}")
    fun getLibraryOfficeById(@PathVariable id: Long): LibraryOffice {
        return libraryOfficeService.getById(id)
    }

    @PostMapping
    fun addLibraryOffice(@RequestBody libraryOffice: LibraryOffice): LibraryOffice {
        return libraryOfficeService.add(libraryOffice)
    }

    @PutMapping("{id}")
    fun editLibraryOffice(@PathVariable id: Long, libraryOffice: LibraryOffice) {
        libraryOfficeService.edit(id, libraryOffice)
    }

    @DeleteMapping("{id}")
    fun deleteLibraryOffice(@PathVariable id: Long) {
        libraryOfficeService.remove(id)
    }
}