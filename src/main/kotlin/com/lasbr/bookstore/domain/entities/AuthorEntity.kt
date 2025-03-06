package com.lasbr.bookstore.domain.entities

import jakarta.persistence.*

@Entity
@Table(name = "authors")
data class AuthorEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    @SequenceGenerator(name = "author_id_seq", sequenceName = "author_id_seq", allocationSize = 1)
    @Column(name = "id")
    var id: Int?,

    @Column(name = "name")
    var name: String,

    @Column(name="age")
    var age: Int,

    @Column(name="description")
    var description: String,

    @Column(name="image")
    var image: String
)
