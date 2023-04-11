package com.axis.pros.controller

import com.axis.pros.entity.Product
import com.axis.pros.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.net.URI

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/products")
class ProductController(private val productService: ProductService) {

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: String): Mono<ResponseEntity<Product>> {
        return productService.getProductById(id)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @GetMapping("/category/{categoryName}")
    fun getProductsByCategory(@PathVariable categoryName: String): Flux<Product> {
        return productService.getProductsByCategory(categoryName)
    }

    @GetMapping
    fun getAllProducts(): Flux<Product> {
        return productService.getAllProducts()
    }

    @PostMapping
    fun createProduct(@RequestBody product: Product): Mono<ResponseEntity<Product>> {
        return productService.createProduct(product)
            .map { ResponseEntity.created(URI("/api/products/${it.id}")).body(it) }
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: String, @RequestBody product: Product): Mono<ResponseEntity<Product>> {
        return productService.getProductById(id)
            .flatMap { existingProduct ->
                val name = product.name
                 val description = product.description
                val price = product.price
               val categoryName = product.categoryName
                productService.updateProduct(existingProduct)
            }
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: String): Mono<ResponseEntity<Void>> {
        return productService.deleteProduct(id)
            .map { ResponseEntity.noContent().build<Void>() }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }
}
