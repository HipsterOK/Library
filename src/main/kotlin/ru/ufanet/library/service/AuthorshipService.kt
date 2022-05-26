package ru.ufanet.library.service

import org.springframework.stereotype.Service
import ru.ufanet.library.domain.Authorship
import ru.ufanet.library.repository.AuthorshipRepository

@Service
class AuthorshipService(private val authorshipRepository: AuthorshipRepository) {
    fun getAll(): Iterable<Authorship> = authorshipRepository.findAll()
    fun getById(id: Long): Authorship = authorshipRepository.getById(id)
    fun add(authorship: Authorship): Authorship = authorshipRepository.save(authorship)
    fun edit(id: Long, authorship: Authorship): Authorship = authorshipRepository.save(authorship)
    fun remove(id: Long) = authorshipRepository.delete(authorshipRepository.getById(id))
    fun getByAuthorId(id: Long): Iterable<Authorship> {
        return (getAll().filter { it.author.id == id })
    }
    fun getFilteredAuthorships(author_id: String, book_id: String) : Iterable<Authorship> {
        var authorships = getAll();

        if (author_id.toLongOrNull() != null)
            authorships = authorships.filter { it.author.id == author_id.toLong() }
        if (book_id.toLongOrNull() != null)
             authorships = authorships.filter { it.book.id == book_id.toLong() }

        return authorships
    }
    fun getByBookId(id:Long): Iterable<Authorship> {
        return authorshipRepository.getByBook_Id(id);
    }
    fun deleteByBookId(id:Long){
        authorshipRepository.deleteByBookId(id)
    }
}