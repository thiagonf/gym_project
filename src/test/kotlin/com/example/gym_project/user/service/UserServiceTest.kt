package com.example.gym_project.user.service

import com.example.gym_project.user.model.User
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.boot.test.web.client.TestRestTemplate

import org.springframework.boot.web.server.LocalServerPort

import org.springframework.web.servlet.function.RequestPredicates.path
import org.springframework.http.ResponseEntity

import org.springframework.web.servlet.function.RequestPredicates.path








@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceTest {
    @LocalServerPort
    private var port: Int = 0

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun `Test createUser in the happy path scenario`() {
        val user = User(id = 1, name= "Thiago", email = "thiago@test.com", phone = "9999-9999")
        val responseEntity = restTemplate.postForEntity("http://localhost:$port/users", user, String::class.java)
        assertEquals(201, responseEntity.statusCodeValue)
        assertTrue(user.id.toString() in responseEntity.body.toString())
        assertTrue(user.name in responseEntity.body.toString())
        assertTrue(user.email in responseEntity.body.toString())
        assertTrue(user.phone in responseEntity.body.toString())
    }


}