package com.axis.customer.service

import com.axis.customer.entity.Customer
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CustomerService {
    fun findById(mobileNo: Long): Mono<Customer>
    fun findAll(): Flux<Customer>
    fun save(customer: Customer): Mono<Customer>
    fun update(customer: Customer): Mono<Customer>
    fun deleteById(mobileNo: Long): Mono<Void>
}
