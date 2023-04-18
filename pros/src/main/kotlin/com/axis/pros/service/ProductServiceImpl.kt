package com.axis.pros.service

import com.axis.pros.entity.Product
import com.axis.pros.repository.ProductRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {

    override fun getProductById(id: String): Mono<Product> {
        return productRepository.findById(id)
    }

    override fun getProductsByCategory(categoryName: String): Flux<Product> {
        return productRepository.findByCategoryName(categoryName)
    }

    override fun getAllProducts(): Flux<Product> {
        return productRepository.findAll()
    }

    override fun createProduct(product: Product): Mono<Product> {
        return productRepository.save(product)
    }

    override fun updateProduct(id: String, product: Product): Mono<Product> {
        return productRepository.findById(id)
            .flatMap { existingProduct ->

                existingProduct.setPrice(product.getPrice())

                existingProduct.setQuantity(product.getQuantity())
                existingProduct.setImageUrl(product.getImageUrl())
                productRepository.save(existingProduct)
            }
    }

    override fun deleteProduct(id: String): Mono<Void> {
        return productRepository.deleteById(id)
    }
}