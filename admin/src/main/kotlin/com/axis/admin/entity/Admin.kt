package com.axis.admin.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document("admin")
data class Admin(

    val mobileNo: String,
    val email: String,
    val password: String
)