package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import ru.ufanet.library.domain.enum.Rating
import javax.persistence.*

@Entity
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])
data class Comment(
    @Column(nullable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long = 0,
    @OneToOne(fetch = FetchType.LAZY)
     var paperBook: PaperBook,
    @OneToOne(fetch = FetchType.LAZY)
     var user: CorpUser,
    var rating: Rating,
    var feedback: String = ""
)
