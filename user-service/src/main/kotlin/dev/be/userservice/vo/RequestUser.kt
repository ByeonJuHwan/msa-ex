package dev.be.userservice.vo

import dev.be.userservice.dto.UserDto
import java.time.LocalDateTime

data class RequestUser (
    val email : String,
    val name : String,
    val pwd : String,
)

fun RequestUser.toDto() : UserDto = UserDto(
    email = email,
    name = name,
    pwd = pwd,
    userId = "초기값",
    createdAt = LocalDateTime.now(),
    encryptedPwd = "초기값",
    orders = null,
)
