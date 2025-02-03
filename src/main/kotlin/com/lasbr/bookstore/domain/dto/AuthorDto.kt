package com.lasbr.bookstore.domain.dto

import jakarta.persistence.*

data class AuthorDto(
    var id: Int?,
    var name: String,
    var age: Int,
    var description: String,
    var image: String
)