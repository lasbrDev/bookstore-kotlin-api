package com.lasbr.bookstore

import com.lasbr.bookstore.domain.AuthorUpdateRequest
import com.lasbr.bookstore.domain.dto.AuthorDto
import com.lasbr.bookstore.domain.dto.AuthorUpdateRequestDto
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

fun testAuthorEntityB(id: Int? = null) = AuthorEntity(
    id = id,
    name = "Don Joe",
    age = 65,
    description = "Some other description",
    image = "some-other-image.jpeg"
)

fun testAuthorUpdateRequestDtoA(id: Int? = null) = AuthorUpdateRequestDto(
    id = id,
    name = "John Doe",
    age = 30,
    description = "Some Description",
    image = "author-image.jpeg"
)

fun testAuthorUpdateRequestA(id: Int? = null) = AuthorUpdateRequest(
    id = id,
    name = "John Doe",
    age = 30,
    description = "Some Description",
    image = "author-image.jpeg"
)