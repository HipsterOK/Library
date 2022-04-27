package ru.ufanet.library.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@DiscriminatorValue("VideoBook")
@JsonIgnoreProperties(value = ["hibernateLazyInitializer", "handler"])
class VideoBook(
    @Column(nullable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Long = 0,
    override var name: String,
    override var description: String = "",
    @OneToOne(fetch = FetchType.LAZY)
    override var genre: Genre,
    override var link: String = ""):
    AbstractBook()