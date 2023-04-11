package com.axis.orders.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date
@Document(collection="orders")
data class Order (
    @Id
    val mobileNo:Long,
    val name:String,
    val price :Double,
    val quantity : Double,
    val totalPrice:Double,

    val imageUrl:String,
    val date:Date
    )