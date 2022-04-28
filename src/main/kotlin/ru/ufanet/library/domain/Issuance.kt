package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.Date
import javax.persistence.*

@Entity
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])
data class Issuance(
    @Column(nullable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @OneToOne(fetch = FetchType.LAZY)
    val bookCopy: BookCopy,
    @OneToOne(fetch = FetchType.LAZY)
    val user: CorpUser,
    val isFinished: Boolean,
    val startDate:Date,
    val endDate:Date
)

