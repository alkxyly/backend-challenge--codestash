package com.coodesh.backendchallenge.scheduling

import com.coodesh.backendchallenge.model.Article
import com.coodesh.backendchallenge.model.ArticleDTO
import com.coodesh.backendchallenge.service.ArticleOpenFeingService
import com.coodesh.backendchallenge.service.ArticleService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class DataBaseInsertScheduling(val articleFeingService: ArticleOpenFeingService, val articleService: ArticleService) {

   // @Scheduled(cron = "1 * * * * *", zone = "America/Sao_Paulo")
    fun start(){
        println("starting job")
        println("get count articles")
        val count: Long = articleFeingService.getCount()
        println("count = "+count)
        val limit: Long = 100
        val pageCount = if (count > limit)  count/limit else limit
        println("page count = "+pageCount)

        saveListFromLimitAndStart(limit = 50,start = 0)

        println("finish job")
    }
    fun getControl() {

    }

    fun saveListFromLimitAndStart(limit: Long, start: Long){
        val list : List<ArticleDTO> = articleFeingService.findAll(limit, start)
        if(list.isNotEmpty()){
            list.map { it -> Article(it.id,
                it.featured,
                it.title,
                it.url,
                it.newsSite,
                it.summary,
                it.publishedAt
            ) }.forEach { this.articleService.save(it) }
        }
    }
}