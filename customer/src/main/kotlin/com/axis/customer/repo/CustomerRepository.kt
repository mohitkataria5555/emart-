package com.axis.customer.repo

import com.axis.customer.entity.Customer
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface CustomerRepository : ReactiveMongoRepository<Customer, Long> {

}
