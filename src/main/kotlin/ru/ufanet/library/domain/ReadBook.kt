package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])
data class ReadBook(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @OneToOne(fetch = FetchType.LAZY)
    val bookId: Book,
    @OneToOne(fetch = FetchType.LAZY)
    val userId: CorpUser
)

