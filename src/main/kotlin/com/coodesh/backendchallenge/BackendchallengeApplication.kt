package com.coodesh.backendchallenge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
class BackendchallengeApplication

fun main(args: Array<String>) {
	runApplication<BackendchallengeApplication>(*args)
}
