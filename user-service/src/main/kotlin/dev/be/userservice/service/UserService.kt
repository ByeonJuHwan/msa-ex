package dev.be.userservice.service

import dev.be.userservice.dto.UserDto

interface UserService {
    fun createUser(userDto: UserDto) : UserDto
}