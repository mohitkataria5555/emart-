package com.axis.customer.entity


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="users")
data class Customer(

    @Id
    //val id: ObjectId = ObjectId.get(),
    val mobileNo:Long,
    val name:String,


    val email:String,
    val password:String,



    ) {
    override fun toString(): String {
        return "Customer( name='$name', mobileNo=$mobileNo, email='$email', password='$password')"
    }
}