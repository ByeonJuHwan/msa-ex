package dev.be.controller

import jakarta.servlet.http.HttpServletRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/first-service")
class FirstServiceController {

    private val log: Logger = LoggerFactory.getLogger(FirstServiceController::class.java)

    @GetMapping("/welcome")
    fun welcome(): String {
        return "welcome to the First Service"
    }

    @GetMapping("/message")
    fun message(@RequestHeader(required = false, name = "first-service") header : String?): String {
        println("header ${header}")
        return "Message from FirstService"
    }

    @GetMapping("/check")
    fun check(request: HttpServletRequest): String {
        log.info("Server Port = {}", request.serverPort.toString())
        return "Hi, there. this is a message from first service on Port ${request.serverPort}"
    }
}