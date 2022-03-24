package com.coodesh.backendchallenge.service

import com.coodesh.backendchallenge.core.circuitbreaker.CircuitBreakerConfig
import com.coodesh.backendchallenge.model.Article
import com.coodesh.backendchallenge.model.ArticleDTO
import com.coodesh.backendchallenge.notification.Notification
import com.coodesh.backendchallenge.scheduling.JobScheduler
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ArticleJobService (
    val articleOpenFeingService: ArticleOpenFeingService,
    val articleService: ArticleService,
    val controlService: ControlService,
    val notification: Notification): JobScheduler{

    private val logger: Logger = LoggerFactory.getLogger(ArticleJobService::class.java)

    @CircuitBreaker(name = "articleCB", fallbackMethod = "runWithNotification")
    override fun run() {
        val count: Long = articleOpenFeingService.getCount()
        controlService.findById(1L)
            .ifPresent {
                if(count > it.total ){
                    saveArticlesFromLimitAndStart(it.limite, it.page)
                    controlService.updateControl(it)
                    logger.info("saving article $it")
                }else
                    logger.info("Database updated")
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

    fun runWithNotification(e: RuntimeException){
        logger.info("Sending notification")
        notification.sendMessage("+14155238886","+557996568448","A API externa para consultar artigos está indisponível")
    }
}