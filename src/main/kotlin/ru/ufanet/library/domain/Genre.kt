package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import ru.ufanet.library.repository.GenreRepository
import javax.persistence.*

@Entity
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])

data class Genre(
    @Column(nullable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = "",

)

