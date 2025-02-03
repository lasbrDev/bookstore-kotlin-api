package com.lasbr.bookstore.controllers

import com.lasbr.bookstore.domain.Author
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorsController {

    @PostMapping("/authors")
    fun createAuthor(@RequestBody author: Author) {

    }
}