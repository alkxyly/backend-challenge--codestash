package com.coodesh.backendchallenge.controller

import  io.restassured.RestAssured
import io.restassured.http.ContentType
import org.hamcrest.core.IsEqual
import org.hamcrest.core.IsNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArticlesControllerTestIT{

    @LocalServerPort
    private var port: Int = 0

    @BeforeEach
    fun setup(){
        RestAssured.port = port
    }

    @Test
    fun createArticle(){
        val createArticleJSON = """ 
            {
                    "featured": false,
                    "title": "TITLE TEST",
                    "url": "URL TEST",
                    "newsSite": "ESA",
                    "summary": "SUMMARY TEST",
                    "publishedAt": "2022-02-28T14:00:00.000Z"
            }            
        """.trimIndent()

        RestAssured.given()
            .contentType(ContentType.JSON)
            .body(createArticleJSON)
            .post("/articles")
            .then()
            .statusCode(HttpStatus.CREATED.value())
            .body("id", IsNull.notNullValue())
            .body("featured", IsEqual.equalTo(false))
            .body("title", IsEqual.equalTo("TITLE TEST"))
            .body("url", IsEqual.equalTo("URL TEST"))
    }
}