package com.coodesh.backendchallenge.controller

import com.coodesh.backendchallenge.model.Article
import com.coodesh.backendchallenge.service.ArticleService
import feign.Response
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ArticlesController(val articleService: ArticleService) {

    companion object { private const val PAGE_SIZE: Int = 20 }

    @GetMapping
    fun backendChallenge() = ResponseEntity.ok("Back-end Challenge 2021 \uD83C\uDFC5 - Space Flight News")

    @GetMapping("/articles")
    fun findAll(@PageableDefault(size = 10) pageable: Pageable): Page<Article>{
        val page: Page<Article> = this.articleService.findAll(pageable)
        return PageImpl(page.content, pageable, page.totalElements)
    }

    @GetMapping("/articles/{id}")
    fun findById(@PathVariable id: Long) : ResponseEntity<Any>{
        try {
           val article: Article = articleService.findById(id)
           return ResponseEntity.ok(article)
        }catch (e: RuntimeException){
           return  ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/articles")
    @ResponseStatus(code = HttpStatus.CREATED)
    fun save(@RequestBody article: Article): Article = this.articleService.save(article)

    @PutMapping("/articles/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    fun update(@PathVariable id: Long, @RequestBody article: Article): Article = this.articleService.update(id, article)

    @DeleteMapping("/articles/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) { this.articleService.delete(id); }
}