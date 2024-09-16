package dev.be.userservice.controller

import dev.be.userservice.service.UserService
import dev.be.userservice.vo.RequestUser
import dev.be.userservice.vo.ResponseUser
import dev.be.userservice.vo.toDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user-service")
class UserController (
    private val userService: UserService,
) {

    @GetMapping("/heath_check")
    fun status(): String {
        return "It's Working in User Service on PORT"
    }

    @PostMapping("/users")
    fun createUser(@RequestBody user: RequestUser): ResponseEntity<ResponseUser> {
        val createUser = userService.createUser(user.toDto())
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseUser.of(createUser))
    }
}