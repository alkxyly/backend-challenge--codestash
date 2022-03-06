package com.coodesh.backendchallenge.controller

import com.coodesh.backendchallenge.model.Article
import com.coodesh.backendchallenge.service.ArticleService
import feign.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ArticlesController(val articleService: ArticleService) {

    @GetMapping
    fun backendChallenge() = ResponseEntity.ok("Back-end Challenge 2021 \uD83C\uDFC5 - Space Flight News")

    @GetMapping("/articles")
    fun findAll() = ResponseEntity.ok(this.articleService.findAll())

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long) = ResponseEntity.ok(articleService.findById(id))

    @PostMapping("/articles")
    @ResponseStatus(code = HttpStatus.CREATED)
    fun save(@RequestBody article: Article): Article = this.articleService.save(article)

    @PutMapping("/{id}/articles")
    @ResponseStatus(code = HttpStatus.OK)
    fun update(@PathVariable id: Long, @RequestBody article: Article): Article = this.articleService.update(id, article)
}