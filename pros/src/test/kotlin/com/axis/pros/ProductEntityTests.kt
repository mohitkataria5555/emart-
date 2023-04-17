package com.axis.pros

import com.axis.pros.entity.Product
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class ProductEntityTests {
    val product1= Product("P99","Oneplus Nord","Oneplus Product",35000.0,"Electronics",1,"bjbund")

    @Test
    fun idTest(){
        Assertions.assertThat(product1.id).contains(String())
        Assertions.assertThat(product1.id).contains("P")
    }
    @Test
    fun nameTest(){
        Assertions.assertThat(product1.name).contains(String())
        Assertions.assertThat(product1.name).contains("plus")

    }
    @Test
    fun categoryTest(){
        Assertions.assertThat(product1.categoryName=="Electronics")
    }

}