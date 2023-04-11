package com.axis.pros

import com.axis.pros.controller.ProductController
import com.axis.pros.entity.Product
import com.axis.pros.repository.ProductRepository
import com.axis.pros.service.ProductService
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Autowired
    private lateinit var productRepository: ProductRepository


    val product1=Product(
        "P01",
        "iphone 14",
        "Apple Product",
        80000.0,
        "Electronics",
        10,
        "https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-14-pro-finish-select-202209-6-1inch-deeppurple?wid=2560&hei=1440&fmt=p-jpg&qlt=80&.v=1663703840578"
    )
    val product2=Product(
        "P02",
        "Shirt",
        "Zara Product",
        1999.0,
        "Fashion",
        10,
        "https://static.zara.net/photos///2023/V/0/2/p/7545/522/250/2/w/750/7545522250_1_1_1.jpg?ts=1680261691875"
    )


    @Test
    fun getProductById(){
        webTestClient.get().uri("/api/products/{P01}", product1.id)
            .exchange()
            .expectStatus().isOk
            .expectBody(Product::class.java)
            .returnResult()
            .responseBody
    }

    @Test
    fun getAllProducts() {
        productRepository.saveAll(listOf(product1,product2)).collectList().block()
        val response = webTestClient.get()
            .uri("/api/products")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(Product::class.java)
            .returnResult().responseBody

        Assertions.assertThat(response).isNotNull
        Assertions.assertThat(response).contains(product1,product2)
    }




    @Test
    fun createProduct(){
        webTestClient.post().uri("/api/products")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(product1)
            .exchange()
            .expectStatus().isCreated
            .expectBody(Product::class.java)
            .isEqualTo(product1)
            .returnResult()
    }



    @Test
    fun deleteProductById(){
        webTestClient.delete().uri("/api/products/{P01}", product1.id)
            .exchange()
            .expectStatus().isOk
            .expectBody(Product::class.java)
            .returnResult()
            .responseBody
    }
}






