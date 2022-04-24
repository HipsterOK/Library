package ru.ufanet.library.repository.fakedata

import com.github.javafaker.Faker
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ru.ufanet.library.domain.Author
import ru.ufanet.library.domain.Book
import ru.ufanet.library.domain.CorpUser
import ru.ufanet.library.domain.Genre
import ru.ufanet.library.domain.enum.BookType
import ru.ufanet.library.domain.enum.UserRole
import ru.ufanet.library.repository.AuthorRepository
import ru.ufanet.library.repository.BookRepository
import ru.ufanet.library.repository.GenreRepository
import ru.ufanet.library.repository.UserRepository
import java.lang.Math.random
import java.util.stream.IntStream
import kotlin.streams.toList

@Component
class SampleDataLoader(
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val genreRepository: GenreRepository
): CommandLineRunner {

    var faker: Faker = Faker()

    override fun run(vararg args: String?) {
        val authors = IntStream.rangeClosed(1, 100).mapToObj { it -> Author(
            it.toLong(), faker.name().lastName(), faker.name().firstName(), faker.name().title(), "") }.toList()
        authorRepository.saveAll(authors)

        val books = IntStream.rangeClosed(1, 100).mapToObj { it -> Book(
            it.toLong(), faker.book().title(),"descriptions!!!", random().toInt(), null, faker.date().birthday(), BookType.AUDIO_BOOK, random().toLong(), "www") }.toList()
        bookRepository.saveAll(books)

        val users = IntStream.rangeClosed(1, 100).mapToObj { it -> CorpUser(
            it.toLong(), faker.name().firstName(), faker.name().lastName(), faker.name().fullName(), UserRole.ADMIN, faker.name().name(), faker.name().username()) }.toList()
        userRepository.saveAll(users)

        val genres =  IntStream.rangeClosed(1, 100).mapToObj { it -> Genre(
            it.toLong(), faker.book().genre()) }.toList()
        genreRepository.saveAll(genres)
    }
}