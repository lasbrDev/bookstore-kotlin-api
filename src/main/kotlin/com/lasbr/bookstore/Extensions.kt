package com.lasbr.bookstore

import com.lasbr.bookstore.domain.AuthorUpdateRequest
import com.lasbr.bookstore.domain.dto.AuthorDto
import com.lasbr.bookstore.domain.dto.AuthorSummaryDto
import com.lasbr.bookstore.domain.dto.AuthorUpdateRequestDto
import com.lasbr.bookstore.domain.dto.BookSummaryDto
import com.lasbr.bookstore.domain.entities.AuthorEntity
import com.lasbr.bookstore.domain.entities.AuthorSummary
import com.lasbr.bookstore.domain.entities.BookEntity
import com.lasbr.bookstore.domain.entities.BookSummary
import com.lasbr.bookstore.exceptions.InvalidAuthorException

fun AuthorEntity.toAuthorDto() = AuthorDto(
    id = this.id,
    name = this.name,
    age = this.age,
    description = this.description,
    image = this.image,
)

fun AuthorEntity.toAuthorSummaryDto(): AuthorSummaryDto{
    val authorId = this.id ?: throw InvalidAuthorException()
    return AuthorSummaryDto(
        id = authorId,
        name = this.name,
        image = this.image,
    )
}


fun AuthorDto.toAuthorEntity() = AuthorEntity(
    id = this.id,
    name = this.name,
    age = this.age,
    description = this.description,
    image = this.image,
)

fun AuthorUpdateRequestDto.toAuthorUpdateRequest() = AuthorUpdateRequest(
    id = this.id,
    name = this.name,
    age = this.age,
    description = this.description,
    image = this.image,
)

fun BookSummary.toBookEntity(author: AuthorEntity) = BookEntity(
    isbn = this.isbn,
    title = this.title,
    description = this.description,
    image = this.image,
    authorEntity = author
)

fun AuthorSummaryDto.toAuthorSummary() = AuthorSummary(
    id = this.id,
    name = this.name,
    image = this.image,
)

fun BookSummaryDto.toBookSummary() = BookSummary(
    isbn = isbn,
    title = this.title,
    description = this.description,
    image = this.image,
    author = this.author.toAuthorSummary()
)

fun BookEntity.toBookSummaryDto() = BookSummaryDto(
    isbn = this.isbn,
    title = this.title,
    description = this.description,
    image = this.image,
    author = authorEntity.toAuthorSummaryDto()
)