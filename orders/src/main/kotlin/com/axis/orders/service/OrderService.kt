package com.axis.orders.service

import com.axis.orders.entity.Order
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface OrderService {
    fun findById(mobileNo: Long): Mono<Order>
    fun findAll(): Flux<Order>

    fun create(order: Order): Mono<Order>

    fun deleteById(mobileNo: Long): Mono<Void>
    fun deleteAll(): Mono<Void>
}