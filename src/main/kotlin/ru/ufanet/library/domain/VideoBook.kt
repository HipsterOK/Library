package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@DiscriminatorValue("VIDEO_BOOK")
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])
class VideoBook(
    @Column(nullable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Long = 0,
    override var title: String,
    override var description: String = "",
    @OneToOne(fetch = FetchType.LAZY)
    override var genre: Genre,
    override var link: String = ""):
    AbstractBook()