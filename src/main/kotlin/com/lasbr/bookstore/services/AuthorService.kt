package com.lasbr.bookstore.services

import com.lasbr.bookstore.domain.dto.AuthorDto
import com.lasbr.bookstore.domain.entities.AuthorEntity

interface AuthorService {
    fun save(authorEntity: AuthorEntity): AuthorEntity
}