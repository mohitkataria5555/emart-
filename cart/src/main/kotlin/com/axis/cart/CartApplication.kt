package com.axis.cart

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class CartApplication

fun main(args: Array<String>) {
	runApplication<CartApplication>(*args)
}
