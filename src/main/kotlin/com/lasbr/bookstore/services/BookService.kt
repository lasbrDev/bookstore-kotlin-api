package com.lasbr.bookstore.services

import com.lasbr.bookstore.domain.entities.BookEntity
import com.lasbr.bookstore.domain.entities.BookSummary

interface BookService {
    fun createUpdate(isbn: String, bookSummary: BookSummary): Pair<BookEntity, Boolean>


}