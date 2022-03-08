package com.coodesh.backendchallenge.service

import com.coodesh.backendchallenge.model.Control
import com.coodesh.backendchallenge.repository.ControlRepository
import org.springframework.stereotype.Service

@Service
class ControlService(val controlRepository: ControlRepository) {

    fun findById(id: Long) = controlRepository.findById(id)

    fun updateControl(control: Control) {
        control.page += control.limite
        control.total += control.limite
        controlRepository.save(control)
    }
}