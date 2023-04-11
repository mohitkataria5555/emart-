package com.axis.pros.service

import com.axis.pros.entity.Product
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ProductService {
    fun getProductById(id: String): Mono<Product>
    fun getProductsByCategory(categoryName: String): Flux<Product>
    fun getAllProducts(): Flux<Product>
    fun createProduct(product: Product): Mono<Product>
    fun updateProduct(product: Product): Mono<Product>
    fun deleteProduct(id: String): Mono<Void>
}