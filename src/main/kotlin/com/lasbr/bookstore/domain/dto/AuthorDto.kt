package com.lasbr.bookstore.domain.dto

data class AuthorDto(
    var id: Int?,
    var name: String,
    var age: Int,
    var description: String,
    var image: String
)