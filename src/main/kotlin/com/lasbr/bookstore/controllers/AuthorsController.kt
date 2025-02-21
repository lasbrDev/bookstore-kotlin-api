package com.lasbr.bookstore.controllers

import com.lasbr.bookstore.domain.dto.AuthorDto
import com.lasbr.bookstore.domain.dto.AuthorUpdateRequestDto
import com.lasbr.bookstore.services.AuthorService
import com.lasbr.bookstore.toAuthorDto
import com.lasbr.bookstore.toAuthorEntity
import com.lasbr.bookstore.toAuthorUpdateRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/authors")
class AuthorsController(private val authorService: AuthorService) {

    @PostMapping
    fun createAuthor(@RequestBody authorDto: AuthorDto): ResponseEntity<AuthorDto> {
        return try {
            val createdAuthor = authorService.create(
                authorDto.toAuthorEntity()
            ).toAuthorDto()
            ResponseEntity(createdAuthor, HttpStatus.CREATED)
        } catch (ex: IllegalArgumentException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping
    fun readManyAuthor(): List<AuthorDto> {
        return authorService.list().map { it.toAuthorDto() }

    }

    @GetMapping(path = ["/{id}"])
    fun readOneAuthor(@PathVariable id: Int): ResponseEntity<AuthorDto> {
        val foundAuthor = authorService.get(id)?.toAuthorDto()
        return foundAuthor?.let {
            ResponseEntity(it, HttpStatus.OK)
        } ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PutMapping(path = ["/{id}"])
    fun fullUpdateAuthor(@PathVariable("id") id: Int, @RequestBody authorDto: AuthorDto): ResponseEntity<AuthorDto> {
        return try {
            val updateAuthor = authorService.fullUpdate(id, authorDto.toAuthorEntity())
            ResponseEntity(updateAuthor.toAuthorDto(), HttpStatus.OK)
        } catch (ex: IllegalStateException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @PatchMapping(path = ["/{id}"])
    fun partialUpdateAuthor(
        @PathVariable("id") id: Int,
        @RequestBody authorUpdateRequest: AuthorUpdateRequestDto): ResponseEntity<AuthorDto> {
        return try {
            val updateAuthor = authorService.partialUpdate(id, authorUpdateRequest.toAuthorUpdateRequest())
            ResponseEntity(updateAuthor.toAuthorDto(), HttpStatus.OK)
        } catch (ex: IllegalStateException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }
}