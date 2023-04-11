package com.axis.customer.controller

import com.axis.customer.entity.Customer
import com.axis.customer.service.CustomerService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/customers")
class CustomerController(private val customerService: CustomerService) {
    @GetMapping("/{mobileNo}")
    fun findById(@PathVariable mobileNo: Long): Mono<Customer> {
        return customerService.findById(mobileNo)
    }

    @GetMapping("/all")
    fun findAll(): Flux<Customer> {
        return customerService.findAll()
    }



    @PostMapping("/add")
    fun save(@RequestBody customer: Customer): Mono<Customer> {
        return customerService.save(customer)
    }


    @DeleteMapping("/delete/{mobileNo}")
    fun deleteById(@PathVariable mobileNo: Long): Mono<Void> {
        return customerService.deleteById(mobileNo)
    }
}
