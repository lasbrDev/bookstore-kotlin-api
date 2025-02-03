package com.lasbr.bookstore.repositories

import com.lasbr.bookstore.domain.entities.BookEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<BookEntity, String>