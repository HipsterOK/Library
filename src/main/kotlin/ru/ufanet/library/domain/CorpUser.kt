package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import ru.ufanet.library.domain.enum.UserRole
import javax.persistence.*

@Entity
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])
data class CorpUser(
    @Column(nullable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val surname: String = "",
    val name: String = "",
    val patronymic: String = "",
    val phone: String = "",
    val role: UserRole = UserRole.ADMIN,
    val login: String = "",
    val password: String = "",
    val tg: String=""
)