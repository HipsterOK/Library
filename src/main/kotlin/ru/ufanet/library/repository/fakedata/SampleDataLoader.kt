package ru.ufanet.library.repository.fakedata

import com.github.javafaker.Faker
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ru.ufanet.library.domain.Author
import ru.ufanet.library.domain.Book
import ru.ufanet.library.domain.enum.BookType
import ru.ufanet.library.repository.AuthorRepository
import ru.ufanet.library.repository.BookRepository
import java.lang.Math.random
import java.util.stream.IntStream

@Component
class SampleDataLoader(
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository
): CommandLineRunner {

    var faker: Faker = Faker()

    override fun run(vararg args: String?) {
        val authors = IntStream.rangeClosed(1, 100).mapToObj { it -> Author(
            it.toLong(), faker.name().lastName(), faker.name().firstName(), faker.name().title(), "") }.toList()
        authorRepository.saveAll(authors)

        val books = IntStream.rangeClosed(1, 100).mapToObj { it -> Book(
            it.toLong(), faker.book().title(), random().toInt(), BookType.AUDIO_BOOK) }.toList()
        bookRepository.saveAll(books)
    }
}