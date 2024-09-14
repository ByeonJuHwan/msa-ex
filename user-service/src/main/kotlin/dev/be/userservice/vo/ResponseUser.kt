package dev.be.userservice.vo

import dev.be.userservice.dto.UserDto

data class ResponseUser (
    val email: String,
    val name: String,
    val userId : String,
) {
    companion object {
        fun of(createUser: UserDto) : ResponseUser {
            return ResponseUser(createUser.email, createUser.name, createUser.userId)
        }
    }
}