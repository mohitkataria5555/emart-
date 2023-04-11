package com.axis.orders.service

import com.axis.orders.entity.Order
import com.axis.orders.repository.OrderRepository

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class OrderServiceImpl(val repository: OrderRepository) : OrderService {

    override fun findById(mobileNo: Long): Mono<Order> {
        return repository.findById(mobileNo)
    }

    override fun findAll(): Flux<Order> {
        return repository.findAll()
    }



    override fun create(order: Order): Mono<Order> {
        return repository.save(order)
    }



    override fun deleteById(mobileNo: Long): Mono<Void> {
        return repository.deleteById(mobileNo)
    }

    override fun deleteAll(): Mono<Void> {
        return repository.deleteAll()
    }
}
