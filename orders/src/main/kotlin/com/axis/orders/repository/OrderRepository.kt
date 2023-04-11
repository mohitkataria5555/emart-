package com.axis.orders.repository

import com.axis.orders.entity.Order
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux


@Repository
interface OrderRepository : ReactiveMongoRepository<Order, Long> {

}