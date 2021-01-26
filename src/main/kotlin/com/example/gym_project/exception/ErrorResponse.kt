package com.example.gym_project.exception

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.http.HttpStatus
import java.util.*

class ErrorResponse(
    status: HttpStatus,
    val message: String,
    var stackTrace: String? = null
) {

    val code: Int;
    val status: String;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
    val timestamp: Date

    init {
        this.timestamp = Date()
        this.code = status.value()
        this.status = status.toString()
    }
}