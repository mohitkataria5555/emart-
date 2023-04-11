package com.axis.pros.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="product")
data class Product(
    @Id val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val categoryName: String,
    val quantity: Int,
    val imageUrl: String
)
