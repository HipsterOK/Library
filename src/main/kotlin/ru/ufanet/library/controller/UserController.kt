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
import ru.ufanet.library.domain.CorpUser
import ru.ufanet.library.service.UserService

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @CrossOrigin(origins = ["http://localhost:8081"])
    @GetMapping
    fun getAllUsers(): Iterable<CorpUser> {
        return userService.getAll()
    }

    @GetMapping("{id}")
    fun getUserById(@PathVariable id: Long): CorpUser {
        return userService.getById(id)
    }

    @PostMapping
    fun addUser(@RequestBody user: CorpUser): CorpUser {
        return userService.add(user)
    }

    @PutMapping("{id}")
    fun editUser(@PathVariable id: Long, user: CorpUser) {
        userService.edit(id, user)
    }

    @DeleteMapping("{id}")
    fun deleteUser(@PathVariable id: Long) {
        userService.remove(id)
    }
}