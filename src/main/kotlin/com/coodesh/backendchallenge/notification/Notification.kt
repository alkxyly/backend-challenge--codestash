package com.coodesh.backendchallenge.notification

interface Notification {
    fun sendMessage(from: String, to: String, body: String)
}