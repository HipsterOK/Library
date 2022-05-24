package ru.ufanet.library.domain.utility


import java.util.*

data class Debtor(
        val userFullName: String,
        val userPhone: String,
        val bookTitle: String,
        val bookAuthorFullName: String,
        val deliveryDate: String
)