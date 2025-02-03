package com.lasbr.bookstore.domain

import jakarta.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id
    @Column(name = "isbn", length = 19)
    var isbn: String,

    @Column(name="title")
    var title: String,

    @Column(name="description")
    var description: String,

    @Column(name="image")
    var image: String,

    @ManyToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "author_id")
    var author: Author?
)
