package com.axis.customer

import com.axis.customer.entity.Customer
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CustomerEntityTests {
    val customer1= Customer(1234567890,"Virat Kohli","virat@gmail.com","Virat@123")


    @Test
    fun nameTest(){
        Assertions.assertThat(customer1.name).contains(String())
        Assertions.assertThat(customer1.name).contains("ohli")
    }

 @Test
 fun mobileTest(){
     Assertions.assertThat(customer1.mobileNo>123)
 }
    @Test
    fun emailTest(){
        Assertions.assertThat(customer1.email).contains(String())
        Assertions.assertThat(customer1.email).contains("@gmail.com")
    }

    @Test
    fun passwordTest(){
        Assertions.assertThat(customer1.password).contains(String())
        Assertions.assertThat(customer1.password).contains("@")
    }
    @Test
    fun mobileNoLengthTest(){
        Assertions.assertThat(customer1.mobileNo.toString().length == 10)
    }

}


