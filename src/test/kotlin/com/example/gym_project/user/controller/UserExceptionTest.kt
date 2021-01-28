package com.example.gym_project.user.controller

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class UserExceptionTest {

    @Test
    fun `Test ilegal Argumen`(){
        val message = "Error, ilegal argument!"
        val userException = UserException()
        val exception = IllegalArgumentException(message);
        val response = userException.illegalArgumentException(exception)

        Assertions.assertTrue(response is ResponseEntity)
        Assertions.assertTrue(response.statusCode == HttpStatus.INTERNAL_SERVER_ERROR)
        Assertions.assertTrue(response.hasBody())
    }

}