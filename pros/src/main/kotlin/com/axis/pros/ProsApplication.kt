package com.axis.pros

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class ProsApplication

fun main(args: Array<String>) {
	runApplication<ProsApplication>(*args)
}
