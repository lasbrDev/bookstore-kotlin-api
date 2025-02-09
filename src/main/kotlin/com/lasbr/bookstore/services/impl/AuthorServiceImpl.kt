package com.lasbr.bookstore.services.impl

import com.lasbr.bookstore.domain.entities.AuthorEntity
import com.lasbr.bookstore.repositories.AuthorRepository
import com.lasbr.bookstore.services.AuthorService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(private val authorRepository: AuthorRepository): AuthorService {
    override fun save(authorEntity: AuthorEntity): AuthorEntity {
        return authorRepository.save(authorEntity)
    }

    override fun list(): List<AuthorEntity> {
        return authorRepository.findAll()
    }

    override fun get(id: Int): AuthorEntity? {
        return authorRepository.findByIdOrNull(id)
    }
}