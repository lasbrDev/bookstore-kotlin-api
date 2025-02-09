package com.lasbr.bookstore.services

import com.lasbr.bookstore.domain.entities.AuthorEntity

interface AuthorService {
    fun save(authorEntity: AuthorEntity): AuthorEntity
    fun list(): List<AuthorEntity>
    fun get(id: Int): AuthorEntity?
}