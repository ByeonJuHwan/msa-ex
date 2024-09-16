package dev.be.userservice.controller

import dev.be.userservice.dto.UserDto
import dev.be.userservice.service.UserService
import dev.be.userservice.vo.RequestUser
import dev.be.userservice.vo.ResponseUser
import dev.be.userservice.vo.toDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController (
    private val userService: UserService,
) {

    @Value("\${local.server.port}")
    private lateinit var portNum : String

    @Value("\${greeting.message}")
    private lateinit var message: String

    @GetMapping("/heath_check")
    fun status(): String {
        return "It's Working in User Service on PORT $portNum"
    }

    @PostMapping("/users")
    fun createUser(@RequestBody user: RequestUser): ResponseEntity<ResponseUser> {
        val createUser = userService.createUser(user.toDto())
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseUser.of(createUser))
    }
}