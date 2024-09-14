package dev.be.userservice.service

import dev.be.userservice.dto.UserDto
import dev.be.userservice.dto.toEntity
import dev.be.userservice.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class UserServiceImpl (
    private val userRepository: UserRepository,
) : UserService {

    @Transactional
    override fun createUser(userDto: UserDto): UserDto {
        userDto.userId = UUID.randomUUID().toString()
        userRepository.save(userDto.toEntity())
        return userDto
    }
}