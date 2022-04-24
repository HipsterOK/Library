package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import ru.ufanet.library.domain.enum.BookType
import javax.persistence.*

@Entity
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Long? = 0,
    open var title: String? = "тут ноль",
    open var quantity: Int? = 0,
    open var type: BookType? = BookType.PHYSICAL_BOOK
)
