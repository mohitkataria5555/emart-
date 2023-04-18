package com.axis.cart.entity


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="carts")
class Cart {
    @Id
    private var mobileNo: Long
    private var name: String
    private var price: Double
    private var quantity: Double
    private var totalPrice: Double
    private var imageUrl: String

    constructor(mobileNo: Long, name: String, price: Double, quantity: Double, totalPrice: Double, imageUrl: String) {
        this.mobileNo = mobileNo
        this.name = name
        this.price = price
        this.quantity = quantity
        this.totalPrice = totalPrice
        this.imageUrl = imageUrl
    }



    fun getMobileNo(): Long {
        return mobileNo
    }

    fun setMobileNo(mobileNo: Long) {
        this.mobileNo = mobileNo
    }

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getPrice(): Double {
        return price
    }

    fun setPrice(price: Double) {
        this.price = price
        this.totalPrice = price * quantity
    }

    fun getQuantity(): Double {
        return quantity
    }

    fun setQuantity(quantity: Double) {
        this.quantity = quantity
        this.totalPrice = price * quantity
    }

    fun getTotalPrice(): Double {
        return totalPrice
    }
    fun setTotalPrice(totalPrice: Double) {
        this.totalPrice=totalPrice
    }


    fun getImageUrl(): String {
        return imageUrl
    }

    fun setImageUrl(imageUrl: String) {
        this.imageUrl = imageUrl
    }
}
