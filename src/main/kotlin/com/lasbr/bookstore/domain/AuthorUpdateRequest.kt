package com.lasbr.bookstore.domain

data class AuthorUpdateRequest(
    val id: Int? = null,
    val name: String? = null,
    val age: Int? = null,
    val description: String? = null,
    val image: String? = null
)