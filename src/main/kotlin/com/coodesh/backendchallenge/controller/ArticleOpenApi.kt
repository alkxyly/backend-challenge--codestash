package com.coodesh.backendchallenge.controller

import com.coodesh.backendchallenge.model.Article
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity


interface ArticleOpenApi {

    @Operation(summary = "Boas Vindas")
    @ApiResponse(responseCode = "200", description = "Mensagem de boas vindas")
    fun backendChallenge(): ResponseEntity<String>

    @Operation(summary = "Buscar artigo por Id")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "Artigo com o id informado encotrado",
            content = [
                Content(mediaType = "application/json", schema = Schema(implementation = Article::class))
        ]),
        ApiResponse(responseCode = "404", description = "Artigo com o id informado não encontrado")
    )
    fun findById(@Parameter(description = "ID do artigo") id: Long) : ResponseEntity<Any>
}
