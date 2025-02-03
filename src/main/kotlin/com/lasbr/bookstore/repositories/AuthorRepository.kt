package com.lasbr.bookstore.repositories

import com.lasbr.bookstore.domain.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository :JpaRepository<Author, Int?>