package com.lasbr.bookstore

import com.lasbr.bookstore.domain.dto.AuthorDto

fun testAuthorDtoA(id: Int? = null) = AuthorDto(
    id = id,
    name = "John Doe",
    age = 30,
    description = "Some Description",
    image = "author-image.jpeg"
)