package com.axis.pros.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="product")
class Product(
    @Id val id: String,
    val name: String,
    val description: String,
    private var price: Double,
   val categoryName: String,
    private var quantity: Int,
    private var imageUrl: String
) {
    // Getter and setter methods for the id property


    // Getter and setter methods for the name property


    // Getter and setter methods for the description property


    // Getter and setter methods for the price property
    fun getPrice(): Double {
        return price
    }
    fun setPrice(newPrice: Double) {
        price = newPrice
    }

    // Getter and setter methods for the categoryName property


    // Getter and setter methods for the quantity property
    fun getQuantity(): Int {
        return quantity
    }
    fun setQuantity(newQuantity: Int) {
        quantity = newQuantity
    }

    // Getter and setter methods for the imageUrl property
    fun getImageUrl(): String {
        return imageUrl
    }
    fun setImageUrl(newImageUrl: String) {
        imageUrl = newImageUrl
    }
}

