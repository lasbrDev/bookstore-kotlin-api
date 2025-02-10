package com.lasbr.bookstore.services.impl

import com.lasbr.bookstore.domain.entities.AuthorEntity
import com.lasbr.bookstore.repositories.AuthorRepository
import com.lasbr.bookstore.services.AuthorService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthorServiceImpl(private val authorRepository: AuthorRepository): AuthorService {
    override fun create(authorEntity: AuthorEntity): AuthorEntity {
        require(null == authorEntity.id)
        return authorRepository.save(authorEntity)
    }

    override fun list(): List<AuthorEntity> {
        return authorRepository.findAll()
    }

    override fun get(id: Int): AuthorEntity? {
        return authorRepository.findByIdOrNull(id)
    }

    @Transactional
    override fun fullUpdate(id: Int, authorEntity: AuthorEntity): AuthorEntity {
        check(authorRepository.existsById(id)) { "Not found with id: $id" }
        val normalisedAuthor = authorEntity.copy(id = id)
        return authorRepository.save(normalisedAuthor)
    }
}