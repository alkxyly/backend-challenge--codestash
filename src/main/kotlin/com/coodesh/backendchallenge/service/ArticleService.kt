package com.coodesh.backendchallenge.service

import com.coodesh.backendchallenge.model.Article
import com.coodesh.backendchallenge.repository.ArticleRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class ArticleService(val articleRepository: ArticleRepository) {

    fun findAll(page: Int, pageSize: Int) = this.articleRepository.findAll(PageRequest.of(page, pageSize)).content

    fun findById(id: Long) = this.articleRepository.findById(id).orElseThrow { RuntimeException("Article not found") }

    fun save(article: Article): Article = this.articleRepository.save(article)

    fun update(id: Long, article: Article): Article {
        val articleFound = findById(id)
        val copyArticle = articleFound.copy(
            featured = article.featured,
            title = article.title,
            url = article.url,
            newsSite = article.newsSite,
            summary = article.summary,
            publishedAt = article.publishedAt
        )
        return this.articleRepository.save(copyArticle)
    }

    fun delete(id: Long) {
        val article: Article = findById(id);
        this.articleRepository.delete(article);
    }


}