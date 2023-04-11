package com.axis.cart.service

import com.axis.cart.entity.Cart


import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface CartService {
    fun getCartById(mobileNo: Long): Mono<Cart>
    fun getAllCarts(): Flux<Cart>
    fun saveCart(cart: Cart): Mono<Cart>
    fun updateCart(mobileNo: Long, cart: Cart): Mono<Cart>
    fun deleteCart(mobileNo: Long): Mono<Void>
}
