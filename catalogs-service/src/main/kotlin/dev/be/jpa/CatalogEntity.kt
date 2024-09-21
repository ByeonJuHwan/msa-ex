package dev.be.jpa

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable
import java.time.LocalDateTime

@Entity
@Table(name = "catalog")
class CatalogEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true, length = 120)
    val productId: String,

    @Column(nullable = false)
    val productName: String,

    @Column(nullable = false)
    val stock : Int,

    @Column(nullable = false)
    val unitPrice : Int,

    val createdAt : LocalDateTime = LocalDateTime.now(),
    ) : Serializable {


}