package ru.ufanet.library.controller

import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.Authorship
import ru.ufanet.library.service.AuthorshipService

@RestController
@RequestMapping("/authorship")
class AuthorshipController(private val authorshipService: AuthorshipService) {

    @CrossOrigin(origins = ["http://localhost:8081"])
    @GetMapping
    fun getAuthorships(): Iterable<Authorship> {
        return authorshipService.getAll()
    }

    @GetMapping("{id}")
    fun getAuthorshipById(@PathVariable id: Long): Authorship {
        return authorshipService.getById(id)
    }

    @PostMapping
    fun addAuthorship(@RequestBody authorship: Authorship) {
        authorshipService.add(authorship)
    }

    @PutMapping("{id}")
    fun editAuthorship(@PathVariable id: Long, authorship: Authorship) {
        authorshipService.edit(id, authorship)
    }

    @DeleteMapping("{id}")
    fun deleteAuthorship(@PathVariable id: Long) {
        authorshipService.remove(id)
    }
}