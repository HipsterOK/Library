package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])

data class LibraryOffice(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = "",
    val city: String,
    val adress: String

)

