package ru.ufanet.library.controller

import org.springframework.web.bind.annotation.*
import ru.ufanet.library.domain.Comment
import ru.ufanet.library.service.CommentService

@RestController
@RequestMapping("/comment")
class CommentController(private val commentService: CommentService) {

    @CrossOrigin(origins = ["http://localhost:8081"])
    @GetMapping
    fun getComment(): Iterable<Comment> {
        return commentService.getAll()
    }

    @GetMapping("{id}")
    fun getCommentById(@PathVariable id: Long): Comment {
        return commentService.getById(id)
    }

    @PostMapping
    fun addComment(@RequestBody comment: Comment): Comment {
        return commentService.add(comment)
    }

    @PutMapping("{id}")
    fun editComment(@PathVariable id: Long, comment: Comment) {
        commentService.edit(id, comment)
    }

    @DeleteMapping("{id}")
    fun deleteComment(@PathVariable id: Long) {
        commentService.remove(id)
    }
}