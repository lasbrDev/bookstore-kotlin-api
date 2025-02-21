package com.lasbr.bookstore.domain.dto

data class AuthorUpdateRequestDto(
    val id: Int?,
    val name: String?,
    val age: Int?,
    val description: String?,
    val image: String?
)