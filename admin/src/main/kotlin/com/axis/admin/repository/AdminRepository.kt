package com.axis.admin.repository

import com.axis.admin.entity.Admin
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface AdminRepository : ReactiveMongoRepository<Admin, String> {
    // additional methods can be added here
    fun findByMobileNo(mobileNo: Long): Mono<Admin>
}
