package com.lasbr.bookstore.controllers

import com.lasbr.bookstore.domain.dto.AuthorDto
import com.lasbr.bookstore.services.AuthorService
import com.lasbr.bookstore.toAuthorDto
import com.lasbr.bookstore.toAuthorEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorsController(private val authorService: AuthorService) {

    @PostMapping("/authors")
    fun createAuthor(@RequestBody authorDto: AuthorDto): AuthorDto {
        return authorService.save(
            authorDto.toAuthorEntity()
        ).toAuthorDto()
    }
}