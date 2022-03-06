package com.coodesh.backendchallenge.controller

import com.coodesh.backendchallenge.service.ArticleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ArticlesController(val articleService: ArticleService) {

    @GetMapping
    fun backendChallenge() = ResponseEntity.ok("Back-end Challenge 2021 \uD83C\uDFC5 - Space Flight News")

    @GetMapping("/articles")
    fun findAll() = ResponseEntity.ok(this.articleService.findAll())

    @GetMapping("{id")
    fun findById(@PathVariable id: Long) = ResponseEntity.ok(articleService.findById(id))
}