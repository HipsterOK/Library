package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.Date
import javax.persistence.*

@Entity
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])
data class Issuance(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @OneToOne(fetch = FetchType.LAZY)
    val bookId: Book,
    @OneToOne(fetch = FetchType.LAZY)
    val userId: CorpUser,
    val startDate:Date,
    val endDate:Date,
    val rating: Int,
    val feedback: String
)

