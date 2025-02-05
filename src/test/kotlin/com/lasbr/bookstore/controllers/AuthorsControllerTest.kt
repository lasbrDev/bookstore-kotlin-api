package com.lasbr.bookstore.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.lasbr.bookstore.domain.dto.AuthorDto
import com.lasbr.bookstore.domain.entities.AuthorEntity
import com.lasbr.bookstore.services.AuthorService
import com.lasbr.bookstore.testAuthorDtoA
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class AuthorsControllerTest @Autowired constructor (
    private val mockMvc: MockMvc,
    @MockkBean val authorService: AuthorService
    ) {

    val objectMapper = ObjectMapper()

    @BeforeEach
    fun beforeEach() {
        every {
            authorService.save(any())
        } answers {
            firstArg()
        }
    }

    @Test
    fun `test that create Author sabes the Author`(){
        mockMvc.post("/authors") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(
                testAuthorDtoA()
            )
        }
        val expected = AuthorEntity(
            id = null,
            name = "John Doe",
            age = 30,
            image = "author-image.jpeg",
            description = "Some Description"
        )
        verify{ authorService.save(expected) }
    }

    @Test
    fun `test that create Author returns a HTTP 201 status on a successful create`() {
        mockMvc.post("/authors") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(
                testAuthorDtoA()
            )
        }.andExpect {
            status { isCreated() }
        }
    }
}