package com.axis.orders


import com.axis.orders.entity.Order
import com.axis.orders.repository.OrderRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import java.text.SimpleDateFormat

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTests {
    @Autowired
    private lateinit var webTestClient: WebTestClient
    @Autowired
    private lateinit var orderRepository: OrderRepository


    val dateFormat =  SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    val date = dateFormat.parse("2023-04-12T11:43:51.249+00:00")

    val order1= Order( mobileNo= 1234567893,
    name= "Sofa",
    price= 20000.0,
    quantity= 1.0,
    totalPrice= 20000.0,
    imageUrl= "https://www.ikea.com/in/en/images/products/groenlid-cover-for-4-seat-sofa-with-chaise-longue-ljungen-light-green__0747896_pe744765_s5.jpg?f=s",
    date= date)


    @Test
    fun getOrderById(){
        webTestClient.get().uri("/orders/{mobileNo}", order1.mobileNo)
            .exchange().expectStatus().isOk.expectBody(Order::class.java).returnResult().responseBody}

    @Test
    fun createOrder(){
        webTestClient.post().uri("/orders")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(order1)
            .exchange()
            .expectStatus().isCreated
            .expectBody(Order::class.java)
            .isEqualTo(order1)
            .returnResult()

    }
    @Test
    fun deleteOrderById(){
        webTestClient.delete().uri("/orders/{mobileNo}",order1.mobileNo)
            .exchange().expectStatus().isOk.expectBody(Order ::class.java).returnResult().responseBody
    }
    @Test
    fun deleteAllOrders(){


        orderRepository.saveAll(listOf(order1)).collectList().block()

        webTestClient.delete().uri("/orders")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(Void::class.java)

        val orders = orderRepository.findAll().collectList().block()

        Assertions.assertThat(orders).isEmpty()

    }






}


