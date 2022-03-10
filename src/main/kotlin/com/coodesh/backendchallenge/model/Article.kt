package com.coodesh.backendchallenge.model


import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "db_articles")
data class Article(
    @Id
    @GeneratedValue
    @JsonIgnore
    var id: Long? = null,

    @JsonProperty("id")
    var idArticle: Long? = null,
    val featured: Boolean = false,
    val title: String = "",
    val url: String = "",
    val newsSite: String = "",

    @Column(length = 5000)
    val summary: String = "",
    val publishedAt: String = ""
)