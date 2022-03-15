package com.coodesh.backendchallenge.controller

import  io.restassured.RestAssured
import io.restassured.http.ContentType
import org.assertj.core.api.HamcrestCondition
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
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
        RestAssured.port = port
        RestAssured.basePath = "/articles"
    }

    @Test
    fun whenCreateThenReturnSuccess(){
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

    @Test
    fun whenFindByIdThenReturnSuccess(){
        RestAssured.given()
                .pathParam("id", 14185)
                .accept(ContentType.JSON)
            .`when`()
                .get("/{id}")
            .then()
                .statusCode(HttpStatus.OK.value())
                .body("title", IsEqual.equalTo("UK bans space-related exports to Russia"))
    }

    @Test
    fun whenFindByIdThenReturnStatus404(){
        RestAssured.given()
                .pathParam("id", -1)
                .accept(ContentType.JSON)
            .`when`()
                .get("/{id}")
            .then()
                .statusCode(HttpStatus.NOT_FOUND.value())
    }

    @Test
    fun whenFindAllThenReturnSuccess(){
        RestAssured.given()
                .accept(ContentType.JSON)
            .`when`()
                .get()
            .then()
                 .statusCode(HttpStatus.OK.value())
    }
}