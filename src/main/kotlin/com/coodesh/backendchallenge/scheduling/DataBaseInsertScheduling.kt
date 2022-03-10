package com.coodesh.backendchallenge.scheduling

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class DataBaseInsertScheduling(val job: JobScheduler) {

    @Scheduled(cron = "1 * * * * *", zone = "America/Sao_Paulo")
    fun start() {
        job.run()
    }
}