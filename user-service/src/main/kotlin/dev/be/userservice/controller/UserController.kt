package dev.be.userservice.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @Value("\${greeting.message}")
    private lateinit var message: String

    @GetMapping("/heath_check")
    fun status(): String {
        return message
    }
}