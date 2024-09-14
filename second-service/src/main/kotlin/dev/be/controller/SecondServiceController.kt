package dev.be.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/second-service")
class SecondServiceController {

    @GetMapping("/welcome")
    fun welcome(): String {
        return "welcome to the Second Service"
    }


    @GetMapping("/message")
    fun message(@RequestHeader(required = false , name = "second-service") header : String?): String {
        println("header ${header}")
        return "Message from Second service"
    }
}