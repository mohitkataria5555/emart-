package com.axis.admin.service

import com.axis.admin.entity.Admin
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface AdminService {
    fun getAllAdmins(): Flux<Admin>
    fun getAdminById(id: String): Mono<Admin>
    fun createAdmin(admin: Admin): Mono<Admin>

    fun deleteAdmin(id: String): Mono<Void>
    fun findByMobileNo(mobileNo: Long): Mono<Admin>
}
