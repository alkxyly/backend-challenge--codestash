package com.coodesh.backendchallenge.repository

import com.coodesh.backendchallenge.model.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository :  JpaRepository<Article, Long> {
}