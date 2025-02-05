package com.lasbr.bookstore

import com.lasbr.bookstore.domain.dto.AuthorDto
import com.lasbr.bookstore.domain.entities.AuthorEntity

fun testAuthorDtoA(id: Int? = null) = AuthorDto(
    id = id,
    name = "John Doe",
    age = 30,
    description = "Some Description",
    image = "author-image.jpeg"
)

fun testAuthorEntityA(id: Int? = null) = AuthorEntity(
    id = id,
    name = "John Doe",
    age = 30,
    description = "Some Description",
    image = "author-image.jpeg"
)