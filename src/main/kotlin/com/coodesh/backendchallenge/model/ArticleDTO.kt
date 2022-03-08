package com.coodesh.backendchallenge.model

data class ArticleDTO(
    var id: Long? = null,
    val featured: Boolean,
    val title: String,
    val url: String,
    val newsSite: String,
    val summary: String,
    val publishedAt: String,
    var lauches: ArrayList<Lauch> = ArrayList<Lauch>(),
    var events: ArrayList<Event> = ArrayList<Event>()
)