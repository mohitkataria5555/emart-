package com.axis.pros.repository

import com.axis.pros.entity.Product
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux


@Repository
interface ProductRepository : ReactiveMongoRepository<Product, String> {

    fun findByCategoryName(categoryName: String): Flux<Product>

}
