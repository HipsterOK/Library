package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.Comment
import ru.ufanet.library.repository.CommentRepository

@Service
class CommentService(private val commentRepository: CommentRepository) {
    fun getAll(): Iterable<Comment> = commentRepository.findAll()
    fun getById(id: Long): Comment = commentRepository.getById(id)
    fun add(comment: Comment): Comment = commentRepository.save(comment)
    fun edit(id: Long, comment: Comment): Comment = commentRepository.save(comment)
    fun remove(id: Long) = commentRepository.delete(commentRepository.getById(id))
}