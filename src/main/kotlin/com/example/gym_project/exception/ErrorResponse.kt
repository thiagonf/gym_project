package com.example.gym_project.exception

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.*

class ErrorResponse {

    var code: Int = 0;
    lateinit var status: String;
    lateinit var message: String;
    lateinit var exception: Exception;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
    lateinit var timestamp: Date

    fun generateErrorResponse(
        status: HttpStatus,
        message: String,
        exception: Exception
    ): ResponseEntity<ErrorResponse> {
        this.timestamp = Date()
        this.code = status.value()
        this.status = status.toString()
        this.message = message
        this.exception = exception

        return ResponseEntity(this, status)
    }
}