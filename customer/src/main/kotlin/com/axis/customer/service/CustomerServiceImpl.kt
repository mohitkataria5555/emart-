package com.axis.customer.service

import com.axis.customer.entity.Customer
import com.axis.customer.repo.CustomerRepository

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CustomerServiceImpl(private val customerRepository: CustomerRepository) : CustomerService {
    override fun findById(mobileNo: Long): Mono<Customer> {
        return customerRepository.findById(mobileNo)
    }

    override fun findAll(): Flux<Customer> {
        return customerRepository.findAll()
    }



    override fun save(customer: Customer): Mono<Customer> {
        return customerRepository.save(customer)
    }

    override fun update(customer: Customer): Mono<Customer> {
        return customerRepository.save(customer)
    }

    override fun deleteById(mobileNo: Long): Mono<Void> {
        return customerRepository.deleteById(mobileNo)
    }
}
