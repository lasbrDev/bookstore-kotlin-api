package com.lasbr.bookstore.services.impl

import com.lasbr.bookstore.domain.entities.BookEntity
import com.lasbr.bookstore.domain.entities.BookSummary
import com.lasbr.bookstore.repositories.AuthorRepository
import com.lasbr.bookstore.repositories.BookRepository
import com.lasbr.bookstore.services.BookService
import com.lasbr.bookstore.toBookEntity
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookServiceImpl(
    val bookRepository: BookRepository,
    val authorRepository: AuthorRepository ) : BookService {

    @Transactional
    override fun createUpdate(isbn: String, bookSummary: BookSummary): Pair<BookEntity, Boolean> {
        val normalisedBook = bookSummary.copy(isbn = isbn)
        val isExists = bookRepository.existsById(isbn)

        val author = authorRepository.findByIdOrNull(normalisedBook.author.id)
        checkNotNull(author)

        val savedBook = bookRepository.save(normalisedBook.toBookEntity(author))
        return Pair(savedBook, !isExists)
    }
}