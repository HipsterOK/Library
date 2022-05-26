package ru.ufanet.library.controller

import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.Authorship
import ru.ufanet.library.domain.PaperBook
import ru.ufanet.library.service.AuthorshipService
import ru.ufanet.library.service.PaperBookService

@RestController
@RequestMapping("/authorship")
class AuthorshipController(private val authorshipService: AuthorshipService) {

//    @CrossOrigin(origins = ["http://localhost:8081"])
    @GetMapping()
    @ResponseBody
    fun getAuthorships(@RequestParam(defaultValue = "") bookID: String,
                       @RequestParam(defaultValue = "") authorID: String): Iterable<Authorship> {
        return authorshipService.getFilteredAuthorships(authorID, bookID)
    }

    @GetMapping("{id}")
    fun getAuthorshipById(@PathVariable id: Long): Authorship {
        return authorshipService.getById(id)
    }

    @PostMapping
    fun addAuthorship(@RequestBody authorship: Authorship): Authorship {
        return authorshipService.add(authorship)
    }

    @PutMapping("{id}")
    fun editAuthorship(@PathVariable id: Long, authorship: Authorship) {
        authorshipService.edit(id, authorship)
    }

    @DeleteMapping("{id}")
    fun deleteAuthorship(@PathVariable id: Long) {
        authorshipService.remove(id)
    }
    @Transactional
    @DeleteMapping("/book/{id}")
    fun deleteAuthorshipByBookId(@PathVariable id: Long) {
        authorshipService.deleteByBookId(id)
    }

//    @GetMapping
//    fun getAuthorshipByBookId(@RequestParam(defaultValue = "") id: String): Iterable<Authorship>{
//        println(id)
//       return authorshipService.getByBookId(id.toLong());
//    }
}