package com.coodesh.backendchallenge.repository

import com.coodesh.backendchallenge.model.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ArticleRepository : JpaRepository<Article, Long> {

    fun findByIdArticle(id: Long): Optional<Article>
}