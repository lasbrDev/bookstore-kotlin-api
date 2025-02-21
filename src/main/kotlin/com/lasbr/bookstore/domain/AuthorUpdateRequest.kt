package com.lasbr.bookstore.domain

data class AuthorUpdateRequest(
    val id: Int?,
    val name: String?,
    val age: Int?,
    val description: String?,
    val image: String?
)