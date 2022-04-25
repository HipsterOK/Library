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
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Long? = 0,
    open var title: String? = "тут ноль",
    open var description: String? = "",
    open var quantity: Int? = 0,
    @OneToOne(fetch = FetchType.LAZY)
    open var genre: Genre,
//    @OneToOne(fetch = FetchType.LAZY)
//    open var authorship: Authorship,
    open var addDate: Date? = Date(),
    open var type: BookType? = BookType.PHYSICAL_BOOK,
    open var libId: Long?,
    open var src: String? =""
)
