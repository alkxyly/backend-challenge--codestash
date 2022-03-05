package com.coodesh.backendchallenge.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticlesController {

    @GetMapping
    fun backendChallenge(): ResponseEntity<String>{
        return ResponseEntity.ok("Back-end Challenge 2021 \uD83C\uDFC5 - Space Flight News")
    }

}