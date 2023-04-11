package com.axis.cart.controller

import com.axis.cart.entity.Cart
import com.axis.cart.service.CartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/carts")
class CartController @Autowired constructor(private val cartService: CartService) {

    @GetMapping("/{mobileNo}")
    fun getCartById(@PathVariable mobileNo: Long): Mono<Cart> {
        return cartService.getCartById(mobileNo)
    }

    @GetMapping("/all")
    fun getAllCarts(): Flux<Cart> {
        return cartService.getAllCarts()
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveCart(@RequestBody cart: Cart): Mono<Cart> {
        return cartService.saveCart(cart)
    }

    @DeleteMapping("/delete/{mobileNo}")
    fun deleteCart(@PathVariable mobileNo: Long): Mono<Void> {
        return cartService.deleteCart(mobileNo)
    }
    @PutMapping("/update/{mobileNo}")
    fun updateCart(@PathVariable mobileNo: Long, @RequestBody cart: Cart): Mono<Cart> {
        return cartService.updateCart(mobileNo, cart)
    }
}
