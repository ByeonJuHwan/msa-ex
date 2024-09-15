package dev.be.userservice.dto

import dev.be.userservice.jpa.UserEntity
import java.time.LocalDateTime
import java.util.Date

data class UserDto(
    val email : String,
    val name : String,
    val pwd : String,
    var userId : String,
    val createdAt : LocalDateTime,
    val encryptedPwd : String,
)

fun UserDto.toEntity() : UserEntity = UserEntity(
    email = email,
    name = name,
    userId = userId,
    encryptedPwd = pwd,
)
