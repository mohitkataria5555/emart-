package com.axis.admin.service

import com.axis.admin.entity.Admin
import com.axis.admin.repository.AdminRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class AdminServiceImpl(private val adminRepository: AdminRepository) : AdminService {
    override fun getAllAdmins(): Flux<Admin> {
        return adminRepository.findAll()
    }

    override fun getAdminById(id: String): Mono<Admin> {
        return adminRepository.findById(id)
    }

    override fun createAdmin(admin: Admin): Mono<Admin> {
        return adminRepository.save(admin)
    }



    override fun deleteAdmin(id: String): Mono<Void> {
        return adminRepository.deleteById(id)
    }

    override fun findByMobileNo(mobileNo: Long): Mono<Admin> {
        return adminRepository.findByMobileNo(mobileNo)
    }

}
