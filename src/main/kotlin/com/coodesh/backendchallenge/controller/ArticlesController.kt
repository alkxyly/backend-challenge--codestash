package com.coodesh.backendchallenge.controller

import com.coodesh.backendchallenge.model.Article
import com.coodesh.backendchallenge.service.ArticleService
import org.springframework.hateoas.CollectionModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ArticlesController(val articleService: ArticleService) {
    companion object {
        private const val PAGE_SIZE: Int = 20
    }

    @GetMapping
    fun backendChallenge() = ResponseEntity.ok("Back-end Challenge 2021 \uD83C\uDFC5 - Space Flight News")

    @GetMapping("/articles")
    fun findAll(@RequestParam(defaultValue = "0") page: Int) = this.articleService.findAll(page, PAGE_SIZE)

    @GetMapping("/articles/{id}")
    fun findById(@PathVariable id: Long) = ResponseEntity.ok(articleService.findById(id))

    @PostMapping("/articles")
    @ResponseStatus(code = HttpStatus.CREATED)
    fun save(@RequestBody article: Article): Article = this.articleService.save(article)

    @PutMapping("/articles/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    fun update(@PathVariable id: Long, @RequestBody article: Article): Article = this.articleService.update(id, article)

    @DeleteMapping("/articles/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        this.articleService.delete(id);
    }
}