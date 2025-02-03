package com.lasbr.bookstore.repositories

import com.lasbr.bookstore.domain.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, String>