package com.axis.orders.controller


import com.axis.orders.entity.Order
import com.axis.orders.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/orders")
class OrderController(val service: OrderService) {

    @GetMapping("/{mobileNo}")
    fun findById(@PathVariable mobileNo: Long): Mono<Order> {
        return service.findById(mobileNo)
    }

    @GetMapping
    fun findAll(): Flux<Order> {
        return service.findAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody order: Order): Mono<Order> {
        return service.create(order)
    }
    @DeleteMapping("/{mobileNo}")
    fun deleteById(@PathVariable mobileNo: Long): Mono<Void> {
        return service.deleteById(mobileNo)
    }

    @DeleteMapping
    fun deleteAll(): Mono<Void> {
        return service.deleteAll()
    }
}
