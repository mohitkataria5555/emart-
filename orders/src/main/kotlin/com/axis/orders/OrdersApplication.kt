package com.axis.orders

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class OrdersApplication

fun main(args: Array<String>) {
	runApplication<OrdersApplication>(*args)
}
