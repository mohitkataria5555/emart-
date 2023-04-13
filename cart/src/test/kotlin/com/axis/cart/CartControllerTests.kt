package com.axis.cart

import com.axis.cart.entity.Cart
import com.axis.cart.repo.CartRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartControllerTests {
    @Autowired
    private lateinit var webTestClient: WebTestClient
    @Autowired
    private lateinit var cartRepository: CartRepository

    @BeforeEach
    fun setup(){
        cartRepository.deleteAll();
    }

    val cart1= Cart(  name= "Sofa ",
    price= 15000.0,
    quantity= 5.0,
    totalPrice= 75000.0,
    mobileNo=7898872875,
    imageUrl= "https://th.bing.com/th/id/OIP.j2pbGUbBYxaGgymwXhJg5gHaEK?w=318&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7")


    val cart2=Cart(name= "iphone 14",
    price= 80000.0,
    quantity=10.0,
    totalPrice= 800000.0,
    mobileNo= 7898872875,
        imageUrl ="https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-14-pro-finish-select-202209-6-1inch-deeppurple?wid=2560&hei=1440&fmt=p-jpg&qlt=80&.v=1663703840578")

@Test
fun getAllCarts(){
    cartRepository.saveAll(listOf(cart1,cart2)).collectList().block()

    val response = webTestClient.get()
        .uri("/carts/all")
        .exchange()
        .expectStatus().isOk
        .expectBodyList(Cart::class.java)
        .returnResult().responseBody

    Assertions.assertThat(response).isNotNull
    Assertions.assertThat(response).contains(cart1,cart2)
}
    @Test
    fun getCartById(){
        webTestClient.get().uri("/carts/{mobileNo}", cart1.getMobileNo())
            .exchange()
            .expectStatus().isOk
            .expectBody(Cart::class.java)
            .returnResult().responseBody
    }
    @Test
    fun deleteCartById(){
        webTestClient.delete().uri("/carts/delete/{mobileNo}",cart1.getMobileNo())
            .exchange()
            .expectStatus().isOk
            .expectBody(Cart::class.java)
            .returnResult().responseBody
    }

    @Test
    fun createCart(){
        webTestClient.post().uri("/carts/add")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(cart1)
            .exchange()
            .expectStatus().isCreated
            .expectBody(Cart::class.java)
            .isEqualTo(cart1)
            .returnResult()
    }



}


