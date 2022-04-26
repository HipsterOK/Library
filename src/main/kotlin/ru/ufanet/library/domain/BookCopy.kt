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
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])
data class BookCopy(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Long? = 0,
    @OneToOne(fetch = FetchType.LAZY)
    open var bookId: Book,
    open var code: String,
    open var date: Date? = Date(),
    @OneToOne(fetch = FetchType.LAZY)
    open var lib: LibraryOffice,
    open var isFree: Boolean
)
