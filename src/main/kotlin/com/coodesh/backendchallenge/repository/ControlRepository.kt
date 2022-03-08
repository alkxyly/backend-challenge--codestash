package com.coodesh.backendchallenge.repository

import com.coodesh.backendchallenge.model.Control
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ControlRepository : JpaRepository<Control, Long> {
}