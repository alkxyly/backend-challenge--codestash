package com.coodesh.backendchallenge.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_control")
data class Control(
    @Id
    @GeneratedValue
    var id: Long? = null,
    val limite: Long = 0, var page: Long = 0, var total: Long = 0
)