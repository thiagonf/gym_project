package com.example.gym_project.exception

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.lang.IllegalArgumentException

class ErrorResponseTests {

    @Test
    fun `create instance from ErrorResponse`() {
        val error = ErrorResponse()
        Assertions.assertNotNull(error)
    }

    @Test
    fun `Create error response`() {
        val status = HttpStatus.INTERNAL_SERVER_ERROR
        val message = "Internal error"
        val exception = IllegalArgumentException(message)
        val error = ErrorResponse()

        val response = error.generateErrorResponse(status, message, exception)

        Assertions.assertTrue(response is ResponseEntity)
        Assertions.assertTrue(error.code == status.value())
        Assertions.assertTrue(error.status == status.toString())
        Assertions.assertTrue(error.message == message)
        Assertions.assertNotNull(error.timestamp)
    }
}