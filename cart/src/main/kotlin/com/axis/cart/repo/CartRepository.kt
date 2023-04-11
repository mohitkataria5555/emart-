package com.axis.cart.repo


import com.axis.cart.entity.Cart
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository


@Repository
interface CartRepository : ReactiveMongoRepository<Cart, Long>
