package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.LibraryOffice
import ru.ufanet.library.repository.LibraryOfficeRepository

@Service
class LibraryOfficeService(private val libraryOfficeRepository: LibraryOfficeRepository) {
    fun getAll(): Iterable<LibraryOffice> = libraryOfficeRepository.findAll()
    fun getById(id: Long): LibraryOffice = libraryOfficeRepository.getById(id)
    fun add(libraryOffice: LibraryOffice): LibraryOffice = libraryOfficeRepository.save(libraryOffice)
    fun edit(id: Long, libraryOffice: LibraryOffice): LibraryOffice = libraryOfficeRepository.save(libraryOffice)
    fun remove(id: Long) = libraryOfficeRepository.delete(libraryOfficeRepository.getById(id))
}