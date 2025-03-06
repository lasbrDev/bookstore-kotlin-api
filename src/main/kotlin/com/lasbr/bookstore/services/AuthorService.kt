package com.lasbr.bookstore.services

import com.lasbr.bookstore.domain.AuthorUpdateRequest
import com.lasbr.bookstore.domain.entities.AuthorEntity
import org.springframework.http.ResponseEntity


interface AuthorService {
    fun create(authorEntity: AuthorEntity): AuthorEntity
    fun list(): List<AuthorEntity>
    fun get(id: Int): AuthorEntity?
    fun fullUpdate(id: Int, authorEntity: AuthorEntity): AuthorEntity
    fun partialUpdate(id: Int, authorUpdate: AuthorUpdateRequest): AuthorEntity
    fun delete(id: Int)
}