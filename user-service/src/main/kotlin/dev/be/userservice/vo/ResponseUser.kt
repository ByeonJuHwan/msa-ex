package dev.be.userservice.vo

import com.fasterxml.jackson.annotation.JsonInclude
import dev.be.userservice.dto.UserDto
import dev.be.userservice.jpa.UserEntity

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ResponseUser (
    val email: String,
    val name: String,
    val userId : String,

    val orders : List<ResponseOrder>?,
) {
    companion object {
        fun of(createUser: UserDto) : ResponseUser {
            return ResponseUser(createUser.email, createUser.name, createUser.userId, null)
        }

        fun of(userEntity: UserEntity) : ResponseUser {
            return ResponseUser(userEntity.email, userEntity.name, userEntity.userId, null)
        }
    }
}