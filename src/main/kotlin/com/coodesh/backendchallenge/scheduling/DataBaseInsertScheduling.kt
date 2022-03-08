package com.coodesh.backendchallenge.scheduling

import com.coodesh.backendchallenge.model.Article
import com.coodesh.backendchallenge.model.ArticleDTO
import com.coodesh.backendchallenge.model.Control
import com.coodesh.backendchallenge.repository.ControlRepository
import com.coodesh.backendchallenge.service.ArticleOpenFeingService
import com.coodesh.backendchallenge.service.ArticleService
import com.coodesh.backendchallenge.service.ControlService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Component
class DataBaseInsertScheduling(
    val articleFeingService: ArticleOpenFeingService,
    val articleService: ArticleService,
    val controlService: ControlService) {

     @Scheduled(cron = "1 * * * * *", zone = "America/Sao_Paulo")
    fun start() {
        /**
         * Busca a quantidade total de elementos
         * Verifica se a quantidade total de elementos cadastrado é igual ao que está vindo da API externa
         * Se a quantidade cadastrada no banco for menor do que a que ta vindo da api
         *     Obtém a página que está
         *     Salva os objetos
         *     Atualiza a tabela de controle com o campo page + limit
         * Se for maior existem novos registros
         * Se for igual o banco está completamente atualizado
         */
        val count: Long = articleFeingService.getCount()
        val control: Control = controlService.findById(1L).get()

         if(count > control.total){
             saveListFromLimitAndStart(control.limite, control.page)
             controlService.updateControl(control)
         }


        println(control.toString())


        //val limit: Long = 100
        //val pageCount = if (count > limit) count / limit else limit
        //saveListFromLimitAndStart(limit = 50, start = 0)
    }


    @Transactional
    fun saveListFromLimitAndStart(limit: Long, start: Long) {
        val list: List<ArticleDTO> = articleFeingService.findAll(limit, start)
        if (list.isNotEmpty()) {
            list.map { it ->
                Article(
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