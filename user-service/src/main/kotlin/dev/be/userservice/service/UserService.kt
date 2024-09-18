package dev.be.userservice.service

import dev.be.userservice.dto.UserDto
import dev.be.userservice.jpa.UserEntity

interface UserService {
    fun createUser(userDto: UserDto) : UserDto
    fun getUserByUserId (userId: String): UserDto
    fun getUserByAll() : Iterable<UserEntity>
}