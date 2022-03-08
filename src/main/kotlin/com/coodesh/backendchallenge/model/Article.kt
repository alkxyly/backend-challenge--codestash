package com.coodesh.backendchallenge.model

import javax.persistence.*

@Entity
@Table(name = "db_articles")
data class Article(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var idArticle: Long? = null,
    val featured: Boolean = false,
    val title: String = "",
    val url: String = "",
    val newsSite: String = "",
    @Column(length = 5000)
    val summary: String = "",
    val publishedAt: String = ""
)