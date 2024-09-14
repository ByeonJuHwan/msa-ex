package dev.be.userservice.jpa

import jakarta.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false, unique = true)
    val userId : String,

    @Column(nullable = false, unique = true)
    val encryptedPwd : String,
) {
}