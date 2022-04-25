package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import ru.ufanet.library.domain.enum.UserRole
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])
data class CorpUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val surname: String = "",
    val name: String = "",
    val patronymic: String = "",
    val role: UserRole = UserRole.ADMIN,
    val login: String = "",
    val password: String = "",
    val tg: String=""
)