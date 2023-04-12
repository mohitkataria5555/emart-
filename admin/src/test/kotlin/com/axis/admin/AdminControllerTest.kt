package com.axis.admin

import com.axis.admin.entity.Admin
import com.axis.admin.repository.AdminRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminControllerTest {


    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Autowired
    private lateinit var adminRepository: AdminRepository


    val admin1 = Admin("1800101020","admin@gmail.com","Admin@123")

    @Test
    fun getAllAdmins(){
        adminRepository.saveAll(listOf(admin1)).collectList().block()
        val response = webTestClient.get()
            .uri("/admins/all")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(Admin::class.java)
            .returnResult().responseBody

        Assertions.assertThat(response).isNotNull
        Assertions.assertThat(response).contains(admin1)

    }




    @Test
    fun createAdmin(){
        webTestClient.post().uri("/admins")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(admin1)
            .exchange()
            .expectStatus().isOk
            .expectBody(Admin::class.java)
            .isEqualTo(admin1)
            .returnResult()
    }
    @Test
    fun getAdminByMobileNo(){
        webTestClient.get().uri("/admins/mobile/{mobileNo}",admin1.mobileNo)
            .exchange()
            .expectStatus().isOk
            .expectBody(Admin::class.java)
            .returnResult()
            .responseBody
    }
    }
