package ru.ufanet.library.repository.fakedata

import com.github.javafaker.Faker
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ru.ufanet.library.domain.*
import ru.ufanet.library.domain.enum.Rating
import ru.ufanet.library.domain.enum.UserRole
import ru.ufanet.library.repository.*
import java.util.stream.IntStream

@Component
class SampleDataLoader(
    private val authorRepository: AuthorRepository,
    private val paperBookRepository: PaperBookRepository,
    private val userRepository: UserRepository,
    private val genreRepository: GenreRepository,
    private val authorshipRepository: AuthorshipRepository,
    private val readBookRepository: ReadBookRepository,
    private val reservationRepository: ReservationRepository,
    private val issuanceRepository: IssuanceRepository,
    private val queueRepository: QueueRepository,
    private val libraryOfficeRepository: LibraryOfficeRepository,
    private val commentRepository: CommentRepository,
    private val bookCopyRepository: BookCopyRepository,
    private val audioBookRepository: AudioBookRepository,
    private val videoBookRepository: VideoBookRepository
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

        val audiobooks = IntStream.rangeClosed(1, 100).mapToObj { it -> AudioBook(
            it.toLong(), faker.book().title(),"descriptions!!!", genres[it-1],
            "www") }.toList()
        audioBookRepository.saveAll(audiobooks)

        val paperBooks = IntStream.rangeClosed(1, 100).mapToObj { it -> PaperBook(
            it.toLong(), faker.book().title(),"descriptions!!!", genres[it-1],
            "www") }.toList()
        paperBookRepository.saveAll(paperBooks)

        val videobooks = IntStream.rangeClosed(1, 100).mapToObj { it -> VideoBook(
            it.toLong(), faker.book().title(),"descriptions!!!", genres[it-1],
            "www") }.toList()
        videoBookRepository.saveAll(videobooks)


        val bookCopies = IntStream.rangeClosed(1, 100).mapToObj { it -> BookCopy(
            it.toLong(), paperBooks[it-1], faker.address().zipCode(), faker.date().birthday(), libraryOffices[it-1], true) }.toList()
        bookCopyRepository.saveAll(bookCopies)

        val authorships = IntStream.rangeClosed(1, 100).mapToObj { it -> Authorship(
            it.toLong(), paperBooks[it-1],  authors[it-1]) }.toList()
        authorshipRepository.saveAll(authorships)

        val users = IntStream.rangeClosed(1, 100).mapToObj { it -> CorpUser(
            it.toLong(), faker.name().firstName(), faker.name().lastName(), faker.name().fullName(), UserRole.ADMIN, faker.name().name(), faker.name().username(), faker.name().nameWithMiddle()) }.toList()
        userRepository.saveAll(users)

        val readBooks = IntStream.rangeClosed(1, 100).mapToObj { it -> ReadBook(
            it.toLong(), paperBooks[it-1],  users[it-1]) }.toList()
        readBookRepository.saveAll(readBooks)

        val queues = IntStream.rangeClosed(1, 100).mapToObj { it -> Queue(
            it.toLong(),   users[it-1], paperBooks[it-1], faker.date().birthday()) }.toList()
        queueRepository.saveAll(queues)

        val comments = IntStream.rangeClosed(1, 100).mapToObj { it -> Comment(
            it.toLong(), paperBooks[it-1], users[it-1], Rating.Good, faker.file().extension()) }.toList()
        commentRepository.saveAll(comments)

        val issuances = IntStream.rangeClosed(1, 100).mapToObj { it -> Issuance(
            it.toLong(), bookCopies[it-1],  users[it-1], true, faker.date().birthday(), faker.date().birthday()) }.toList()
        issuanceRepository.saveAll(issuances)

        val reservations = IntStream.rangeClosed(1, 100).mapToObj { it -> Reservation(
            it.toLong(), bookCopies[it-1],  users[it-1], faker.date().birthday()) }.toList()
        reservationRepository.saveAll(reservations)

    }
}