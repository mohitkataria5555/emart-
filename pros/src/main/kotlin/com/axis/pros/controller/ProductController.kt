package com.axis.pros.controller

import com.axis.pros.entity.Product
import com.axis.pros.service.ProductService
import org.springframework.http.HttpStatus
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

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@RequestBody product: Product): Mono<Product> {
        return productService.createProduct(product)
    }

    @PutMapping("/update/{id}")
    fun updateCart(@PathVariable id: String, @RequestBody product: Product): Mono<Product> {
        return productService.updateProduct(id, product)
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: String): Mono<ResponseEntity<Void>> {
        return productService.deleteProduct(id)
            .map { ResponseEntity.noContent().build<Void>() }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }
}
