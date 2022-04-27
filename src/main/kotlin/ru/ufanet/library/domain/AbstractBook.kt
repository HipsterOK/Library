package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import ru.ufanet.library.domain.enum.BookType
import javax.persistence.*

@Entity()
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="book_type",
    discriminatorType = DiscriminatorType.STRING)
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])
abstract class AbstractBook (
    @Column(nullable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var title: String = "",
    var description: String = "",
    @OneToOne(fetch = FetchType.LAZY)
    var genre: Genre = Genre(),
    var link: String = "")