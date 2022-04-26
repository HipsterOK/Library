package ru.ufanet.library.repository.fakedata

import com.github.javafaker.Faker
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ru.ufanet.library.controller.GenreController
import ru.ufanet.library.domain.*
import ru.ufanet.library.domain.enum.BookType
import ru.ufanet.library.domain.enum.Rating
import ru.ufanet.library.domain.enum.UserRole
import ru.ufanet.library.repository.*
import ru.ufanet.library.service.GenreService
import java.lang.Math.random
import java.util.stream.IntStream
import kotlin.streams.toList

@Component
class SampleDataLoader(
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val genreRepository: GenreRepository,
    private val authorshipRepository: AuthorshipRepository,
    private val readBookRepository: ReadBookRepository,
    private val reservationRepository: ReservationRepository,
    private val issuanceRepository: IssuanceRepository,
    private val queueRepository: QueueRepository,
    private val libraryOfficeRepository: LibraryOfficeRepository,
    private val commentRepository: CommentRepository,
    private val bookCopyRepository: BookCopyRepository
): CommandLineRunner {

    var faker: Faker = Faker()

    override fun run(vararg args: String?) {
        val authors = IntStream.rangeClosed(1, 100).mapToObj { it -> Author(
            it.toLong(), faker.name().lastName(), faker.name().firstName(), faker.name().title()) }.toList()
        authorRepository.saveAll(authors)

        val genres =  IntStream.rangeClosed(1, 100).mapToObj { it -> Genre(
            it.toLong(), faker.book().genre()) }.toList()
        genreRepository.saveAll(genres)

        val libraryOffices =  IntStream.rangeClosed(1, 100).mapToObj { it -> LibraryOffice(
            it.toLong(), faker.name().title(),faker.address().city(), faker.address().secondaryAddress()) }.toList()
        libraryOfficeRepository.saveAll(libraryOffices)

        val books = IntStream.rangeClosed(1, 100).mapToObj { it -> Book(
            it.toLong(), faker.book().title(),"descriptions!!!", genres[it-1],
            BookType.AUDIO_BOOK, "www") }.toList()
        bookRepository.saveAll(books)

        val booksCopys = IntStream.rangeClosed(1, 100).mapToObj { it -> BookCopy(
            it.toLong(), books[it-1], faker.address().zipCode(), faker.date().birthday(), libraryOffices[it-1], true) }.toList()
        bookCopyRepository.saveAll(booksCopys)

        val authorships = IntStream.rangeClosed(1, 100).mapToObj { it -> Authorship(
            it.toLong(), books[it-1],  authors[it-1]) }.toList()
        authorshipRepository.saveAll(authorships)

        val users = IntStream.rangeClosed(1, 100).mapToObj { it -> CorpUser(
            it.toLong(), faker.name().firstName(), faker.name().lastName(), faker.name().fullName(), UserRole.ADMIN, faker.name().name(), faker.name().username(), faker.name().nameWithMiddle()) }.toList()
        userRepository.saveAll(users)

        val readBooks = IntStream.rangeClosed(1, 100).mapToObj { it -> ReadBook(
            it.toLong(), books[it-1],  users[it-1]) }.toList()
        readBookRepository.saveAll(readBooks)

        val queues = IntStream.rangeClosed(1, 100).mapToObj { it -> Queue(
            it.toLong(),   users[it-1], books[it-1], faker.date().birthday(), it) }.toList()
        queueRepository.saveAll(queues)

        val comments = IntStream.rangeClosed(1, 100).mapToObj { it -> Comment(
            it.toLong(), books[it-1], users[it-1], Rating.Good, faker.file().extension()) }.toList()
        commentRepository.saveAll(comments)

        val issuances = IntStream.rangeClosed(1, 100).mapToObj { it -> Issuance(
            it.toLong(), booksCopys[it-1],  users[it-1], true, faker.date().birthday(), faker.date().birthday()) }.toList()
        issuanceRepository.saveAll(issuances)

        val reservations = IntStream.rangeClosed(1, 100).mapToObj { it -> Reservation(
            it.toLong(), booksCopys[it-1],  users[it-1], faker.date().birthday()) }.toList()
        reservationRepository.saveAll(reservations)

    }
}