package com.coodesh.backendchallenge.scheduling

import com.coodesh.backendchallenge.model.Article
import com.coodesh.backendchallenge.model.ArticleDTO
import com.coodesh.backendchallenge.service.ArticleOpenFeingService
import com.coodesh.backendchallenge.service.ArticleService
import com.coodesh.backendchallenge.service.ControlService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
class DataBaseInsertScheduling(
    val articleFeingService: ArticleOpenFeingService,
    val articleService: ArticleService,
    val controlService: ControlService) {

    @Scheduled(cron = "1 * * * * *", zone = "America/Sao_Paulo")
    fun start() {
        val count: Long = articleFeingService.getCount()
        controlService.findById(1L)
            .ifPresent {
                if(count > it.total ){
                    saveArticlesFromLimitAndStart(it.limite, it.page)
                    controlService.updateControl(it)
                    println(it.toString())
                 }
         }
    }

    @Transactional
    fun saveArticlesFromLimitAndStart(limit: Long, start: Long) {
        val list: List<ArticleDTO> = articleFeingService.findAll(limit, start)

        if (list.isNotEmpty()) {
            list.map { it ->
                Article(
                    null,
                    it.id,
                    it.featured,
                    it.title,
                    it.url,
                    it.newsSite,
                    it.summary,
                    it.publishedAt
                )
            }.forEach { this.articleService.save(it) }
        }
    }
}