package dev.be.userservice.vo

import java.time.LocalDateTime

data class ResponseOrder(
    val productId : String,
    val qty : Int,
    val unitPrice : Int,
    val totalPrice : Int,
    val createdAt : LocalDateTime,
    val orderId : String,
)
