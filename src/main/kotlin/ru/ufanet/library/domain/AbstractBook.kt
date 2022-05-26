package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import org.hibernate.annotations.Type
import ru.ufanet.library.domain.enum.BookType
import javax.persistence.*

@Entity()
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="book_type",
    discriminatorType = DiscriminatorType.STRING)
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type", visible = true)
@JsonSubTypes(
    JsonSubTypes.Type(value = PaperBook::class, name = "physical"),
    JsonSubTypes.Type(value = VideoBook::class, name = "video"),
    JsonSubTypes.Type(value = AudioBook::class, name = "audio"))
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