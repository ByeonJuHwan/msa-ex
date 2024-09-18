package dev.be.userservice.dto

import dev.be.userservice.jpa.UserEntity
import dev.be.userservice.vo.ResponseOrder
import java.time.LocalDateTime

data class UserDto(
    val email : String,
    val name : String,
    val pwd : String,
    var userId : String,
    val createdAt : LocalDateTime,
    val encryptedPwd : String,
    var orders : List<ResponseOrder>?
) {
    companion object {
        fun fromEntity(userEntity: UserEntity): UserDto {
            return UserDto(
                email = userEntity.email,
                name = userEntity.name,
                userId = userEntity.userId,
                encryptedPwd = userEntity.encryptedPwd,
                pwd = userEntity.encryptedPwd,
                createdAt = LocalDateTime.now(),
                orders = null,
            )
        }
    }
}

fun UserDto.toEntity() : UserEntity = UserEntity(
    email = email,
    name = name,
    userId = userId,
    encryptedPwd = pwd,
)