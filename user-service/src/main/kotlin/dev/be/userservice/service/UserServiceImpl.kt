package dev.be.userservice.service

import dev.be.userservice.dto.UserDto
import dev.be.userservice.dto.toEntity
import dev.be.userservice.jpa.UserEntity
import dev.be.userservice.repository.UserRepository
import dev.be.userservice.vo.ResponseOrder
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) : UserService {

    @Transactional
    override fun createUser(userDto: UserDto): UserDto {
        userDto.userId = UUID.randomUUID().toString()

        val userEntity = userDto.toEntity()
        userEntity.encryptedPwd = passwordEncoder.encode(userDto.pwd)
        userRepository.save(userEntity)
        return userDto
    }

    override fun getUserByUserId(userId: String): UserDto {
        val userEntity = userRepository.findByUserId(userId) ?: throw UsernameNotFoundException("User not found with id: $userId")

        val userDto = UserDto.fromEntity(userEntity)

        val orders = Collections.emptyList<ResponseOrder>()
        userDto.orders = orders

        return userDto
    }

    override fun getUserByAll(): Iterable<UserEntity> {
        return userRepository.findAll()
    }
}