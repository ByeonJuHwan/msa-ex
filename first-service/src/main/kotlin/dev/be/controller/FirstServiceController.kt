package dev.be.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/first-service")
class FirstServiceController {

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
    fun check () : String {
        return "Hi, there. this is a message from first service"
    }
}