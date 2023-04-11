package com.axis.admin.controller

import com.axis.admin.entity.Admin
import com.axis.admin.service.AdminService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@CrossOrigin("")
@RequestMapping("/admins")
class AdminController(private val adminService: AdminService) {

    @GetMapping("/all",produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllAdmins(): Flux<Admin> {
        return adminService.getAllAdmins()
    }

    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAdminById(@PathVariable id: String): Mono<Admin> {
        return adminService.getAdminById(id)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createAdmin(@RequestBody admin: Admin): Mono<Admin> {
        return adminService.createAdmin(admin)
    }



    @DeleteMapping("/delete/{id}")
    fun deleteAdmin(@PathVariable id: String): Mono<Void> {
        return adminService.deleteAdmin(id)
    }

    @GetMapping("/mobile/{mobileNo}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findByMobileNo(@PathVariable mobileNo: Long): Mono<Admin> {
        return adminService.findByMobileNo(mobileNo)
    }
}
