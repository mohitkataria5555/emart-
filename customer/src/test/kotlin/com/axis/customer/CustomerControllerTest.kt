package com.axis.customer


import com.axis.customer.entity.Customer
import com.axis.customer.repo.CustomerRepository

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest(){
    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    val customer1= Customer(
        name="Mohit Kataria",
        mobileNo = 7898872875,
        email = "mohit@gmail.com",
        password = "Mohit@123"
    )
    val customer2=Customer(
        name="MS Dhoni",
        mobileNo = 7777777777,
        email ="msd@gmail.com",
       password =  "Msd@77777",

    )


    @Test
    fun getAllCustomers(){
        customerRepository.saveAll(listOf(customer1, customer2)).collectList().block()
        val response = webTestClient.get()
            .uri("/customers/all")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(Customer::class.java)
            .returnResult().responseBody

        Assertions.assertThat(response).isNotNull
        Assertions.assertThat(response).contains(customer1, customer2)

    }


    @Test
    fun createCustomer(){
        webTestClient.post().uri("/customers/add")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(customer1)
            .exchange()
            .expectStatus().isOk
            .expectBody(Customer::class.java)
            .isEqualTo(customer1)
            .returnResult()
    }


    @Test
    fun getCustomerById(){
        webTestClient.get().uri("/customers/{mobileNo}", customer1.mobileNo)
            .exchange()
            .expectStatus().isOk
            .expectBody(Customer::class.java)
            .returnResult()
            .responseBody
    }

    @Test
    fun deleteCustomerById(){
        webTestClient.delete().uri("/customers/delete/{mobileNo}", customer1.mobileNo)
            .exchange()
            .expectStatus().isOk
            .expectBody(Customer::class.java)
            .returnResult()
            .responseBody
    }
}
