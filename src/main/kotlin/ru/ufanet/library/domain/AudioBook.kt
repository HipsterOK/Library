package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@DiscriminatorValue("AUDIO_BOOK")
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])
class AudioBook(
    @Column(nullable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Long = 0,

    @NotNull
    override var title: String,
    override var description: String = "",
    @OneToOne(fetch = FetchType.LAZY)
    override var genre: Genre,
    override var link: String = "",
    var type: String = "audio"):
    AbstractBook(id, title,description,genre,link)