package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import ru.ufanet.library.controller.GenreController
import ru.ufanet.library.domain.enum.BookType
import ru.ufanet.library.repository.GenreRepository
import ru.ufanet.library.service.GenreService
import java.text.SimpleDateFormat
import java.util.Date
import javax.persistence.*

@Entity
@DiscriminatorValue("PaperBook")
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])
class PaperBook(
    @Column(nullable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Long = 0,
    override var title: String,
    override var description: String = "",
    @OneToOne(fetch = FetchType.LAZY)
    override var genre: Genre,
    override var link: String = "",
    ):
    AbstractBook()

