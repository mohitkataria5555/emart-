package com.axis.cart.service

import com.axis.cart.entity.Cart

import com.axis.cart.repo.CartRepository
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono




@Service
class CartServiceImpl(@Autowired private val cartRepository: CartRepository) : CartService {
    override fun getCartById(mobileNo: Long): Mono<Cart> {
        return cartRepository.findById(mobileNo)
    }

    override fun getAllCarts(): Flux<Cart> {
        return cartRepository.findAll()
    }

    override fun saveCart(cart: Cart): Mono<Cart> {
        return cartRepository.save(cart)
    }

    override fun deleteCart(mobileNo: Long): Mono<Void> {
        return cartRepository.deleteById(mobileNo)
    }



    override fun updateCart(mobileNo: Long, cart: Cart): Mono<Cart> {
        return cartRepository.findById(mobileNo)
            .flatMap { existingCart ->
                // Update the fields of the existing cart with the values from the new cart
                 var name = cart.getName()
                 var price = cart.getPrice()
               val quantity = cart.getQuantity()
             val totalPrice = cart.getTotalPrice()
               val imageUrl = cart.getImageUrl()

                // Save the updated cart to the repository
                cartRepository.save(existingCart)
            }
    }
}

