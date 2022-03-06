package com.coodesh.backendchallenge.service

import com.coodesh.backendchallenge.model.Article
import com.coodesh.backendchallenge.repository.ArticleRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class ArticleService (val articleRepository: ArticleRepository){

    fun save(article: Article){
        this.articleRepository.save(article)
    }

    fun findAll() = this.articleRepository.findAll()

    fun findById(id: Long) = this.articleRepository.findById(id).orElseThrow { RuntimeException("Article not found") }
}