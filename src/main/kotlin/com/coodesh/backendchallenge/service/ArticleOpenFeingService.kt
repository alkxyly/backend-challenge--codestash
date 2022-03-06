package com.coodesh.backendchallenge.service

import com.coodesh.backendchallenge.model.Article
import com.coodesh.backendchallenge.model.ArticleDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(url= "https://api.spaceflightnewsapi.net/v3" , name = "articles")
interface ArticleOpenFeingService {

    @GetMapping("/articles/count")
    fun getCount(): Long

    @GetMapping("/articles")
    fun findAll(@RequestParam("_limit") limit: Long, @RequestParam("_start") start: Long): List<ArticleDTO>
}