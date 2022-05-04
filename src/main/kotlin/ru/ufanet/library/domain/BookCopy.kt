package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.Date
import javax.persistence.*

@Entity
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])
data class BookCopy(
    @Column(nullable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     var id: Long = 0,
    @OneToOne(fetch = FetchType.LAZY)
    var paperBook: PaperBook,
    var code: String = "",
    var date: Date = Date(),
    @OneToOne(fetch = FetchType.LAZY)
    var lib: LibraryOffice,
    var quantity: Long = 0
)
