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
        return "It's Working in User Service on PORTtest"
    }

    @PostMapping("/users")
    fun createUser(@RequestBody user: RequestUser): ResponseEntity<ResponseUser> {
        val createUser = userService.createUser(user.toDto())
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseUser.of(createUser))
    }

    @GetMapping("/users")
    fun getUsers() : ResponseEntity<List<ResponseUser>> {
        val userList = userService.getUserByAll().map {
            user -> ResponseUser.of(user)
        }

        return ResponseEntity.status(HttpStatus.OK).body(userList)
    }

    @GetMapping("/users/{userId}")
    fun getUser(@PathVariable userId : String) : ResponseEntity<ResponseUser> {
        val userDto = userService.getUserByUserId(userId)
        return ResponseEntity.status(HttpStatus.OK).body(ResponseUser.of(userDto))
    }
}