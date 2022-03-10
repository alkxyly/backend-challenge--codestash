package com.coodesh.backendchallenge.service

import com.coodesh.backendchallenge.model.Article
import com.coodesh.backendchallenge.model.ArticleDTO
import com.coodesh.backendchallenge.scheduling.JobScheduler
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ArticleJobService (
    val articleOpenFeingService: ArticleOpenFeingService,
    val articleService: ArticleService,
    val controlService: ControlService): JobScheduler{

    override fun run() {
        val count: Long = articleOpenFeingService.getCount()
        controlService.findById(1L)
            .ifPresent {
                if(count > it.total ){
                    saveArticlesFromLimitAndStart(it.limite, it.page)
                    controlService.updateControl(it)
                    println(it.toString())
                }else
                    println("Data Base updated with API")
            }
    }

    @Transactional
    fun saveArticlesFromLimitAndStart(limit: Long, start: Long) {
        val list: List<ArticleDTO> = articleOpenFeingService.findAll(limit, start)
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